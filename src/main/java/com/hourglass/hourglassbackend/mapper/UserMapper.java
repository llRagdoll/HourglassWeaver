package com.hourglass.hourglassbackend.mapper;

import com.hourglass.hourglassbackend.dto.RecentTaskDTO;
import com.hourglass.hourglassbackend.dto.TaskDistributionDTO;
import com.hourglass.hourglassbackend.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from User where id = #{id}")
    User getUserById(Integer id);

    @Select("select * from User where name = #{username}")
    User getUserByName(String username);

    @Insert("insert into User(name, password,created_time)"+
            "values(#{username}, #{md5Password}, now())")
    void add(String username, String md5Password);

    @Update("update User set name=#{name},email=#{email},phone=#{phone},avatar=#{avatar} where id=#{id}")
    void update(String name, String email, String phone, String avatar, Integer id);

    @Update("update User set avatar=#{avatarUrl} where id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);


    @Select("SELECT " +
            "(SELECT COUNT(*) FROM Task WHERE status = '待办') AS TODONum, " +
            "(SELECT COUNT(*) FROM Task WHERE status = '进行中') AS DOINGNum, " +
            "(SELECT COUNT(*) FROM Task WHERE status = '已完成' AND user_id=#{id}) AS DONENum")
    TaskDistributionDTO getTaskDistribution(Integer id);

    @Select("SELECT name, status, priority, due_date " +
            "FROM Task " +
            "WHERE user_id = #{id} " +
            "  AND due_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 1 WEEK) " +
            "ORDER BY due_date DESC "
            )
    List<RecentTaskDTO> getRecentTask(Integer id);


//    @Select("SELECT " +
//            "(SELECT name FROM Task WHERE user_id=#{id} ORDER BY created_time DESC LIMIT 1) AS recentTaskName, " +
//            "(SELECT status FROM Task WHERE user_id=#{id} ORDER BY created_time DESC LIMIT 1) AS recentTaskStatus, " +
//            "(SELECT created_time FROM Task WHERE user_id=#{id} ORDER BY created_time DESC LIMIT 1) AS recentTaskTime"
//    Object getRecentTask(Integer id);


}

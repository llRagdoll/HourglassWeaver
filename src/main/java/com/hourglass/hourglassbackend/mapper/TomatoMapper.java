package com.hourglass.hourglassbackend.mapper;

import com.hourglass.hourglassbackend.entity.Tomato;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TomatoMapper {

    @Select("SELECT * FROM Tomato WHERE user_id = #{userId} ORDER BY end_time DESC")
    List<Tomato> getTomatoList(Integer userId);

    @Select("SELECT COUNT(*) FROM Tomato WHERE DATE(end_time) = CURDATE()" +
            " AND user_id = #{userId}")
    Integer getTodayCount(Integer userId);

    @Select("SELECT COUNT(*) FROM Tomato WHERE user_id = #{userId}")
    Integer getTotalCount(Integer userId);

    @Select("SELECT COALESCE(SUM(duration), 0) FROM Tomato WHERE DATE(end_time) = CURDATE() AND user_id = #{userId}")
    Integer getTodayTime(Integer userId);


    @Select("SELECT COALESCE(SUM(duration), 0) FROM Tomato WHERE user_id = #{userId}")
    Integer getTotalTime(Integer id);


    @Insert("insert into Tomato(name, description, duration, status, user_id, end_Time) " +
            "VALUES(#{name}, #{description}, #{duration}, #{status}, #{id}, now())")
    Integer createTomato(String name, String description, Integer duration, Integer status, Integer id);
}

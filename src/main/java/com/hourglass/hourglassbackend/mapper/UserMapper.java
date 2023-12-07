package com.hourglass.hourglassbackend.mapper;

import com.hourglass.hourglassbackend.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from User where id = #{id}")
    User getUserById(Integer id);

    @Select("select * from User where name = #{username}")
    User getUserByName(String username);

    @Insert("insert into User(name, password,created_time)"+
            "values(#{username}, #{md5Password}, now())")
    void add(String username, String md5Password);

    @Update("update User set name=#{name}, email=#{email}, phone=#{phone} where id=#{id}")
    void update(User user);

    @Update("update User set avatar=#{avatarUrl} where id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);
}

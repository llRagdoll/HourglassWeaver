package com.hourglass.hourglassbackend.mapper;

import com.hourglass.hourglassbackend.entity.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {
    @Insert("insert into task (name, description, due_date,tag,priority, status, user_id)"+
            " values (#{name}, #{description}, #{dueDate}, #{tag}, #{priority}, #{status}, #{userId})")
    void add(Task task);
}

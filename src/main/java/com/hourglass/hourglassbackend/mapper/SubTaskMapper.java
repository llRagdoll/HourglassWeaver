package com.hourglass.hourglassbackend.mapper;

import com.hourglass.hourglassbackend.entity.SubTask;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SubTaskMapper {

    @Insert("INSERT INTO SubTask (name, task_id) VALUES (#{name}, #{taskId})")
    Integer createSubTask(String name, Integer taskId);


    @Delete("DELETE FROM SubTask WHERE id = #{subTaskId}")
    Integer completeSubTask(Integer subTaskId);

    @Select("SELECT * FROM SubTask WHERE task_id = #{taskId}")
    List<SubTask> getSubTaskList(Integer taskId);
}

package com.hourglass.hourglassbackend.mapper;

import com.hourglass.hourglassbackend.dto.HistoryTaskDTO;
import com.hourglass.hourglassbackend.dto.TaskUndoneDTO;
import com.hourglass.hourglassbackend.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface TaskMapper {
    @Insert("insert into task (name, description, start_date,due_date,label,priority, status, user_id)"+
            " values (#{name}, #{description}, #{startDate},#{dueDate}, #{label}, #{priority}, #{status}, #{userId})")
    void add(Task task);

    @Select("select * from task where user_id = #{id} and status != '历史' and due_date >= current_date()")
    List<Task> getTaskList(Integer id);


    @Delete("delete from task where id = #{taskId}")
    Integer delete(Integer taskId);

    @Select("select * from task where id = #{taskId}")
    Task getTaskById(Integer taskId);


    @Update("update task set name = #{name}, description = #{description}, start_date = #{startDate}, due_date = #{dueDate}, label = #{label}, priority = #{priority}, status = #{status} where id = #{id}")
    Integer update(String name, String description, String startDate, String dueDate, String label, String priority, String status, Integer id);


    @Select("select name from task where user_id = #{id} and status IN ('待办', '进行中')")
    List<String> getTaskUndone(Integer id);

    @Select("select name,start_date,due_date,status,priority from task where user_id = #{id} and status = ('已完成') and due_date < current_date()")
    List<HistoryTaskDTO> getHistoryTask(Integer id);


    @Select("select id,name,due_date from task where user_id = #{id} and status != ('已完成') and due_date < current_date()")
    List<TaskUndoneDTO> getOverdueTask(Integer id);


    @Update("update task set status = '已完成' where id = #{taskId}")
    Integer completeOverdueTask(Integer id, Integer taskId);


    @Select("select due_date from task where user_id = #{id}")
    List<Date> getAllTaskDate(Integer id);

    @Select("select * from task where user_id = #{id} and status != '历史'")
    List<Task> getAllTaskList(Integer id);

    @Update("update task set status = #{status} where id = #{taskId}")
    Integer updateTaskStatus(Integer taskId, String status);
}

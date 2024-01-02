package com.hourglass.hourglassbackend.mapper;

import com.hourglass.hourglassbackend.dto.NoteDTO;
import com.hourglass.hourglassbackend.entity.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select("SELECT id,create_time,update_time,title,tag FROM Note WHERE user_id = #{userId}")
    List<NoteDTO> getNoteList(Integer userId);

    @Select("SELECT text FROM Note WHERE id = #{noteId}")
    String getNoteById(Integer noteId);

    @Delete("DELETE FROM Note WHERE id = #{noteId}")
    Integer deleteNoteById(Integer noteId);

    @Insert("INSERT INTO Note (user_id,title,tag,text,create_time,update_time) VALUES (#{id},#{title},#{tag},#{text},now(),now())")
    Integer createNote(Integer id, String title, String tag, String text);

    @Update("UPDATE Note SET title = #{title}, tag = #{tag}, text = #{text}, update_time = now() WHERE id = #{noteId}")
    Integer updateNote(Integer noteId, String title, String tag, String text);


    @Insert("INSERT INTO Note (user_id,task_id,title,tag,text,create_time,update_time) VALUES (#{id},#{taskId},#{title},#{tag},#{text},now(),now())")
    Integer createNoteFromTask(Integer id, Integer taskId, String title, String tag, String text);


    @Select("SELECT * FROM Note WHERE user_id = #{id} AND task_id = #{taskId}")
    List<Note> getNoteFromTask(Integer id, Integer taskId);
}

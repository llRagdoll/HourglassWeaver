package com.hourglass.hourglassbackend.controller;


import com.hourglass.hourglassbackend.dto.NoteDTO;
import com.hourglass.hourglassbackend.entity.Note;
import com.hourglass.hourglassbackend.entity.Result;
import com.hourglass.hourglassbackend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.awt.SystemColor.text;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @GetMapping("/getNoteList")
    public Result getNoteList(){
        List<NoteDTO> noteList=noteService.getNoteList();
        if(noteList==null){
            return Result.error("获取笔记列表失败");
        }
        else{
            return Result.success(noteList);
        }
    }

    @GetMapping("/getNote")
    public Result getNote(Integer noteId){
        String text=noteService.getNoteById(noteId);
        if(text==null){
            return Result.error("获取笔记失败");
        }
        else{
            return Result.success(text);
        }
    }

    @PostMapping("/createNote")
    public Result createNote(String title,String tag,String text){
        System.out.println(title);
        System.out.println(tag);
        System.out.println(text);
        Integer code=noteService.createNote(title,tag,text);
        System.out.println("code:");
        System.out.println(code);
        if(code==0){
            return Result.error("创建笔记失败");
        }
        else{
            return Result.success("创建笔记成功");
        }

    }

    @PostMapping("/deleteNote")
    public Result deleteNote(Integer noteId){
        System.out.println(noteId);
        System.out.println(noteId);
        System.out.println(noteId);
        Integer result=noteService.deleteNoteById(noteId);
        if(result==0){
            return Result.error("删除笔记失败");
        }
        else{
            return Result.success("删除笔记成功");
        }

    }

    @PostMapping("/updateNote")
    public Result updateNote(Integer noteId,String title,String tag,String text){
        System.out.println(noteId);
        System.out.println(title);
        System.out.println(tag);
        System.out.println(text);
        Integer code=noteService.updateNote(noteId,title,tag,text);
        if(code==0){
            return Result.error("更新笔记失败");
        }
        else{
            return Result.success("更新笔记成功");
        }

    }

    @PostMapping("createNoteFromTask")
    public Result createNoteFromTask(Integer taskId,String title,String tag,String text){
        Integer code=noteService.createNoteFromTask(taskId,title,tag,text);
        if(code==0){
            return Result.error("创建笔记失败");
        }
        else{
            return Result.success("创建笔记成功");
        }
    }

    @GetMapping("/getNoteFromTask")
    public Result getNoteFromTask(Integer taskId){
        List<Note> notes=noteService.getNoteFromTask(taskId);
        if(notes==null){
            return Result.error("获取笔记失败");
        }
        else{
            return Result.success(notes);
        }
    }
}

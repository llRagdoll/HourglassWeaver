package com.hourglass.hourglassbackend.service.impl;

import com.hourglass.hourglassbackend.dto.NoteDTO;
import com.hourglass.hourglassbackend.entity.Note;
import com.hourglass.hourglassbackend.mapper.NoteMapper;
import com.hourglass.hourglassbackend.service.NoteService;
import com.hourglass.hourglassbackend.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Override
    public List<NoteDTO> getNoteList() {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        List<NoteDTO> noteList=noteMapper.getNoteList(id);
        System.out.println(noteList);
        return noteList;
    }

    @Override
    public String getNoteById(Integer noteId) {
        String text=noteMapper.getNoteById(noteId);
        System.out.println(text);
        return text;
    }

    @Override
    public Integer deleteNoteById(Integer noteId) {
        Integer result=noteMapper.deleteNoteById(noteId);
        System.out.println(result);
        return result;
    }

    @Override
    public Integer createNote(String title, String tag, String text) {
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        Integer result=noteMapper.createNote(id,title,tag,text);
        System.out.println("result:");
        System.out.println(result);
        return result;
    }

    @Override
    public Integer createNoteFromTask(Integer taskId, String title, String tag, String text) {
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        Integer result=noteMapper.createNoteFromTask(id,taskId,title,tag,text);
        System.out.println("result:");
        System.out.println(result);
        return result;
    }

    @Override
    public Integer updateNote(Integer noteId, String title, String tag, String text) {
        Integer result=noteMapper.updateNote(noteId,title,tag,text);
        System.out.println(result);
        return result;
    }

    @Override
    public List<Note> getNoteFromTask(Integer taskId) {
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer id=(Integer)map.get("id");
        List<Note> notes=noteMapper.getNoteFromTask(id,taskId);
        System.out.println(notes);
        return notes;
    }
}

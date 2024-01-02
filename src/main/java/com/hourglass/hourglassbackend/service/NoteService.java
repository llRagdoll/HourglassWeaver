package com.hourglass.hourglassbackend.service;

import com.hourglass.hourglassbackend.dto.NoteDTO;
import com.hourglass.hourglassbackend.entity.Note;

import java.util.List;

public interface NoteService {

    List<NoteDTO> getNoteList();

    String getNoteById(Integer noteId);

    Integer deleteNoteById(Integer noteId);

    Integer createNote(String title, String tag, String text);

    Integer updateNote(Integer noteId,String title, String tag, String text);

    Integer createNoteFromTask(Integer taskId, String title, String tag, String text);

    List<Note> getNoteFromTask(Integer taskId);
}

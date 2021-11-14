package com.vue.dao.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vue.dao.NoteBookService;
import com.vue.dao.mapper.NoteBookMapper;
import com.vue.entity.NoteBook;
import com.vue.entity.NoteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteBookServiceImpl extends ServiceImpl<NoteBookMapper,NoteBook> implements NoteBookService {
    @Autowired
    NoteBookMapper noteBookMapper;
    public int addNoteAndType(String noteType) {
      return   noteBookMapper.addNoteAndType(noteType);
    }

    public List<NoteBook> getNoteBooks() {
        return noteBookMapper.getNoteBooks();
    }

    public List<NoteType> getNoteTypes() {
        return noteBookMapper.getNoteTypes();
    }

    public int insertNoteBook(NoteBook noteBook) {
        return noteBookMapper.insertNoteBook(noteBook);
    }
}

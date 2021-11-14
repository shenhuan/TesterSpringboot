package com.vue.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vue.entity.Emp;
import com.vue.entity.NoteBook;
import com.vue.entity.NoteType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoteBookMapper extends BaseMapper<NoteBook> {
    int addNoteAndType(String noteType);

    List<NoteBook> getNoteBooks();

    List<NoteType> getNoteTypes();

    int insertNoteBook(NoteBook noteBook);
}

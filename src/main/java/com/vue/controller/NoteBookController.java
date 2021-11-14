package com.vue.controller;

import com.vue.dao.impl.NoteBookServiceImpl;
import com.vue.entity.Book;
import com.vue.entity.NoteBook;
import com.vue.entity.NoteType;
import com.vue.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/noteBook")
public class NoteBookController {
    @Autowired
    NoteBookServiceImpl noteBookServiceImpl;
    /**
     * 添加笔记和笔记类型
     */
    @RequestMapping(value = "/addNoteAndType",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addNoteAndType(String noteType){
        System.out.println("addNoteAndType====》"+noteType);
      int result = noteBookServiceImpl.addNoteAndType(noteType);
      if(result != 1){
          return ResponseData.error("数据库插入失败");
      }
        return ResponseData.success();
    }


    /**
     * 获取笔记列表
     */
    @RequestMapping(value = "/getNote",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getNoteBooks(){
        List<NoteBook> noteBooks = noteBookServiceImpl.getNoteBooks();

        return ResponseData.success(noteBooks);
    }

    /**
     * 获取笔记类型
     */
    @RequestMapping(value = "/getNoteType",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getNoteType(){
        List<NoteType> noteBooks = noteBookServiceImpl.getNoteTypes();
        return ResponseData.success(noteBooks);
    }

    /**
     * 添加笔记
     */
    @RequestMapping(value = "/insertNoteBook",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData insertNoteBook(@RequestBody NoteBook noteBook){
        System.out.println("insertNoteBook====》"+noteBook.getCreateDate());
        int result = noteBookServiceImpl.insertNoteBook(noteBook);
        if(result!=1){
           return ResponseData.error("插入错误");
        }
        return ResponseData.success();
    }


    /**
     * 这是一个json的入参
     */
    @RequestMapping(value = "/insertNoteBookJsonss",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseData insertNoteBookJson(@RequestBody NoteBook noteBook){
        System.out.println("insertNoteBook====》"+noteBook.toString());
//        int result = noteBookServiceImpl.insertNoteBook(noteBook);
//        if(result!=1){
//            return ResponseData.error("插入错误");
//        }
        return ResponseData.success();
    }
}

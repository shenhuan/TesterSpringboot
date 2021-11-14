package com.vue.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vue.dao.BookService;
import com.vue.dao.impl.BookServiceImpl;
import com.vue.entity.Book;
import com.vue.entity.Person;
import com.vue.result.ResponseData;
import com.vue.utils.RedisUtil;
import com.vue.utils.pageParams.PageResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    PageResult pageResult = new PageResult();
//    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    /**
     * @return java.util.List<com.apgblogs.firstspringboot.entity.TUserEntity>
     * @description 查询所有书籍
     * @author xiaomianyang
     * @date 2019-06-13 16:05
     */

    @RequestMapping(value = "/getBookList")
    @ResponseBody
    public ResponseData getAllBook(Integer pageNum, Integer pageSize,String bookName) {

        System.out.println("redisTemplate===>"+redisTemplate+";   redisUtil===>"+redisUtil);
        pageResult = bookService.getBookListByPage(pageNum,pageSize,bookName);
        return ResponseData.success(pageResult);
    }

    /**
     * 添加图书
     */
    @RequestMapping(value = "/insertBook",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addBook(Book book){
      int result = bookService.insertBook(book);
        if(result==0){
            return ResponseData.error("数据插失败");
        }
        return ResponseData.success();
    }

    //删除
    @RequestMapping(value = "/deleteBook",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData deleteBook(int id){
        int delete = bookService.deleteBook(id);
        if(delete == 0){
            return ResponseData.error("书籍"+id+"失败");
        }
        return ResponseData.success();
    }

    //修改
    @RequestMapping(value = "/updateBook",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData updateBook(Book book){

        int update=bookService.updateBook(book);
        if(update == 0){
            return ResponseData.error("修改失败");
        }
        return ResponseData.success();
    }
}


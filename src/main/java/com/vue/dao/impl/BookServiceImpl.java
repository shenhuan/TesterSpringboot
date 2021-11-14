package com.vue.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vue.entity.Book;
import com.vue.dao.BookService;
import com.vue.dao.mapper.BookMapper;
import com.vue.result.ResponseData;
import com.vue.utils.pageParams.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 需要在接口实现类中使用@Service注解，才能被SpringBoot扫描，在Controller中使用@Authwired注入
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private BookMapper bookMapper ;

    PageResult pageResult = new PageResult();
    @Override
    public PageResult getBookListByPage(Integer pageNum, Integer pageSize, String bookName) {
        //创建Page对象
        Page<Book> userPage = new Page<Book>(pageNum, pageSize);
        //构建条件
        QueryWrapper<Book> wrapper = new QueryWrapper<Book>();
        System.out.println("bookName=="+bookName);
        if(null != bookName&&!bookName.equals("")){
            wrapper.like("name",bookName);
        }
        //直接传wrapper，或不传wrapper传一个实体或Map,wrapper在Service中定义
        IPage<Book> iPage = bookMapper.getBookListByPage(userPage, wrapper);
        pageResult.setList(iPage.getRecords());
        pageResult.setTotal(iPage.getTotal());
        pageResult.setPageSize(iPage.getSize());
        pageResult.setPageNum(iPage.getPages());
        return pageResult;
    }

    @Override
    public int insertBook(Book book) {
        int result =0;
        if(null != book.getName()&&!book.getName().equals("")
                &&null != book.getAuthor() && !book.getAuthor().equals("")
                && null != book.getPrice()&&!book.getPrice().equals("")) {
           return bookMapper.insertBook(book);
        }
        return result;
    }

    @Override
    public int deleteBook(int id) {
        int result = bookMapper.deleteBook(id);
        return result;
    }

    @Override
    public int updateBook(Book book) {
        int result = bookMapper.updateBook(book);
        return result;
    }
}

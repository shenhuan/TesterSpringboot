package com.vue.dao;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vue.entity.Book;
import com.vue.result.ResponseData;
import com.vue.utils.pageParams.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService extends IService<Book> {
    PageResult getBookListByPage(Integer pageNum, Integer pageSize, String bookName);
    int insertBook(Book book);

    int updateBook(Book book);

    int deleteBook(int id);
}

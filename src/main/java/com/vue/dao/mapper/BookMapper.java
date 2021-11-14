package com.vue.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vue.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
//直接继承baseMapper可以省略xml的编写，其实也可以通过xml自定义sql查询，不要忘记写自定义方法就行
import java.util.List;
@Mapper
public interface BookMapper extends BaseMapper<Book> {
        Page<Book> getBookListByPage(Page page, @Param("query") Object obj);

        int insertBook(Book book);

        int deleteBook(int id);

        int updateBook(Book book);
}

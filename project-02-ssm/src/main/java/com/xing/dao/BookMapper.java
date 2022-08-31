package com.xing.dao;

import com.xing.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    // 增加一本书
    int addBook(Books books);

    // 删除一本书
    int deleteBookById(@Param("bookID") int id);

    // 更新Book
    int updateBook(Books books);

    // 根据id查询书籍
    Books queryBookById(@Param("bookID") int id);

    //查询全部书籍
    List<Books> allBook();

    //新增搜索的功能方法
    Books queryBookByName(@Param("bookName") String bookName);
}

package com.xing.service;

import com.xing.pojo.Books;

import java.util.List;

public interface BookService {

    // 增加一本书
    int addBook(Books books);

    // 删除一本书
    int deleteBookById(int id);

    // 更新书
    int updateBook(Books books);

    // 根据id查询书籍
    Books queryBookById(int id);

    // 查询全部书籍
    List<Books> allBook();

    Books queryBookByName(String bookName);
}

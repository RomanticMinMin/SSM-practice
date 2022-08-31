package com.xing.mytest;

import com.xing.dao.BookMapper;
import com.xing.pojo.Books;
import com.xing.service.BookService;
import com.xing.service.impl.BookServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {


//    @Autowired
//    private BookService bookService;

    @Test   //测试显示全部书籍
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper bean = context.getBean(BookMapper.class);
        List<Books> list = bean.allBook();
        for (Books books : list) {
            System.out.println(books);
        }
//        List<Books> list1 = bookService.allBook();
//        for (Books books1 : list1) {
//            System.out.println(books1);
//            System.out.println("ccc");
//        }
    }


    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper bean = context.getBean(BookMapper.class);
        int i = bean.addBook(new Books(5, "操作系统", 32, "893重要"));

        if (i>0){
            System.out.println("添加成功~~~");
        }else{
            System.out.println("失败！！");
        }

    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper bean = context.getBean(BookMapper.class);
        Books books = new Books(6, "编译原理", 100, "软件开发");
        int i = bean.updateBook(books);
        if (i>0){
            System.out.println("更新成功~~~");
        }else{
            System.out.println("失败！！");
        }
    }


    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper bean = context.getBean(BookMapper.class);

        int i = bean.deleteBookById(6);
        if (i>0){
            System.out.println("删除成功~~");
        }
        Books books = bean.queryBookById(2);
        System.out.println("=============");
        System.out.println(books);
        System.out.println("*************");
    }
}

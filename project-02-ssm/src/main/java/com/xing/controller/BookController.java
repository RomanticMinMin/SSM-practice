package com.xing.controller;


import com.xing.pojo.Books;
import com.xing.service.BookService;
import com.xing.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    //核心： controller层去掉service层
    @Autowired
 //   @Qualifier("BookServiceImpl")  //因为前面没有使用DI注入，所以此处不能使用bean名进行绑定
    private BookService bookService;

    @RequestMapping("/allBook")
    public String queryAll(Model model){

        List<Books> list = bookService.allBook();
        model.addAttribute("list",list);
        return "allBook";   //跳转到allBook页面，现在去编写allBook页面！
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println(books);
        int i = bookService.addBook(books);
        if(i>0)
            System.out.println("添加成功！");
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdataBook(Model model,int id)
    {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books);
        return "updateBook";
    }
    @RequestMapping("updateBook")
    public String updateBook(Books books){
        System.out.println("修改后的书籍为"+books);
        int i = bookService.updateBook(books);
        if (i>0)
            System.out.println("修改成功");
        else
            System.out.println("失败");
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toDeleteBook")
    public String toDeleteBook(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("book",books);
        return "deleteBook";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(Books books){
        int i = bookService.deleteBookById(books.getBookID());
        if (i>0){
            System.out.println("删除成功！");
        }else
            System.out.println("删除失败~");
        return "redirect:/book/allBook";
    }


    //回到首页的实现
    @RequestMapping("/toIndexBook")
    public String toIndexBook(Model model){
        List<Books> list = bookService.allBook();
        model.addAttribute("list",list);
        return "/allBook";
    }

    //要检索的书籍名称
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        System.out.println("books==>"+books);
        if (books==null){
            model.addAttribute("error","此书不存在");
        }else {
            List<Books> list = new ArrayList<>();
            list.add(books);
            model.addAttribute("list",list);
        }
        return "/allBook";
    }

}

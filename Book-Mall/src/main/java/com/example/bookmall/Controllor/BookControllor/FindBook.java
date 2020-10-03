package com.example.bookmall.Controllor.BookControllor;

import com.example.bookmall.Pojo.Book;
import com.example.bookmall.Service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
public class FindBook {
    @Resource
    private BookService bookService;

    @GetMapping("/book/findall")
    public String findAll(Model model){

        ArrayList<Book> allBook = bookService.findAll();
        model.addAttribute("allbook",allBook);
        return "user/page/index";
    }

    //去某本书的详情页面进行查看
    @GetMapping("/book/findById/{isbn}")
    public String findById(@PathVariable("isbn") String isbn,Model model){
        ArrayList<Book> all = bookService.findAll();
        Book book = bookService.findById(isbn);
        model.addAttribute("allbook",all);
        model.addAttribute("book",book);
        return "user/page/detail";
    }
}

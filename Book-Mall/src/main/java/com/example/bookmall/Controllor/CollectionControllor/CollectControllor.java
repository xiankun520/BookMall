package com.example.bookmall.Controllor.CollectionControllor;

import com.example.bookmall.Pojo.Book;
import com.example.bookmall.Pojo.Collection;
import com.example.bookmall.Pojo.User;
import com.example.bookmall.Service.BookService;
import com.example.bookmall.Service.CollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Slf4j
@Controller
public class CollectControllor {
    @Resource
    private CollectionService collectionService;

    @Resource
    private BookService bookService;

    private boolean flag=true;

    @ResponseBody
    @PostMapping("/user/addcollect")
    public String addCollection(@RequestBody @RequestParam("isbn")String isbn,
                                HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Collection collection=new Collection(user.getPhone(),isbn);
        if (flag) {
            int i = collectionService.addCollection(collection);
            flag=false;
            return "yes";
        }else {
            int i = collectionService.deleteCollection(collection);
            flag=true;
            return "no";
        }
    }


    @GetMapping("/user/collectFlash")
    public String deleteCollection(@RequestParam("isbn") String isbn, Model model){

        Book byId = bookService.findById(isbn);
        model.addAttribute("book",byId);
        if (!flag){
            model.addAttribute("flag","true");
        }else {
            model.addAttribute("flag","false");
        }
        return "user/page/detail";
    }

    @GetMapping("/user/showCollection")
    public String showCollection(Model model,HttpServletRequest req){
        HttpSession session = req.getSession();
        User user= (User) session.getAttribute("user");
        ArrayList<Book> allCollections = collectionService.findAllCollections(user.getPhone());
        log.info(user.getPhone());
        model.addAttribute("collects",allCollections);
        return "user/page/collect";
    }
}

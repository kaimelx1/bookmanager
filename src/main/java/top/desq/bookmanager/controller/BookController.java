package top.desq.bookmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.desq.bookmanager.model.Book;
import top.desq.bookmanager.service.BookService;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired(required = true)
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("list", this.bookService.list());

        return "books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("book") Book book) {
        if (book.getId() == 0) {
            this.bookService.add(book);
        } else {
            this.bookService.update(book);
        }

        return "redirect:/books";
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id) {
        this.bookService.remove(id);

        return "redirect:/books";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getById(id));
        model.addAttribute("list", this.bookService.list());

        return "books";
    }

    @RequestMapping("data/{id}")
    public String data(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getById(id));

        return "data";
    }
}

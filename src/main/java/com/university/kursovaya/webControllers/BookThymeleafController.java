package com.university.kursovaya.webControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.university.kursovaya.models.Book;
import com.university.kursovaya.services.BookService;

@Controller
public class BookThymeleafController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book";
    }

    @PostMapping("/books/add")
    public String addBook(@RequestParam String title, @RequestParam String author, @RequestParam String isbn) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        bookService.save(book);
        return "redirect:/books";
    }

    @PostMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }
}

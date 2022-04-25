package com.example.lab2emt.controller;

import com.example.lab2emt.model.BookModel;
import com.example.lab2emt.repository.BookRepo;
import com.example.lab2emt.service.BookService;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController()
@RequestMapping("/book")
@Configuration
@EnableSpringDataWebSupport
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public BookModel getBookById(@PathVariable Long id) {

        return this.bookService.findById(id);
    }

    @GetMapping("/page")
    List<BookModel> getAllBooks(@PathVariable String name, Pageable pageable) {

        //@PageableDefault(page = 0, size = 20)

        List<BookModel> allBooks= this.bookService.findAllByName(name,pageable).getContent();

        return allBooks;
        //"http://my-backend.com:8080/book?page=1&pageSize=10"
    }

}

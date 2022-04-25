package com.example.lab2emt.controller;

import com.example.lab2emt.Dto.BookDto;
import com.example.lab2emt.model.BookModel;
import com.example.lab2emt.service.BookService;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

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
    public Optional<BookModel> getBookById(@PathVariable Long id) {

        return this.bookService.findById(id);
    }

    @GetMapping("/page")
    List<BookModel> getAllBooks(@PathVariable String name, Pageable pageable) {

        //@PageableDefault(page = 0, size = 20)

        List<BookModel> allBooks= this.bookService.findAllByName(name,pageable).getContent();

        return allBooks;
        //"http://my-backend.com:8080/book?page=1&pageSize=10"
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<BookModel> edit(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.edit(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PostMapping("/add")
    public ResponseEntity<BookModel> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}

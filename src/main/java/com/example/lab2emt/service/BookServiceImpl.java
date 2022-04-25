package com.example.lab2emt.service;


import com.example.lab2emt.Dto.BookDto;
import com.example.lab2emt.exception.BookNotFoundException;
import com.example.lab2emt.model.BookModel;
import com.example.lab2emt.repository.BookRepo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepo book;


    public BookServiceImpl(BookRepo book) {
        this.book = book;
    }

    @Override
    public List<BookModel> findAll() {
        return null;
    }

    @Override
    public List<BookModel> findAll(Pageable pageable) {
        return this.book.findAllByName(pageable).getContent();


    }

    @Override
    public List<BookModel> findAllByName(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<BookModel> findById(Long id) {
        return this.book.findById(id);
                //.orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public void deleteById(Long id) {
        this.book.deleteById(id);
    }

    @Override
    public void refreshMaterializedView() {


    }

    @Override
    public Page<BookModel> findAllByName(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<BookModel> edit(Long id, BookDto bookDto) {
        BookModel Book = this.book.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        Book.setValidUntil(bookDto.getValidUntil());
        return Optional.of(this.book.save(Book));
    }

    @Override
    public Optional<BookModel> save(BookDto bookDto) {
         return Optional.of(this.book.save(new BookModel(bookDto.getValidUntil())));
    }
}

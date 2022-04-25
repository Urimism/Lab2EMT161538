package com.example.lab2emt.service;

import com.example.lab2emt.Dto.BookDto;
import com.example.lab2emt.model.BookModel;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookModel> findAll();

    List<BookModel> findAll(Pageable pageable);

    List<BookModel> findAllByName(Pageable pageable);

    Optional<BookModel> findById(Long id);

    void deleteById (Long id);

    void refreshMaterializedView();

    Page<BookModel> findAllByName (String name, Pageable pageable);

    Optional<BookModel> edit(Long id, BookDto bookDto);

    Optional<BookModel> save(BookDto bookDto);



}

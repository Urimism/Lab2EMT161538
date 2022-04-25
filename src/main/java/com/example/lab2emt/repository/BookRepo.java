package com.example.lab2emt.repository;

import com.example.lab2emt.model.BookModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookModel,Long> {

    Page<BookModel> findAllByName(Pageable pageable);
    void deleteById(Long id);

}

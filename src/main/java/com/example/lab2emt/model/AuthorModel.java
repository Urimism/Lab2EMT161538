package com.example.lab2emt.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class AuthorModel {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    private CountryModel country;

    @ManyToOne
    private BookModel bookModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

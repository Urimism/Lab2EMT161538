package com.example.lab2emt.Dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookDto {

    private LocalDateTime validUntil;

    public BookDto(){}

    public BookDto(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }


}

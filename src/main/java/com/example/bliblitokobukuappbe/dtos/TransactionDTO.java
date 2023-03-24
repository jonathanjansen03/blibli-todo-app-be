package com.example.bliblitokobukuappbe.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDTO {
    private String bookId;
    private int qty;


}

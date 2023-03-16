package com.example.bliblitokobukuappbe.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomResponse {
    private List<BookDTO> docs;

}

package com.example.bliblitokobukuappbe.dtos;





import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@NoArgsConstructor
@Data
public class BookDTO {

    private String title;
    private List<String> author_name;

}

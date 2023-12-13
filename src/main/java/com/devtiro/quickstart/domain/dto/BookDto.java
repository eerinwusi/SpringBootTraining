package com.devtiro.quickstart.domain.dto;

import com.devtiro.quickstart.domain.entities.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private String isbn;

    private String title;

    private Author author;
}

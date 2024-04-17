package com.Book_Service.com.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String book_name;

    @NotNull
    private String author;

    @NotNull
    private int numberOfCopiesSold;

    @NotNull
    private Double price;

    @NotNull
    @Min(value = 0, message = "Book number cannot be negative")
    private Double ratings;
}

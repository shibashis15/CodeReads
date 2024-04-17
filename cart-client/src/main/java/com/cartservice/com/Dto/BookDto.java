package com.cartservice.com.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {
    @Id
    @NotNull
    private Long id;

    @NotNull
    private String bookName;

    @NotNull
    private String bookAuthor;

    @NotNull
    private Double bookPrice;

    @NotNull
    private Double rating;

    @NotNull
    private Long discount;

    private int quantity;
}
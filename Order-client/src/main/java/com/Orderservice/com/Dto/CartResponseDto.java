package com.Orderservice.com.Dto;

import com.Orderservice.com.Model.Book;
import com.Orderservice.com.Model.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartResponseDto {
    private List<BookDto> bookList;
    private double totalAmount;
}

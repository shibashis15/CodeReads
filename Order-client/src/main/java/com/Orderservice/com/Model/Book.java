package com.Orderservice.com.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
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

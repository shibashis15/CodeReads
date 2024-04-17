package com.Book_Service.com.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "book_table")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "book_name")
    private String bookName;

    @NotNull
    @Column(name = "book_author")
    private String bookAuthor;

    @NotNull
    @Column(name = "book_price")
    private Double bookPrice;

    @NotNull
    @Column(name = "book_discount")
    private Long discount;

    @NotNull
    @Column(name = "book_description")
    private String description;

    @Column(name = "book_rating")
    @Min(value = 0, message = "Book number cannot be negative")
    private Double rating;

    @Column(name = "no_of_copy_sold")
    private int numberOfCopiesSold;

    @Column
    @Min(value = 0, message = "Book number cannot be negative")
    private int book_number;

    @Column(name = "book_category")
    @ElementCollection
    private Set<String> categories;
}

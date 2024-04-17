package com.Book_Service.com.Controller;

import com.Book_Service.com.DTO.BookDto;
import com.Book_Service.com.Service.book_service;
import jakarta.validation.Valid;
import org.bouncycastle.asn1.esf.SPuri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class BookController {
    private final book_service bookService;

    @Autowired
    public BookController(book_service bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/bookList")
    public ResponseEntity getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity getBookById(@PathVariable Long id) {
        return bookService.getBooksById(id);
    }

    @GetMapping("/book/category")
    public ResponseEntity getCategoriesOrderByRating(Set<String> categorySet) {
        return bookService.getCategoriesOrderByRating(categorySet);
    }
    @GetMapping("book/ratings")
    public ResponseEntity getAllBooksByRatings() {
        return bookService.getBooksByRatings();
    }

    @PostMapping("/sell/{id}/{number}")
    public ResponseEntity bookSold(@PathVariable Long id , @Valid@PathVariable int number) {
        return bookService.bookSold(id , number);
    }
}

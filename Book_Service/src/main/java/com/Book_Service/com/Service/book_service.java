package com.Book_Service.com.Service;

import com.Book_Service.com.DTO.BookDto;
import com.Book_Service.com.Model.Book;

import com.Book_Service.com.Repository.BookRepository;
import com.Book_Service.com.util.BookNotAvailableException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class book_service {

    private BookRepository bookRepository;

    @Autowired
    public book_service(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ResponseEntity getBooksById(Long id) {
        return ResponseEntity.ok(bookRepository.findById(id));
    }

    public ResponseEntity getAllBooks() {
        List<Book> bookOptional =  bookRepository.findAllByOrderByNumberOfCopiesSoldDesc();
        return getResponseEntity(bookOptional);
    }

    public ResponseEntity getCategoriesOrderByRating(Set<String> categorySet) {
        return getResponseEntity(bookRepository.findByCategoriesInOrderByRating(categorySet));
    }

    public ResponseEntity getBooksByRatings() {
        List<Book> bookOptional = bookRepository.findAllByOrderByRatingDesc();
        return getResponseEntity(bookOptional);
    }

    @NotNull
    private ResponseEntity getResponseEntity(List<Book> bookList) {

        if(bookList.isEmpty()) throw new BookNotAvailableException("Empty No Books Found");
        List<BookDto> bookDtoList = new ArrayList<>();

        for(Book book : bookList) {
            BookDto bookDto = new BookDto(book.getId() , book.getBookName() , book.getBookAuthor() , book.getNumberOfCopiesSold() , book.getBookPrice() , book.getRating());
            bookDtoList.add(bookDto);
        }
        return ResponseEntity.ok(bookDtoList);
    }

    public ResponseEntity bookSold(Long book_id , int number) {
        Optional <Book> book = bookRepository.findById(book_id);
        int present_number = book.get().getBook_number();
        if(present_number < number)
            throw new BookNotAvailableException("Book Sold Out!! /  Not Available");
        book.get().setBook_number(present_number - number);
        int copySold = book.get().getNumberOfCopiesSold();
        book.get().setNumberOfCopiesSold(++copySold);
        return ResponseEntity.ok("Updated!!");
    }

}

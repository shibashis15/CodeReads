package com.Book_Service.com.Repository;

import com.Book_Service.com.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public Optional<Book> findById(Long id);
    public List<Book> findByCategoriesInOrderByRating(Set<String> categorySet);
    public List<Book> findAllByOrderByRatingDesc();
    public List<Book> findAllByOrderByNumberOfCopiesSoldDesc();

}

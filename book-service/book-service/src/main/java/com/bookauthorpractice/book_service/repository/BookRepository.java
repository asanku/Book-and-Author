package com.bookauthorpractice.book_service.repository;

import com.bookauthorpractice.book_service.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private List<Book> books = new ArrayList<>();

    public BookRepository() {
        books.add(new Book(1L, "1984", 1L));
        books.add(new Book(2L, "Harry Potter", 2L));
        books.add(new Book(3L, "To Kill a Mockingbird", 3L));
        books.add(new Book(4L, "The Lord of the Rings", 4L));
        books.add(new Book(5L, "Pride and Prejudice", 5L));
    }

    public List<Book> findAll(){

        return new ArrayList<>(books);
    }

    public Optional<Book> findById(Long id){

        return books.stream().filter(book -> book.getId().equals(id)).findFirst();

    }
}

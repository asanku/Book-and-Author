package com.bookauthorpractice.book_service.controller;

import com.bookauthorpractice.book_service.domain.Book;
import com.bookauthorpractice.book_service.dto.AuthorDTO;
import com.bookauthorpractice.book_service.dto.BookDTO;
import com.bookauthorpractice.book_service.feign_client.AuthorClient;
import com.bookauthorpractice.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorClient authorClient;

    /*
    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().
                map(book -> new BookDTO(book.getId(),book.getTitle(),authorClient.getAuthorById(book.getAuthorId())))
                .collect((Collectors.toList()));

    }


     */


    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> {
            AuthorDTO author = authorClient.getAuthorById(book.getAuthorId());
            return new BookDTO(book.getId(), book.getTitle(), author);
        }).collect(Collectors.toList());
    }



/*

    @GetMapping("/books/{id}")
        public BookDTO getBookById(@PathVariable Long id) {

            Book book= bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
            return new BookDTO(book.getId(),book.getTitle(),authorClient.getAuthorById(book.getAuthorId()));

        }

 */



    @GetMapping("/books/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        AuthorDTO author = authorClient.getAuthorById(book.getAuthorId());
        return new BookDTO(book.getId(), book.getTitle(), author);
    }



}

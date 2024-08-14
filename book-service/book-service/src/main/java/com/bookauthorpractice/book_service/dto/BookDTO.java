package com.bookauthorpractice.book_service.dto;

public record BookDTO (
    Long id,
    String title,
    AuthorDTO author)
{

}

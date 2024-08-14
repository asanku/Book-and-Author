package com.bookauthorpractice.book_service.feign_client;

import com.bookauthorpractice.book_service.dto.AuthorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "author-service") //url = "http://localhost:8081")
public interface AuthorClient {

    @GetMapping("/authors/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id);
}

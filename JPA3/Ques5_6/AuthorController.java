package com.springJPA2.JPA3.Ques5_6;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("")
    public List<Author> listOfAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping("/author/add")
    @Transactional
    public Author addAuthor(@RequestBody Author author) {
        if (author == null && author.getBook() != null) return null;
        Book book = author.getBook();
        book.setAuthor(author);
        return authorRepository.save(author);
    }

    @DeleteMapping("/author/delete")
    public String deleteAuthor(@RequestParam Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) return "Author doesnt exist";
        authorRepository.deleteById(id);
        return "Author deleted";
    }
}

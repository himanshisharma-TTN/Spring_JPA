package com.springJPA2.JPA3.Ques7;

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
    public Author addAuthor(@RequestBody Author author) {
        if (author == null || author.getBooks() == null) return null;
        List<Book> books = author.getBooks();
        for (Book book : books) {
            book.setAuthor(author);
        }
        System.out.println("Hello");
        return authorRepository.save(author);
    }

    @DeleteMapping("/author/delete")
    public String deleteAuthor(@RequestParam Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) return "Author doesn't exist";
        authorRepository.deleteById(id);
        return "Author deleted";
    }
}

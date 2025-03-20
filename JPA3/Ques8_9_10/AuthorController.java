package com.springJPA2.JPA3.Ques8_9_10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("")
    public List<Author> listOfAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping("/author/add")
    public Author addAuthor(@RequestBody Author author) {
        if (author == null || author.getBooks() == null) return null;

        List<Book> existingBooks = new ArrayList<>();

        for (Book book : author.getBooks()) {
            Optional<Book> existingBook = bookRepository.findByNameAndTitle(book.getName(), book.getTitle());

            if (existingBook.isPresent()) {
                existingBooks.add(existingBook.get());
            } else {
                book.getAuthors().add(author);
                existingBooks.add(book);
            }
        }

        author.setBooks(existingBooks);
        return authorRepository.save(author);
    }

    @PostMapping("/author/more")
    public List<Author> addAuthors(@RequestBody List<Author> authors) {
        for (Author author : authors) {
            addAuthor(author);
        }
        return authorRepository.findAll();
    }

    @DeleteMapping("/author/delete")
    public String deleteAuthor(@RequestParam Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) return "Author doesn't exist";
        authorRepository.deleteById(id);
        return "Author deleted";
    }
}

package com.springJPA2.JPA3.Ques1_2_3_4;

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

    @PostMapping("/add")
    public Author addAuthor(@RequestBody Author author) {
        if (author.getName() == null) return null;
        return authorRepository.save(author);
    }

    @PostMapping("/add/more")
    public List<Author> addAuthors(@RequestBody List<Author> authors) {
        if (authors.isEmpty()) return null;
        return authorRepository.saveAll(authors);
    }


    @DeleteMapping("/delete")
    public String deleteWIthID(@RequestParam(required = false) Long id, @RequestParam(required = false) String name) {
        if (id == null) return "Id is null";
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            return "Author DELETED WITH ID " + id;
        }
        throw new RuntimeException("Author not found with ID " + id);
    }

}

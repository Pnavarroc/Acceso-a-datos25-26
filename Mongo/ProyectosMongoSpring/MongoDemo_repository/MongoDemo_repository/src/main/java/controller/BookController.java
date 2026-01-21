package controller;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.BookRepository;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    //CRUD

    //GETALL
    @GetMapping
    public ResponseEntity<List<Book>> conseguirTodosLosLibros(){
        return ResponseEntity.ok(bookRepository.findAll());
    }


}

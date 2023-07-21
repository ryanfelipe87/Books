package com.test.Books.controllers;

import com.test.Books.entities.Books;
import com.test.Books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    //Lista todos os livros
    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("books", bookService.findAllBook());
        return "AllBook";
    }

    //Adiciona um livro ao banco mostrando no HTML
    @GetMapping("/add")
    public String lunchAddBookPage(Model model){
        model.addAttribute("books", new Books());
        return "AddBook";
    }

    //Cria um novo livro e mostrando ao usuário
    @PostMapping("/addBook")
    public String createBook(Books books){
        bookService.addBook(books);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String lunohEditPage(Model model, @PathVariable ("id") Long id){
        model.addAttribute("books", bookService.findBookById(id));
        return "EditBook";
    }

    @PostMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable ("id") Long id){
        bookService.deleteById(id);
        return "redirect:/";
    }
}

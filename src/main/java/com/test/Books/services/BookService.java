package com.test.Books.services;

import com.test.Books.entities.Books;
import com.test.Books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    //Buscando todos os livros
    public List<Books> findAllBook(){
        return (List<Books>) bookRepository.findAll();
    }

    //Buscando todos os livros por Id
    public Books findBookById(Long id) {
        Optional<Books> result = bookRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return new Books();
    }

    //Inserir livros
    public Books addBook(Books books){
        return bookRepository.save(books);
    }

    //Atualizando por Id
    public Books updateBook(Books books){
        Optional<Books> result = bookRepository.findById(books.getId());
        Books existing = result.get();
        existing.setAuthor(books.getAuthor());
        existing.setName(books.getName());
        existing.setNumPage(books.getNumPage());
        existing.setPublication(books.getPublication());
        return bookRepository.save(existing);
    }

    //Deletando por Id
    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }
}

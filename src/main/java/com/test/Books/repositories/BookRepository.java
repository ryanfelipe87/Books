package com.test.Books.repositories;

import com.test.Books.entities.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Books, Long> {
}

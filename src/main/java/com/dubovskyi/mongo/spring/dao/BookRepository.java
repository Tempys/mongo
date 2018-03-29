package com.dubovskyi.mongo.spring.dao;

import com.dubovskyi.mongo.spring.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


@Repository
public interface BookRepository extends MongoRepository<Book, BigInteger> {

    List<Book> findByAuthor(String name);
}

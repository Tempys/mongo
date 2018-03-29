package com.dubovskyi.spring;


import com.dubovskyi.mongo.MongoApplication;
import com.dubovskyi.mongo.spring.domain.Book;
import com.dubovskyi.mongo.spring.dao.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoApplication.class)
@DirtiesContext
public class BookRepositoryTest {


    @Autowired
    private BookRepository bookRepository;

    @Test
    public void  crudWithBookrepositoryTest(){
        List<Book> book =  bookRepository.findByAuthor("Andrian");

        Assert.assertEquals(1,book.size());
        System.out.println(bookRepository.findAll().size());
    }
}

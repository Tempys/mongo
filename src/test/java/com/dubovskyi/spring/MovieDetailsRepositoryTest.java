package com.dubovskyi.spring;


import com.dubovskyi.mongo.MongoApplication;
import com.dubovskyi.mongo.spring.dao.MovieDetailsRepository;
import com.dubovskyi.mongo.spring.domain.MovieDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoApplication.class)
@DirtiesContext
public class MovieDetailsRepositoryTest {

    @Autowired
    private MovieDetailsRepository repository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void findMovie(){
        Query query = new Query(
                Criteria.where("rated").is("PG-13")
                        .andOperator(
                                Criteria.where("year").gte(2013).andOperator(Criteria.where("awards.wins").is(0))
                        )

        );

     List<MovieDetails>  movieDetails =  mongoTemplate.find(query,MovieDetails.class);

     movieDetails.forEach(System.out::println);

    }

    @Test
    public void SwedenFilmsCountTest(){
        Query query = new Query(
                Criteria.where("countries.1").is("Sweden")

        );


        List<MovieDetails>  movieDetails =  mongoTemplate.find(query,MovieDetails.class);

        System.out.println(mongoTemplate.find(query,MovieDetails.class).size());

        movieDetails.forEach(System.out::println);
    }

}

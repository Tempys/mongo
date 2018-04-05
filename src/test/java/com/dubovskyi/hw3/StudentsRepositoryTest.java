package com.dubovskyi.hw3;


import com.dubovskyi.mongo.MongoApplication;
import com.dubovskyi.mongo.spring.domain.Students;
import com.dubovskyi.mongo.spring.domain.StudentsDto1;
import com.mongodb.WriteResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoApplication.class)
@DirtiesContext
public class StudentsRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void findAllTest() {
        List<Students> students = mongoTemplate.findAll(Students.class);


        System.out.println("students: " + students);
        Assert.assertTrue(students.size() > 0);
    }


    @Test
    public void removeStudentByMinScore() {

        Aggregation agg = newAggregation(
                // Aggregation.match( where("_id").is(137)),
                unwind("$scores"),
                Aggregation.match(where("scores.type").is("homework")),
                group("$_id")
                        .min("$scores.score").as("min")

        );

        AggregationResults<StudentsDto1> results = mongoTemplate.aggregate(agg, "students", StudentsDto1.class);

        List<StudentsDto1> students = results.getMappedResults();
        System.out.println("students: " + students);
        students.forEach(i -> {


                    WriteResult result = this.mongoTemplate.updateMulti(query(where("_id").is(i.getId())),
                            new Update().pull("scores", query(where("score").is(i.getMin()))), "students");

                    System.out.println(result.toString());
                }


        );

    }



}



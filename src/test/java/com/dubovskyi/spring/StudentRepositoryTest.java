package com.dubovskyi.spring;


import com.dubovskyi.mongo.MongoApplication;
import com.dubovskyi.mongo.spring.dao.StudentRepository;
import com.dubovskyi.mongo.spring.domain.Student;
import com.dubovskyi.mongo.spring.domain.StudentDto;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoApplication.class)
@DirtiesContext
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void findAllTest(){
      List<Student> students = repository.findAll();
        System.out.println("students: " + students.size() );
        Assert.assertTrue(students.size()>0);
    }

    @Test
    public void findAllTestWithSortAndType(){
        List<Student> students = repository.findAllByTypeOrderByScoreAsc("homework");

        System.out.println("students: " + students.size() );

        Assert.assertTrue(students.size()>0);
    }


    @Test
    public void findAllWithSort(){
        List<Student> students = repository.findAll(new Sort(Sort.Direction.ASC, "name"));

        System.out.println("students: " + students.size() );

        Assert.assertTrue(students.size()>0);
    }

    @Test
    public void findMinByStudent(){

        Aggregation agg = newAggregation (
               // Aggregation.match( Criteria.where("mailBoxId").is("1").and("isVisible").is(false)),
                  Aggregation.match( Criteria.where("type").is("homework")),
                 group("$student_id")
                          .first("student_id").as("studentId")
                          //.first("$$ROOT").as("root_id")
                          .first("$type").as("type")
                          .min("$score").as("score")

        );

        AggregationResults<StudentDto> results  = mongoTemplate.aggregate(agg,"grades",StudentDto.class);

        List<StudentDto> students = results.getMappedResults();
        System.out.println("students: " + students.size() );

    }

    @Test
    @Ignore
    public void removeMinByStudent(){

        Aggregation agg = newAggregation (
                // Aggregation.match( Criteria.where("mailBoxId").is("1").and("isVisible").is(false)),
                Aggregation.match( Criteria.where("type").is("homework")),
                group("$student_id")
                        .first("student_id").as("studentId")
                        // .first("$$ROOT._id").as("root_id")
                        .first("$type").as("type")
                        .min("$score").as("score")

        );

        AggregationResults<StudentDto> results  = mongoTemplate.aggregate(agg,"grades",StudentDto.class);

        List<StudentDto> students = results.getMappedResults();
        System.out.println("students: " + students.size() );

        students.forEach(i -> {
            System.out.println(i);
            repository.deleteByScoreAndStudentId(i.getScore(),i.getStudentId()); });

    }

}

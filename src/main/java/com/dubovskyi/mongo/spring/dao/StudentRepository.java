package com.dubovskyi.mongo.spring.dao;

import com.dubovskyi.mongo.spring.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findAllByTypeOrderByScoreAsc(String type);

    void deleteByScoreAndStudentId(Double score, Integer studentId);


}

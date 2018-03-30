package com.dubovskyi.mongo.spring.dao;

import com.dubovskyi.mongo.spring.domain.MovieDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieDetailsRepository  extends MongoRepository<MovieDetails, String> {


}

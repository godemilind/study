package com.iocs.spring.beans.crud;

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface TutorialRepository
        // extends MongoRepository<Tutorial, String>
{
    List<Tutorial> findByTitleContaining(String title);
    List<Tutorial> findByPublished(boolean published);
}

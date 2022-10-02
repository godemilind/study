package com.iocs.spring.beans.jpa.repository;

import com.iocs.spring.beans.jpa.model.Author;
import com.iocs.spring.beans.jpa.model.Tutorial;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@TestPropertySource(properties = {
//        "spring.jpa.hibernate.ddl-auto=update"
//})
@SpringBootTest
public class TutorialRepositoryTest {

    @Autowired
    TutorialRepository tutorialRepository;

    @Test
    void findByPublishedSort() {
        Sort sort = Sort.by(Sort.Direction.ASC,"title");
        assert(!tutorialRepository.findByPublished(true,sort).isEmpty());
    }

    @Test
    void findByPublishedPageable() {
        Pageable page = PageRequest.of(1,2);
        List<Tutorial> tutorials = tutorialRepository.findByPublished(true,page);
        assert(tutorials.size() == 2);
    }

    @Test
    void findTutorialsByJPQL() {
        List<Tutorial> tutorials = tutorialRepository.findTutorialsByQuery(true,"Java");
        assert(tutorials.size() == 1);

        tutorials = tutorialRepository.findTutorialsByNativeQuery(true,"Java");
        assert(tutorials.size() == 1);
    }

    @Test
    void findTutorialsByNativeQuery() {
        List<Tutorial> tutorials = tutorialRepository.findTutorialsByNativeQuery(true,"Java");
        assert(tutorials.size() == 1);
    }

    @Test
    void findTutorial(){
        Optional<List<Tutorial>> tutorials = tutorialRepository.findTutorialsByTitleLikeIgnoreCase("%ja%");
        assert(tutorials.isPresent());
        if(tutorials.isPresent()){
            assert tutorials.get().stream().filter(t->t.isPublished() && t.getTitle().contains("Java")).findAny().isPresent();
        }
    }
}

package com.iocs.spring.beans.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/crud")
public class TutorialController {

    //@Autowired
    TutorialRepository tutorialRepository;

//    @GetMapping("/tutorials")
//    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
//        return ResponseEntity.ok().body(tutorialRepository.findAll());
//    }
//
//    @GetMapping("/tutorials/{id}")
//    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") String id) {
//         Tutorial tutorial = tutorialRepository.findById(id).get();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/json");
//        return new ResponseEntity<>(tutorial,headers, HttpStatus.OK);
//    }
//
//    @PostMapping("/tutorials")
//    public ResponseEntity<Tutorial> createTutorial(@Valid @RequestBody Tutorial tutorial) {
//        return ResponseEntity.ok(tutorialRepository.save(tutorial));
//    }
//
//    @PutMapping("/tutorials/{id}")
//    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") String id, @RequestBody Tutorial tutorial) {
//        return ResponseEntity.ok(tutorialRepository.save(tutorial));
//    }
//
//    @DeleteMapping("/tutorials/{id}")
//    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
//        tutorialRepository.deleteById(id);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//
//    @DeleteMapping("/tutorials")
//    public ResponseEntity<HttpStatus> deleteAllTutorials() {
//        tutorialRepository.deleteAll();
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//
//    @GetMapping("/tutorials/published")
//    public ResponseEntity<List<Tutorial>> findByPublished() {
//        return ResponseEntity.ok(tutorialRepository.findByPublished(true));
//    }

}

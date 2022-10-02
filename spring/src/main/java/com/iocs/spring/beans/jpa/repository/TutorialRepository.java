package com.iocs.spring.beans.jpa.repository;

import java.util.List;
import java.util.Optional;

import com.iocs.spring.beans.jpa.model.Tutorial;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);
    // sort by
    List<Tutorial> findByPublished(boolean published, Sort sort);
    // pagination
    List<Tutorial> findByPublished(boolean published, Pageable page);

    @Query("SELECT t from Tutorial t WHERE t.published=?1 AND t.title=?2")
    List<Tutorial> findTutorialsByQuery(boolean published, String title);

    @Query(value = "SELECT * from tutorials t WHERE t.published=?1 AND t.title=?2 ORDER BY t.title", nativeQuery = true)
    List<Tutorial> findTutorialsByNativeQuery(boolean published, String title);

    Optional<List<Tutorial>> findTutorialsByTitleLikeIgnoreCase(String title);
}

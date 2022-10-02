package com.iocs.spring.beans.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "chapters")
@Getter
@Setter
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "chapterNumber")
    private Integer chapterNumber;

    @Column(name = "title")
    private String title;

    public Chapter() {
    }

    public Chapter(Long id, Integer chapterNumber, String title) {
        this.id = id;
        this.chapterNumber = chapterNumber;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", chapterNumber=" + chapterNumber +
                ", title='" + title + '\'' +
                '}';
    }
}

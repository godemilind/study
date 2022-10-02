package com.iocs.spring.beans.jpa.model;

import com.iocs.spring.beans.crud.validator.Title;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tutorials")
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Title
    @NotBlank(message = "Title is mandatory")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Description is mandatory")
    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="author_id", referencedColumnName = "id")
    private Author author;

    public Tutorial() {
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }
}
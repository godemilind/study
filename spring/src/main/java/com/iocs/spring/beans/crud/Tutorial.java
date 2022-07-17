package com.iocs.spring.beans.crud;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tutorials")
@Getter
@Setter
public class Tutorial {
    @Id
    private String id;

    private String title;
    private String description;
    private boolean published;

}

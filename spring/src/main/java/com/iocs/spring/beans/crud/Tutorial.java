package com.iocs.spring.beans.crud;

import com.iocs.spring.beans.crud.validator.Title;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

//@Document(collection = "tutorials")
@Getter
@Setter
public class Tutorial {
    @Id
    private String id;

    @Title
    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Description is mandatory")
    private String description;

    private boolean published;

}

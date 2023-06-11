package com.uep.moodleproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "resources")
public class Resource
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resource_id;

    private String res_title;
    private String res_description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course_id;

    private Integer res_displayOrder;

    @Transient
    private MultipartFile res_file;

    public Resource(String res_title, String res_description, Course course_id, Integer res_displayOrder, MultipartFile res_file)
    {
        this.res_title = res_title;
        this.res_description = res_description;
        this.course_id = course_id;
        this.res_displayOrder = res_displayOrder;
        this.res_file = res_file;
    }
}

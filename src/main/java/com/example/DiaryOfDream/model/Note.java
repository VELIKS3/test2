package com.example.DiaryOfDream.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String Title;
    @Column(name = "content")
    private String Content;
    @Column(name = "dates")
    private String Date;

}
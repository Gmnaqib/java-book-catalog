package me.gumilarmn.catalog.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Table(name = "author")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthPlace")
    private String birthPlace;

    @Column(name = "birthdate")
    private LocalDate birthDate;

    @Column(name = "description")
    private String description;
}

package com.test.Books.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Data
@Table(name = "")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String name;

    @Column
    String author;

    @Column
    int numPage;

    @Column
    String publication;
}

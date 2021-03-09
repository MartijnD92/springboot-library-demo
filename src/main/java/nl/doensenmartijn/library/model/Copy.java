package nl.doensenmartijn.library.model;

import javax.persistence.*;

@Entity
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String nr;

    @Column
    String status;

    @ManyToOne
    Book book;
}

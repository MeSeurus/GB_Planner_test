package ru.geekbrains.planner_test.entities;

import javax.persistence.*;

@Entity
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
}

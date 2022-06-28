package ru.geekbrains.planner_test.stortor.pets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pets")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pet {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "score")
    private Integer score;
}

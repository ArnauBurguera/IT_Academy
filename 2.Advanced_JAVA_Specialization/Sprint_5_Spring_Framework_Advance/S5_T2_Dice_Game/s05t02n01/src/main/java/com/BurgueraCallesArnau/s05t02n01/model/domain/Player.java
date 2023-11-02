package com.BurgueraCallesArnau.s05t02n01.model.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date registrationDate;

    @OneToMany(mappedBy = "player")
    private List<Game> games;
}

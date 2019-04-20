package com.arqueomaps.arqueomaps.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Civilization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String Name;

    private String Description;

}

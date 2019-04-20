package com.arqueomaps.arqueomaps.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Figure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String Name;
    private String Description;
    private Float Area;
    private String Author;
    private String CreationDate;
}

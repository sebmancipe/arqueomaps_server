package com.arqueomaps.arqueomaps.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="public.\"Civilization\"")
public class Civilization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String Name;

    private String Description;

    //private List<Place> Places;
}

package com.arqueomaps.arqueomaps.entities;

import lombok.Data;

import java.util.List;

@Data
public class Civilization {
    private int Id;
    private String Name;
    private String Description;
    private List<Place> Places;
    private List<Figure> Figures;
}

package com.arqueomaps.arqueomaps.entities;

import lombok.Data;

import java.util.List;

@Data
public class Figure {
    private int Id;
    private String Name;
    private String Description;
    private List<Place> Places;
    private float Area;
    private String Author;
    private String CreationDate;
}

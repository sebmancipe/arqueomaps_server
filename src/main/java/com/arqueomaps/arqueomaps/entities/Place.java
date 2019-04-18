package com.arqueomaps.arqueomaps.entities;

import lombok.Data;

@Data
public class Place {
    private int Id;
    private String Name;
    private String Description;
    private Float Latitude;
    private Float Longitude;
    private String Tag;
}

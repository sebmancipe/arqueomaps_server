package com.arqueomaps.arqueomaps.entities;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String Name;
    private String Description;
    private Float Latitude;
    private Float Longitude;
    private String Tag;

    @ManyToOne
    @JoinColumn(name = "id_civ",
            nullable = false, updatable = false)
    private Civilization civilization;

    @ManyToOne
    @JoinColumn(name = "id_fig",updatable = false)
    private Figure figure;
}

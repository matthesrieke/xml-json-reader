package org.n52.datareader.model;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "STATIONS")
public class Station {
    @Id
    @Column(name = "STATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "STATION_NAME")
    private String name;
    @Column(name = "STATION_LOCATION")
    private Point location;

    public Station() {
    }

    public Station(Long id, String name, Point location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}

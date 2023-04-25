package com.researchpapermgmt.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "conference")
@NoArgsConstructor
@AllArgsConstructor
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Setter @Getter long id;

    @Column(name = "name")
    private @Setter @Getter String name;

    @Column(name = "starting_date")
    private @Setter @Getter String starting_date;

    @Column(name = "ending_date")
    private @Setter @Getter String ending_date;

    @Column(name = "location")
    private @Setter @Getter String location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conference")
    private @Setter @Getter Set<Panel> panels;
}

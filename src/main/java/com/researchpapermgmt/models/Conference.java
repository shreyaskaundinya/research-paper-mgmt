package com.researchpapermgmt.models;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
    private @Setter @Getter Date starting_date;

    @Column(name = "ending_date")
    private @Setter @Getter Date ending_date;

    @Column(name = "location")
    private @Setter @Getter String location;

    @OneToMany
    @JoinTable(name = "conf_panels", joinColumns = @JoinColumn(name = "conf_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "panel_id", referencedColumnName = "id"))
    private @Setter @Getter Set<Panel> panels;

}

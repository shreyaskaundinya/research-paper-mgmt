package com.researchpapermgmt.models;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "panel")
@NoArgsConstructor
@AllArgsConstructor
public class Panel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Setter @Getter long id;

    /*
    @ManyToMany
    @JoinTable(name = "panel_members")
    private @Setter @Getter Set<Panelmember> panel_members;
    
    */

    @JoinColumn(name = "conference")
    @ManyToOne
    private @Setter @Getter Conference conference;
}

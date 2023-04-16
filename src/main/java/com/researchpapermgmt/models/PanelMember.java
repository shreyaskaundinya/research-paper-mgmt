package com.researchpapermgmt.models;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "panelmember")
public class Panelmember extends BaseUser {
    @JoinColumn(name = "panel_id")
    @ManyToOne
    private @Getter @Setter Panel panel;
}

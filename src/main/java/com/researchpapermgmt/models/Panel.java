package com.researchpapermgmt.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(name = "panel_members", joinColumns = @JoinColumn(name = "panel_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "panel_member_id", referencedColumnName = "id"))
    private @Setter @Getter Set<PanelMember> panel_members;

    @Column(name = "conference")
    @ManyToOne
    private @Setter @Getter Conference conference;
}

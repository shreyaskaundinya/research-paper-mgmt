package com.researchpapermgmt.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "review")
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Setter @Getter long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private @Setter @Getter Paper paper;

    @ManyToOne(cascade = CascadeType.ALL)
    private @Setter @Getter Panel panel;

    @Column(name = "comment")
    private @Setter @Getter String comment;

}

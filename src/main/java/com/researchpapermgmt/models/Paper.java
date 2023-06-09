package com.researchpapermgmt.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "paper")
@NoArgsConstructor
@AllArgsConstructor
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Setter @Getter long id;

    @Column(name = "title")
    private @Setter @Getter String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "paper_authors", joinColumns = @JoinColumn(name = "paper_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private @Setter @Getter Set<User> authors;

    @ManyToOne
    private @Setter @Getter Conference conference;

    @Column(name = "approved")
    private @Setter @Getter Boolean approved;

    @Column(name = "paper_text")
    private @Setter @Getter String paperText;

    @Column(name = "keywords")
    private @Setter @Getter String keywords;

    public String toString() {
        return "id : " + this.getId();
    }
}

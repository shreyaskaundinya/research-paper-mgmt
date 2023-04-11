package com.researchpapermgmt.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private @Setter @Getter long id;

    @Column(name = "name")
    private @Setter @Getter String name;

    @Column(name = "email")
    private @Setter @Getter String email;

    @Column(name = "password")
    private @Setter @Getter String password;
}

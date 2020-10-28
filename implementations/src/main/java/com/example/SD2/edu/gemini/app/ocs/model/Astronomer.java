package com.example.SD2.edu.gemini.app.ocs.model;

import javax.persistence.Entity;

@Entity
public class Astronomer extends User {

    public Astronomer() {

    }

    public Astronomer(Integer id, String username, String name, String password, String role) {
        super(id, username, name, password, role);
    }
}

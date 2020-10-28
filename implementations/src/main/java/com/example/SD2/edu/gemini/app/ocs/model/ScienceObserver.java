package com.example.SD2.edu.gemini.app.ocs.model;

import javax.persistence.Entity;

@Entity
public class ScienceObserver extends User {

    public ScienceObserver(){

    }

    public ScienceObserver(Integer id, String username, String name, String password, String role) {
        super(id, username, name, password, role);
    }

}

package com.example.SD2.edu.gemini.app.ocs.controller;

public class scienceplanNotfound extends RuntimeException{
    public scienceplanNotfound(int id) {
        super("Could not find scienceplan " + id);
    }
}

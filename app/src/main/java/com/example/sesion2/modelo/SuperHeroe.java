package com.example.sesion2.modelo;

public class SuperHeroe {
    String name;
    String skill;

    public SuperHeroe(String name, String skill) {
        this.name = name;
        this.skill = skill;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

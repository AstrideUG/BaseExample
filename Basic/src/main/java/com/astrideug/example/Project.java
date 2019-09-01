package com.astrideug.example;

import com.astrideug.base.ProjectBase;

public class Project extends ProjectBase {

    @Override
    public void initialise() {
        System.out.println("\nExample Project INIT\n");
    }

    @Override
    public void enable() {
        System.out.println("\nExample Project ENABLE\n");
    }

}

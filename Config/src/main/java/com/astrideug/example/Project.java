package com.astrideug.example;

import com.astrideug.base.ProjectBase;
import com.astrideug.base.configuration.Config;
import com.astrideug.base.configuration.Configuration;

public class Project extends ProjectBase {

    @Config("exampleConfig.json")
    private Configuration configuration;

    @Override
    public void initialise() {

    }

    @Override
    public void enable() {
        MyConfig myConfig = configuration.read(MyConfig.class);
        System.out.println(myConfig.toString());
    }

}

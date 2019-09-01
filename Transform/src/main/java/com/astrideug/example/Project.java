package com.astrideug.example;

import com.astrideug.base.Base;
import com.astrideug.base.ProjectBase;
import me.helight.ccom.concurrency.Environment;

public class Project extends ProjectBase {

    @Change
    private int i = 0;

    //This method will be called before any Transformers kick in
    @Override
    public void initialise() {
        Base.getInstance().getModuleLoader().getModuleTransformers().add(new TransformerImpl());
        System.out.println("i hat den Wert " + i);
    }

    //This method kicks in after all Transformers were fired
    @Override
    public void enable() {
        System.out.println("i hat den Wert " + i);
    }

}

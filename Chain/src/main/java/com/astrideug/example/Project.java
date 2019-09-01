package com.astrideug.example;

import com.astrideug.base.Base;
import com.astrideug.base.ProjectBase;
import com.astrideug.base.chain.ChainManager;
import me.helight.ccom.concurrency.Environment;

public class Project extends ProjectBase {

    @Override
    public void initialise() {

    }

    @Override
    public void enable() {

        //Fire Supply Chain 10 time asynchronously
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("Started Thread "+ finalI);
                Base.getInstance().getChainManager().invoke("supply", Environment.create().env("threadID", finalI));
            }).start();
        }
    }

}

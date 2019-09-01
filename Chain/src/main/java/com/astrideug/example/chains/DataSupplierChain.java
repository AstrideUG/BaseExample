package com.astrideug.example.chains;

import com.astrideug.base.chain.annotations.ChainId;
import com.astrideug.base.chain.annotations.InvokeChain;
import com.astrideug.example.Data;
import me.helight.ccom.concurrency.Chain;
import me.helight.ccom.concurrency.chain.EnvAdrr;

import java.util.concurrent.ThreadLocalRandom;

@ChainId("supply")
public class DataSupplierChain extends Chain {

    public DataSupplierChain() {
        supply(() -> {
            //Assigning a random Value of the Enum Data to the Environment-Address "supply"
            return Data.values()[ThreadLocalRandom.current().nextInt(Data.values().length)];
        }).export(EnvAdrr.from("supply"));
    }

}

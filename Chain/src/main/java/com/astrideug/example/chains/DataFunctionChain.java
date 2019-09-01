package com.astrideug.example.chains;

import com.astrideug.base.chain.annotations.ChainId;
import com.astrideug.base.chain.annotations.HookChain;
import com.astrideug.base.chain.annotations.InterruptStack;
import com.astrideug.base.chain.annotations.InvokeChain;
import com.astrideug.example.Data;
import me.helight.ccom.collections.Pair;
import me.helight.ccom.collections.Tuple;
import me.helight.ccom.concurrency.Chain;
import me.helight.ccom.concurrency.chain.EnvAdrr;

import javax.swing.border.EmptyBorder;
import java.util.List;

@ChainId("function")

//Hooks onto the Supply-Chain
@HookChain("supply")

//Invokes Consumer if not interrupted
@InvokeChain("consume")

//If after execution, currupt == true, the Stack will be interrupted, so all Chains, which hooked themselves into this Chain, will still execute, but all chains, which would be invoked
//naturally by this chain, are skipped
@InterruptStack("corrupt")
public class DataFunctionChain extends Chain {

    public DataFunctionChain() {
        function(s -> s == Data.INVALID, Data.class).adresses(EnvAdrr.from("supply")).export(EnvAdrr.from("corrupt"));

        consume(t -> {
            Pair<Data,Integer> pair = Tuple.pair((List)t, Data.class, Integer.class);
            System.out.println("Thread " + pair.getB() + " will try to forward " + pair.getA().name());
        }).adresses(EnvAdrr.from("supply"), EnvAdrr.from("threadID"));

        consume(t -> {
            Pair<Boolean,Integer> pair = Tuple.pair((List)t, Boolean.class, Integer.class);
            if (pair.getA()) {
                System.out.println("Thread " + pair.getB() + " will be interrupted");
            }
        }).adresses(EnvAdrr.from("corrupt"), EnvAdrr.from("threadID"));
    }
}

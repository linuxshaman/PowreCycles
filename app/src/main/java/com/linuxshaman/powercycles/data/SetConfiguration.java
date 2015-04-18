package com.linuxshaman.powercycles.data;

/**
 * Created by linuxshaman on 12.04.2015.
 */
public class SetConfiguration {

    public int getWeightId() {
        return weightId;
    }

    public int getSets() {
        return sets;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    private int weightId;
    private int sets;
    private int repeatCount;

    public SetConfiguration(){
        weightId = 0;
        sets = 0;
        repeatCount = 0;
    }

    public SetConfiguration(int w, int s, int r){
        weightId = w;
        sets = s;
        repeatCount = r;
    }
}

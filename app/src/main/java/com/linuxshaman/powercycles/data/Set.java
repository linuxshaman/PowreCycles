package com.linuxshaman.powercycles.data;

/**
 * Created by linuxshaman on 04.04.2015.
 */
public class Set {
    protected float weight;
    protected int repeatCount;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public Set() {
        weight = 0;
        repeatCount = 0;
    }

    public Set(float weight, int repeatCount) {
        this.weight = weight;
        this.repeatCount = repeatCount;
    }
}

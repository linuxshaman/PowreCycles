package com.linuxshaman.powercycles.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linuxshaman on 04.04.2015.
 */
public class Training implements Serializable {
    protected List<Set> sets;

    public Training() {
        sets = new ArrayList<Set>();
    }

    public List<Set> getSets() {
        return sets;
    }

    void addSet(Set set){
        sets.add(set);
    }
}

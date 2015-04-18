package com.linuxshaman.powercycles.data;

import java.util.List;

/**
 * Created by linuxshaman on 12.04.2015.
 */
public class TrainingConfiguration {
    public List<SetConfiguration> getSets() {
        return sets;
    }

    private List<SetConfiguration> sets;

    public TrainingConfiguration(List<SetConfiguration> sets){
        this.sets = sets;
    }
}

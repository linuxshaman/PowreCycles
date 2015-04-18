package com.linuxshaman.powercycles.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linuxshaman on 04.04.2015.
 */
public class PowerCycle {

    protected  List<Training> trainings;
    protected String name;
    protected PowerCycleType type;

    public List<Training> getTrainings() {
        return trainings;
    }

    public PowerCycle(PowerCycleType type, String name, float weight) {
        this.type = type;
        this.name = name;
        this.trainings = new ArrayList<Training>();

        WeightDistribution d = new WeightDistribution(type, weight);
        List<Float> weights = d.getWeights();
        PowerCycleConfiguration conf = new PowerCycleConfiguration(type);
        List<TrainingConfiguration> tconfs = conf.getTrainings();
        for(TrainingConfiguration tc : tconfs){
            Training training = new Training();
            List<SetConfiguration> sconfs = tc.getSets();
            for(SetConfiguration sc : sconfs) {
                Set set = new Set(sc.getWeightId(), sc.getRepeatCount());
                for (int i = 0; i < sc.getSets(); i++) {
                    training.addSet(set);
                }
            }
            trainings.add(training);
        }
    }

    void addTraining(Training training){
        trainings.add(training);
    }

    public PowerCycleType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}

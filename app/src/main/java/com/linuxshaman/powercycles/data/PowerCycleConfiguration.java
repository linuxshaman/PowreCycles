package com.linuxshaman.powercycles.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by linuxshaman on 12.04.2015.
 */
public class PowerCycleConfiguration {
    public List<TrainingConfiguration> getTrainings() {
        return trainings;
    }

    private List<TrainingConfiguration> trainings;


    private static List<TrainingConfiguration> getDeadLiftTrainingConfiguration(){
        List<TrainingConfiguration> confs = new ArrayList<TrainingConfiguration>();







        return confs;
    }

    private static List<TrainingConfiguration> getBarbellBrenchPressTrainingConfiguration(){
        List<TrainingConfiguration> confs = new ArrayList<TrainingConfiguration>();
        return confs;
    }

    private static List<TrainingConfiguration> getBarbellFullSquatTrainingConfiguration(){
        List<TrainingConfiguration> confs = new ArrayList<TrainingConfiguration>();

        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 2, 4), new SetConfiguration(2, 5, 3)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 3, 4), new SetConfiguration(2, 6, 3)})));

        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 2, 3), new SetConfiguration(2, 2, 3), new SetConfiguration(3, 2, 3)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(0, 1, 4), new SetConfiguration(1, 1, 4), new SetConfiguration(2, 2, 3), new SetConfiguration(3, 4, 2)})));

        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(0, 1, 5), new SetConfiguration(1, 2, 4), new SetConfiguration(2, 2, 3), new SetConfiguration(3, 3, 3)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 2, 4), new SetConfiguration(2, 4, 4), new SetConfiguration(3, 3, 2)})));


        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(0, 1, 4), new SetConfiguration(1, 2, 4), new SetConfiguration(2, 3, 3), new SetConfiguration(3, 2, 3)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 2, 4), new SetConfiguration(2, 4, 4)})));


        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(0, 1, 5), new SetConfiguration(1, 2, 4), new SetConfiguration(2, 2, 3), new SetConfiguration(3, 1, 3), new SetConfiguration(4, 4, 3)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(0, 1, 5), new SetConfiguration(1, 1, 5), new SetConfiguration(2, 1, 5), new SetConfiguration(3, 1, 4), new SetConfiguration(4, 3, 3), new SetConfiguration(5, 1, 3)})));


        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 1, 4), new SetConfiguration(2, 2, 4), new SetConfiguration(3, 4, 3)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(2, 2, 4), new SetConfiguration(3, 3, 3)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 3, 4), new SetConfiguration(2, 2, 3), new SetConfiguration(3, 2, 3), new SetConfiguration(4, 2, 3), new SetConfiguration(5, 1, 2)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 2, 3), new SetConfiguration(2, 2, 3), new SetConfiguration(3, 2, 3), new SetConfiguration(4, 2, 3), new SetConfiguration(5, 2, 3)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 1, 4), new SetConfiguration(2, 1, 4), new SetConfiguration(3, 1, 4), new SetConfiguration(4, 3, 4)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(0, 1, 4), new SetConfiguration(1, 2, 4), new SetConfiguration(2, 2, 3), new SetConfiguration(3, 2, 3), new SetConfiguration(4, 2, 2)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 1, 4), new SetConfiguration(2, 2, 4), new SetConfiguration(3, 2, 4), new SetConfiguration(4, 2, 3), new SetConfiguration(5, 2, 3), new SetConfiguration(6, 2, 2)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 1, 4), new SetConfiguration(2, 2, 4), new SetConfiguration(3, 2, 3), new SetConfiguration(4, 2, 2), new SetConfiguration(5, 2, 2)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 1, 6), new SetConfiguration(2, 2, 5), new SetConfiguration(3, 2, 4), new SetConfiguration(4, 2, 3), new SetConfiguration(5, 3, 2)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 2, 6), new SetConfiguration(2, 2, 5), new SetConfiguration(3, 3, 4)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 1, 5), new SetConfiguration(2, 2, 5), new SetConfiguration(3, 2, 4), new SetConfiguration(4, 2, 3), new SetConfiguration(5, 2, 3), new SetConfiguration(6, 2, 2)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 1, 5), new SetConfiguration(2, 1, 4), new SetConfiguration(3, 2, 3), new SetConfiguration(4, 2, 3), new SetConfiguration(5, 1, 2), new SetConfiguration(6, 3, 2)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(2, 1, 4), new SetConfiguration(3, 2, 4), new SetConfiguration(4, 2, 4), new SetConfiguration(5, 1, 3), new SetConfiguration(6, 1, 2)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 1, 4), new SetConfiguration(2, 2, 4), new SetConfiguration(3, 2, 4), new SetConfiguration(4, 1, 3), new SetConfiguration(5, 1, 2)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(3, 1, 4), new SetConfiguration(4, 2, 3), new SetConfiguration(5, 2, 3), new SetConfiguration(6, 2, 2), new SetConfiguration(7, 1, 1)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 1, 5), new SetConfiguration(2, 3, 4), new SetConfiguration(3, 3, 4), new SetConfiguration(4, 2, 2), new SetConfiguration(5, 1, 2), new SetConfiguration(6, 2, 1), new SetConfiguration(7, 1, 1)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(2, 2, 3), new SetConfiguration(3, 2, 3), new SetConfiguration(4, 2, 3), new SetConfiguration(5, 2, 3), new SetConfiguration(6, 2, 2)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(2, 1, 4), new SetConfiguration(3, 2, 3), new SetConfiguration(4, 2, 3), new SetConfiguration(5, 1, 2)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(3, 2, 3), new SetConfiguration(4, 2, 3), new SetConfiguration(5, 2, 2), new SetConfiguration(6, 2, 1), new SetConfiguration(7, 1, 1), new SetConfiguration(8, 1, 1)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(1, 1, 3), new SetConfiguration(2, 1, 3), new SetConfiguration(3, 2, 2), new SetConfiguration(4, 3, 1)})));
        confs.add(new TrainingConfiguration(Arrays.asList(new SetConfiguration[]{new SetConfiguration(2, 4, 3), new SetConfiguration(3, 3, 2), new SetConfiguration(4, 1, 2), new SetConfiguration(5, 1, 1)})));
        return confs;
    }






    public PowerCycleConfiguration(PowerCycleType type){
        switch (type){
            case POWER_CYCLE_TYPE_BARBELL_BRENCH_PRESS:
                trainings = getBarbellBrenchPressTrainingConfiguration();
                break;
            case POWER_CYCLE_TYPE_BARBELL_FULL_SQUAT:
                trainings = getBarbellFullSquatTrainingConfiguration();
                break;
            case POWER_CYCLE_TYPE_DEADLIFT:
                trainings = getDeadLiftTrainingConfiguration();
                break;
            default:
                break;
        }
    }
}

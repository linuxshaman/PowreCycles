package com.linuxshaman.powercycles.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linuxshaman on 12.04.2015.
 */
public class WeightDistribution {

    public List<Float> getWeights() {
        return weights;
    }

    private List<Float> weights;


    public WeightDistribution(PowerCycleType type, float maxWeight){
        weights = new ArrayList<>();
        float k = 0.6f;
        float step = 0.05f;
        if(type == PowerCycleType.POWER_CYCLE_TYPE_BARBELL_BRENCH_PRESS){
            weights.add(maxWeight * 0.5f);
        }
        for(int i = 0; i < 9; i ++){
            float weight = maxWeight * k;
            weights.add(weight);
            k += step;
        }
        if(type == PowerCycleType.POWER_CYCLE_TYPE_BARBELL_BRENCH_PRESS || type == PowerCycleType.POWER_CYCLE_TYPE_BARBELL_FULL_SQUAT){
            k += 0.025;
            weights.add(maxWeight * k);
        }
    }
}

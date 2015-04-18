package com.linuxshaman.powercycles.data;

import com.linuxshaman.powercycles.R;

/**
 * Created by linuxshaman on 08.04.2015.
 */
public class PowerCyclesHelper {

    public static int getResourceFromPowerCycleType(PowerCycleType type){
        switch (type){
            case POWER_CYCLE_TYPE_DEADLIFT:
                return R.string.power_cycle_type_dead_lift;
            case POWER_CYCLE_TYPE_BARBELL_BRENCH_PRESS:
                return R.string.power_cycle_type_barbell_full_squat;
            case POWER_CYCLE_TYPE_BARBELL_FULL_SQUAT:
                return R.string.power_cycle_typeE_barbell_brench_press;
            default:
                return Integer.MIN_VALUE;
        }
    }
}

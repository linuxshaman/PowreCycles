package com.linuxshaman.powercycles.controllers;

import com.linuxshaman.powercycles.data.PowerCycle;
import com.linuxshaman.powercycles.data.PowerCycleType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linuxshaman on 04.04.2015.
 */
public class PowerCyclesManager {

    protected List<PowerCycle> powerCycles;

    private PowerCyclesManager() {
        powerCycles = new ArrayList<PowerCycle>();
    }

    public List<PowerCycle> getPowerCycles() {
        return powerCycles;
    }

    PowerCycle getCycleById(int id){
        return powerCycles.get(id);
    }

    private static PowerCyclesManager __instance = null;
    public static PowerCyclesManager getInstance(){
        if(__instance == null){
            __instance = new PowerCyclesManager();
        }
        return __instance;
    }

    public void addNewCycle(String name, float weight, PowerCycleType type){
        PowerCycle cycle = new PowerCycle(type, name, weight);
        getInstance().powerCycles.add(cycle);
        getInstance().save();
    }

    public void save(){

    }
}

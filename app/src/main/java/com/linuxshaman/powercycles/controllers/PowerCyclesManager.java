package com.linuxshaman.powercycles.controllers;

import com.linuxshaman.powercycles.data.PowerCycle;
import com.linuxshaman.powercycles.data.PowerCycleType;
import com.linuxshaman.powercycles.helpers.IOHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linuxshaman on 04.04.2015.
 */
public class PowerCyclesManager{

    protected List<PowerCycle> powerCycles;

    private PowerCyclesManager() {
        powerCycles = loadCycles();
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
        getInstance().saveCycles();
        IOHelper.saveIntegerDataForKey(cycle.getName(), 0);
    }

    public int getCycleProgress(PowerCycle cycle){
        return IOHelper.readIntegerDataForKey(cycle.getName());
    }

    public void updateCycleProgress(PowerCycle cycle, int progress){
        IOHelper.saveIntegerDataForKey(cycle.getName(), progress);
    }

    public void incrementCycleProgress(PowerCycle cycle){
        int progress = IOHelper.readIntegerDataForKey(cycle.getName());
        if(progress == Integer.MIN_VALUE){
            progress = 0;
        }else{
            progress ++;
        }
        IOHelper.saveIntegerDataForKey(cycle.getName(), progress);
    }

    public void saveCycles() {
        if (powerCycles == null || powerCycles.size() == 0) return;
        IOHelper.serializeObjectToStringAndSaveWithKey((Serializable) powerCycles, IOHelper.POWER_CYCLES_KEY);
    }

    private List<PowerCycle>  loadCycles() {
        String encodedString = IOHelper.readStringDataForKey(IOHelper.POWER_CYCLES_KEY);
        Object object = IOHelper.deserializeObjectFromString(encodedString);
        if(object == null) {
            return new ArrayList<PowerCycle>();
        }
        return (ArrayList<PowerCycle>)object;
    }
}

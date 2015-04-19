package com.linuxshaman.powercycles.controllers;

import android.util.Base64;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;

import com.linuxshaman.powercycles.data.PowerCycle;
import com.linuxshaman.powercycles.data.PowerCycleType;
import com.linuxshaman.powercycles.helpers.IOHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linuxshaman on 04.04.2015.
 */
public class PowerCyclesManager{

    protected List<PowerCycle> powerCycles;

    private PowerCyclesManager() {
        powerCycles = load();
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
        if(powerCycles == null || powerCycles.size() == 0) return;
        String toSave = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try{
            new ObjectOutputStream(out).writeObject(powerCycles);
            byte[] data =  out.toByteArray();
            out.close();

            out = new ByteArrayOutputStream();
            Base64OutputStream b64 = new Base64OutputStream(out, Base64.DEFAULT);
            b64.write(data);
            b64.close();
            out.close();

            toSave =  new String(out.toByteArray());
        }catch (IOException e){
            e.printStackTrace();
        }
        if(toSave != null){
            IOHelper.saveData(IOHelper.POWER_CYCLES_KEY, toSave);
        }
    }

    private List<PowerCycle>  load(){
        String encodedObject = IOHelper.readData(IOHelper.POWER_CYCLES_KEY);
        if(encodedObject != null){
            try{
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(encodedObject.getBytes());
                Base64InputStream base64InputStream = new Base64InputStream(byteArrayInputStream, Base64.DEFAULT);
                ObjectInputStream objectInputStream = new ObjectInputStream(base64InputStream);
                return (ArrayList<PowerCycle>)objectInputStream.readObject();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return new ArrayList<PowerCycle>();
    }
}

package com.linuxshaman.powercycles.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by linuxshaman on 19.04.2015.
 */
public class IOHelper {


    private static final String APPLICATION_KEY = "power_cycles_app";
    public static final String POWER_CYCLES_KEY = "power_cycles";
    public static final String USER_PROGRESS_KEY = "user_progress";
    public static final String SETTINGS_KEY = "settings";

    private static Activity currentContext = null;

    public static void setContext(Activity context){
        currentContext = context;
    }

    public static String readData(String key){
        SharedPreferences preferences = currentContext.getPreferences(Context.MODE_PRIVATE);
        if(preferences == null){
            SharedPreferences.Editor editor = preferences.edit();
            editor.commit();
            return null;
        }
        return preferences.getString(key, null);
    }

    public static void saveData(String key, String value){
        SharedPreferences preferences = currentContext.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }


    public static void serializeObjectToStringAndSaveWithKey(Serializable serializableObject, String key){
        String toSave = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try{
            new ObjectOutputStream(out).writeObject(serializableObject);
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

    public static Object deserializeObjectFromString(String encodedObject){
        if(encodedObject != null){
            try{
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(encodedObject.getBytes());
                Base64InputStream base64InputStream = new Base64InputStream(byteArrayInputStream, Base64.DEFAULT);
                ObjectInputStream objectInputStream = new ObjectInputStream(base64InputStream);
                return objectInputStream.readObject();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}

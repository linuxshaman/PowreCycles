package com.linuxshaman.powercycles.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import java.io.File;

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
}

package com.slava.adapterexamples;

import android.util.Log;

/**
 * Created by Slava on 28.03.2017.
 */

public class LogUtil {
    public static void info(Object o, String message) {
        Log.d(o.getClass().getName(), message);
    }
}

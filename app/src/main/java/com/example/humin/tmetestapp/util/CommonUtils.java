package com.example.humin.tmetestapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.view.Display;

/**
 * Created by humin on 12/28/2017.
 */

public class CommonUtils {

    public static Point getDefaultDisplaySize(Activity activity) {
        Point size = new Point();
        Display d = activity.getWindowManager().getDefaultDisplay();
        d.getSize(size);
        return size;
    }

    public static boolean checkPermission(Context context, String permission){
        if (Build.VERSION.SDK_INT >= 23) {
            int result = ContextCompat.checkSelfPermission(context, permission);
            if (result == PackageManager.PERMISSION_GRANTED){
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}

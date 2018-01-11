package com.example.humin.tmetestapp.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;

import java.util.Random;

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
}

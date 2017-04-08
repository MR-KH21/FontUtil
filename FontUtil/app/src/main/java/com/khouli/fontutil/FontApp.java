package com.khouli.fontutil;

import android.app.Application;
import android.graphics.Typeface;

import com.khouli.font.FontUtil;

import java.util.HashMap;

/**
 * Created by mohanad.khouli on 05/04/2017.
 */

public class FontApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HashMap<String,String> fontsMap = new HashMap<>();
        fontsMap.put(this.getResources().getString(R.string.pacifico_font),"fonts/Pacifico.ttf");
        FontUtil.init(this,fontsMap);
        //FontUtil.applyFont(Typeface.createFromAsset(getAssets(),"fonts/Pacifico.ttf"));
    }
}

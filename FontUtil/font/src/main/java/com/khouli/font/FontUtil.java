package com.khouli.font;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohanad.khouli on 05/04/2017.
 */

public class FontUtil {

    private static HashMap<String,Typeface> typefaceMap;
    private static Typeface typeface = null;
    public static void init(Context context, Map<String, String> fonts){
        //fonts map has the name of the font and the string of the typeface file in assets directory
        typeface = null;
        typefaceMap = new HashMap<>(fonts.size());
        for (Map.Entry<String, String> entry : fonts.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            typefaceMap.put(entry.getKey().toLowerCase(),Typeface.createFromAsset(context.getAssets(),entry.getValue()));
        }
    }

    public static void applyFont( Typeface typeface) {
        FontUtil.typeface = typeface;
    }

    public static boolean applyFontToAllViews() {
        return null != typeface;
    }

    public static Typeface getTypeface() {
        return typeface;
    }

    public static Typeface getTypeFace(String fontKey) {
        try {
            if (typefaceMap.containsKey(fontKey.toLowerCase())) {
                return typefaceMap.get(fontKey);
            } else {
                return null;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

}

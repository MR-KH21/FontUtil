package com.khouli.font;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.widget.TextViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Constructor;

/**
 * Created by mohanad.khouli on 05/04/2017.
 */

public class UtilLayoutInflater implements LayoutInflater.Factory {

    @Override
    public View onCreateView(String name, Context context, AttributeSet attributeSet) {

        try {
            Class<?> clazz =null;
            try {
                clazz = Class.forName("android.widget."+name);
            }catch (ClassNotFoundException ex) {
                clazz = Class.forName("android.support.v4.widget."+name);
            }
            Constructor<?> constructor = clazz.getConstructor(Context.class, AttributeSet.class);
            Object view = constructor.newInstance(context, attributeSet);

            if (view instanceof TextView || view instanceof TextViewCompat) {

                TextView inflatedView = (TextView) view;
                if (FontUtil.applyFontToAllViews()) {

                      inflatedView.setTypeface(FontUtil.getTypeface());

                } else if (inflatedView.getTag() != null) {
                    Typeface selectedFont = FontUtil.getTypeFace((String) inflatedView.getTag());
                    try {

                        if (selectedFont != null) {
                            inflatedView.setTypeface(selectedFont);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return inflatedView;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

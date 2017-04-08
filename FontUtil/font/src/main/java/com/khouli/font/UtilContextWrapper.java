package com.khouli.font;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;

/**
 * Created by mohanad.khouli on 05/04/2017.
 */

public class UtilContextWrapper extends ContextWrapper {
    public UtilContextWrapper(Context base) {
        super(base);
        LayoutInflater.from(base).setFactory(new UtilLayoutInflater());
    }



}

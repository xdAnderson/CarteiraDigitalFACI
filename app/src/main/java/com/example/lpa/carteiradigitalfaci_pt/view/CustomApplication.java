package com.example.lpa.carteiradigitalfaci_pt.view;

import android.app.Application;

import com.example.lpa.carteiradigitalfaci_pt.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("futura.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
}

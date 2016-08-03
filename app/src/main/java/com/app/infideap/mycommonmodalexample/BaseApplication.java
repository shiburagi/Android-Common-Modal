package com.app.infideap.mycommonmodalexample;

import android.app.Application;

import com.app.infideap.stylishwidget.view.Stylish;

/**
 * Created by Shiburagi on 02/08/2016.
 */
public class BaseApplication extends Application{


    private static final String FONT_FOLDER = "fonts/Architects_Daughter/";

    @Override
    public void onCreate() {
        super.onCreate();

        Stylish.getInstance().set(
                FONT_FOLDER.concat("ArchitectsDaughter.ttf"),
                FONT_FOLDER.concat("ArchitectsDaughter.ttf"),
                FONT_FOLDER.concat("ArchitectsDaughter.ttf")
        );
    }
}

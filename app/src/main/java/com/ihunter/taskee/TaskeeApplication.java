package com.ihunter.taskee;

import android.app.Activity;
import android.app.Application;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class TaskeeApplication extends Application{

    private Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath(getString(R.string.ff_clan_ot_book))
                        .setFontAttrId(R.attr.fontPath)
                        .build());
        Iconics.registerFont(new FontAwesome());
        Iconics.registerFont(new MaterialDesignIconic());
        realm = Realm.getInstance(getRealmConfiugration());
    }

    private RealmConfiguration getRealmConfiugration(){
        return new RealmConfiguration.Builder()
                .name("taskmanager.realm")
                .schemaVersion(0)
                .build();
    }

    public Realm getRealm(){return realm;}

    public static TaskeeApplication get(Activity activity){
        return (TaskeeApplication)activity.getApplication();
    }

}



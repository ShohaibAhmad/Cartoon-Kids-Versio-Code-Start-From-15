package com.promoteprovider.cartoonkids;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveMode {
    Context context;
    SharedPreferences sharedPreferences;

    public SaveMode(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("preferences",Context.MODE_PRIVATE);
    }
    public void setState(boolean bValue){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("bKey",bValue);
        editor.apply();

    }
    public Boolean getState(){
        return sharedPreferences.getBoolean("bKey",false);
    }
}
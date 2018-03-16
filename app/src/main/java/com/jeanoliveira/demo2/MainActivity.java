package com.jeanoliveira.demo2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Switch simpleSwitch;

    //This method handles changing the theme
    private void toggleTheme(boolean darkTheme) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("dark_theme", darkTheme);
        editor.apply();

        //Recreates the activity in order to load the new theme
        this.recreate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean useDarkTheme = preferences.getBoolean("dark_theme", false);

        if(useDarkTheme) {
            setTheme(R.style.AppThemeDark);
        } else {
            setTheme(R.style.AppThemeLight);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleSwitch = findViewById(R.id.swTheme);
        simpleSwitch.setChecked(useDarkTheme);

        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    toggleTheme(isChecked);
                } else {
                    toggleTheme(isChecked);
                }
            }
        });
    }
}

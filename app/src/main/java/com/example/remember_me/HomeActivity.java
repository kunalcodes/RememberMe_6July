package com.example.remember_me;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView mTvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTvName = findViewById(R.id.tvName);

        String name = PreferenceHelper.getStringFromPreference(HomeActivity.this,"Name");
        mTvName.setText(name);
    }
}
package com.example.remember_me;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtName;
    private EditText mEtPassword;
    private CheckBox mCbRemember;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEtName = findViewById(R.id.etName);
        mEtPassword = findViewById(R.id.etPassword);
        mCbRemember = findViewById(R.id.cbRemember);
        mBtnLogin = findViewById(R.id.btnLogin);

        int Remember = PreferenceHelper.getIntFromPreference(MainActivity.this,"Status");
        if (Remember == 1){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mEtName.getText().toString();
                PreferenceHelper.writeStringToPreference(MainActivity.this,"Name", name);
                if (mCbRemember.isChecked()==true){
                    int status = 1;
                    PreferenceHelper.writeIntToPreference(MainActivity.this,"Status", status);
                } else {
                    int status = 0;
                    PreferenceHelper.writeIntToPreference(MainActivity.this,"Status", status);

                }
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });


    }
}
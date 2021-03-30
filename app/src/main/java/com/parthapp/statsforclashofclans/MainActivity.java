package com.parthapp.statsforclashofclans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {
    private Button btnSearch;
    private EditText userTag;
    public static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBarUtil.setTransparent(this);
        btnSearch = findViewById(R.id.btnSearch);
        userTag = findViewById(R.id.userInput);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isUserTagValid()){
                    openFragmentActivity();
                }
            }
        });
    }

    public void openFragmentActivity(){
        Intent intent = new Intent(this, FragmentActivity.class);
        startActivity(intent);
        finish();
    }

    public boolean isUserTagValid(){
        if(userTag.getText().toString().equals("")){
            Toast.makeText(this, "Can't have Empty User Tag", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            Toast.makeText(this, "Good to go", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
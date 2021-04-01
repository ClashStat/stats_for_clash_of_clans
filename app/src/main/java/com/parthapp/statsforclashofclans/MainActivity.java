package com.parthapp.statsforclashofclans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
    private String userTagString = "";
    private static boolean LogInStatus;
    public static final String TAG = "Main Activity";
    private static int buttonCounter = 0;

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
        intent.putExtra("userTag",userTagString );
        intent.putExtra("LoginStatus", LogInStatus);
        startActivity(intent);
        finish();
    }

    public boolean isUserTagValid(){
        userTagString = userTag.getText().toString();
        if(userTagString.equals("")){
            buttonCounter++;
            if(buttonCounter % 2 == 0) {
                return true;
            }
            Log.i(TAG, String.valueOf(buttonCounter));
            Toast.makeText(this, "Empty, click once more to choose randomly", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            if(userTagString.matches("^#[A-Z0-9]{9}$")){
                Toast.makeText(this, "Matches", Toast.LENGTH_LONG).show();
                LogInStatus = true;
                return true;
            }
            else{
                Toast.makeText(this, "Incorrect Format!", Toast.LENGTH_LONG).show();
                return false;
            }
        }
    }
}
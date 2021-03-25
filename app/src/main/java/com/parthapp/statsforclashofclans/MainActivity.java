package com.parthapp.statsforclashofclans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBarUtil.setTransparent(this);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragmentActivity();
            }
        });
    }

    public void openFragmentActivity(){
        Intent intent = new Intent(this, FragmentActivity.class);
        startActivity(intent);
    }
}
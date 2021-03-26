package com.parthapp.statsforclashofclans;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import java.io.IOException;
=======
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jaeger.library.StatusBarUtil;
>>>>>>> bb47af8790e56ce4c973c702674c67a0e6527cfd

public class MainActivity extends AppCompatActivity {
    private Button btnSearch;
    private EditText userInput;

    String playerTag = "#2JQ299028";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD

        ClashAdapter clash = new ClashAdapter("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjEwYmRmOWExLTI4NGQtNDIzNS05ZGVjLThmZWEwZjQxMDI2NCIsImlhdCI6MTYxNjYxMTY5OSwic3ViIjoiZGV2ZWxvcGVyL2Y1YTljYzdhLWM3MzQtZThjNC1lYTZiLThhODBkNDQ1N2I0ZCIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjEwMC4xLjEyMi4yMDQiLCIyNC4wLjI0LjIzMCIsIjEwMC4xLjE3Ny4yNDciXSwidHlwZSI6ImNsaWVudCJ9XX0.AvfXk-wfWc3K98AdoPlW8dyID6cl8pyMclYG7kF42FVnhxmxYUO70nspLcSLC5vA4ZXLPe7JfMZrA407uEXk3g");

        try {
            clash.getPlayer(playerTag);
        } catch (IOException e) {
            e.printStackTrace();
        }
=======
        StatusBarUtil.setTransparent(this);
        btnSearch = findViewById(R.id.btnSearch);
        userInput = findViewById(R.id.userInput);

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
        finish();
>>>>>>> bb47af8790e56ce4c973c702674c67a0e6527cfd
    }
}
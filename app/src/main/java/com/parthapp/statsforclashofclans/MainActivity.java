package com.parthapp.statsforclashofclans;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String playerTag = "#2JQ299028";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ClashAdapter clash = new ClashAdapter("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjEwYmRmOWExLTI4NGQtNDIzNS05ZGVjLThmZWEwZjQxMDI2NCIsImlhdCI6MTYxNjYxMTY5OSwic3ViIjoiZGV2ZWxvcGVyL2Y1YTljYzdhLWM3MzQtZThjNC1lYTZiLThhODBkNDQ1N2I0ZCIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjEwMC4xLjEyMi4yMDQiLCIyNC4wLjI0LjIzMCIsIjEwMC4xLjE3Ny4yNDciXSwidHlwZSI6ImNsaWVudCJ9XX0.AvfXk-wfWc3K98AdoPlW8dyID6cl8pyMclYG7kF42FVnhxmxYUO70nspLcSLC5vA4ZXLPe7JfMZrA407uEXk3g");

        try {
            clash.getPlayer(playerTag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
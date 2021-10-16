package com.example.savescripture;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DisplayMessageActivity extends AppCompatActivity {
    private static final String TAG = "DisplayMessageActivity";
    //ButterKnife
    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.saveScripture) void submit(View view) {
        Toast.makeText(this, "Works :D", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        TextView tvReceivedData  = (TextView) findViewById(R.id.addingBook);
        
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);


        if (bundle != null){
            String book = bundle.getString("Book");
            int verse = bundle.getInt("Verse");
            int chapter = bundle.getInt("Chapter");
            String message = book + " " + chapter + ":" + verse ;
            tvReceivedData.setText(message);
            Log.e(TAG, "Received intent with " + book + " " + chapter + ":" + verse  );
        }
    }
}
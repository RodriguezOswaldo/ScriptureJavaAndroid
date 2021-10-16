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
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.addingBook) TextView tvReceivedData;
    //ButterKnife
    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.saveScripture) void submit(View view) {
        SharedPreferences sharedPref = getSharedPreferences("session" ,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("SavedScripture", tvReceivedData.getText().toString()).apply();

        Toast.makeText(this, "Scripture was saved successfully.", Toast.LENGTH_LONG ).show();

        Toast.makeText(this, sharedPref.getString("SavedScripture", "error"), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();

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
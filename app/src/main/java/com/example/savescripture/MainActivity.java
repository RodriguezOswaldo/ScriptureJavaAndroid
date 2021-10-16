package com.example.savescripture;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.scriptureRetrieved) TextView scRetrieved;

    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.loadScripture) void loadScripture(View view) {
        SharedPreferences sharedPref = getSharedPreferences("session" , Context.MODE_PRIVATE);
        String result = sharedPref.getString("SavedScripture", "error");
        scRetrieved.setText(result);
        Toast.makeText(this,  result, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    //Called when the user taps the Send button
    //event triggered when the button is clicked
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.scriptureBook);
        EditText chapterInput = (EditText) findViewById(R.id.scriptureChapter);
        EditText verseInput = (EditText) findViewById(R.id.scriptureVerse);
        String message = editText.getText().toString();
        int chapter = Integer.parseInt(chapterInput.getText().toString());
        int verse = Integer.parseInt(verseInput.getText().toString());
        Log.e(TAG, "About to create intent with " + message + " " + chapter + ":" + verse  );
        intent.putExtra("Book", message);
        intent.putExtra("Chapter", chapter);
        intent.putExtra("Verse", verse);
        startActivity(intent);
        //
    }
}
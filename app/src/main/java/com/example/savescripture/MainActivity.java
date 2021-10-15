package com.example.savescripture;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        intent.putExtra("Book", message);
        intent.putExtra("Chapter", chapter);
        intent.putExtra("Verse", verse);
        startActivity(intent);
    }
}
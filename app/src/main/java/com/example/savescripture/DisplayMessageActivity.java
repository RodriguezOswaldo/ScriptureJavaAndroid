package com.example.savescripture;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Bundle bundle = getIntent().getExtras();
        TextView tvReceivedData  = (TextView) findViewById(R.id.addingBook);
        if (bundle != null){
            String book = bundle.getString("Book");
            int verse = bundle.getInt("Verse");
            int chapter = bundle.getInt("Chapter");
            String message = book + " " + chapter + ":" + verse ;
            tvReceivedData.setText(message);
        }
    }
}
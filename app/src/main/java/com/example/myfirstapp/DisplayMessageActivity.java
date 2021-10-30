package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DisplayMessageActivity extends AppCompatActivity {
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message1 = intent.getStringExtra("message1");
        String message2 = intent.getStringExtra("message2");
        String message3 = intent.getStringExtra("message3");
        String message4 = intent.getStringExtra("message4");
        String message5 = intent.getStringExtra("message5");
        String message6 = intent.getStringExtra("message6");

        // Capture the layout's TextView and set the string as its text
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView6 = findViewById(R.id.textView6);
        TextView textViewMessage = findViewById(R.id.textViewMessage);
        textView1.setText(message1);
        textView2.setText(message2);
        textView3.setText(message3);
        textView4.setText(message4);
        textView5.setText(message5);
        textView6.setText(message6);

        //Save Data
        Context context = getApplicationContext();

        String fileName = "AppData.txt";
        file = new File(context.getFilesDir(), fileName);

        Button buttonSave = findViewById(R.id.saveData);

        // lambda
        buttonSave.setOnClickListener( v -> {
            saveFile(message1);
            textViewMessage.setText(R.string.saved);
        });

        Button buttonRead = findViewById(R.id.readData);
        // lambda
        buttonRead.setOnClickListener( v -> {
            String str = readFile();
            if (str != null) {
                textViewMessage.setText(str);
            } else {
                textViewMessage.setText(R.string.read_error);
            }
        });
    }

    // ファイルを保存
    public void saveFile(String str) {
        // try-with-resources
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(str);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ファイルを読み出し
    public String readFile() {
        String text = null;

        // try-with-resources
        try(
                BufferedReader br = new BufferedReader(new FileReader(file))
        ){
            text = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }
}

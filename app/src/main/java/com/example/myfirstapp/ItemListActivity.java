package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ItemListActivity extends AppCompatActivity {
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlist);

        setupViews(this);
    }

    private void setupViews(Context context) {
        TextView textView1 = findViewById(R.id.textView1);
        String fileName = "AppData.txt";
        file = new File(context.getFilesDir(), fileName);
        String str = readFile();
        if (str != null) {
            textView1.setText(str);
        } else {
            textView1.setText(R.string.read_error);
        }
    }

    // ファイルを読み出し
    public String readFile() {
        String text = null;

        // try-with-resources
        try (
                BufferedReader br = new BufferedReader(new FileReader(file))
        ) {
            text = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }
}

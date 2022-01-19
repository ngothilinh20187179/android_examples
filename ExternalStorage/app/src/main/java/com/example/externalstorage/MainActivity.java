package com.example.externalstorage;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    File currentDir = Environment.getExternalStorageDirectory();
    List<Model> files = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (currentDir != null) {
            for (File obj : Objects.requireNonNull(currentDir.listFiles())) {
                files.add(new Model(obj.getName()));
            }
        }

        Adapter adapter = new Adapter(files);
        ListView listFile = findViewById(R.id.listFile);
        listFile.setAdapter(adapter);

        listFile.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            try {
                intent.putExtra("detail", readFile(files.get(position).getFile()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            startActivity(intent);
        });
    }

    @NonNull
    private String readFile(String fileName) throws IOException {
        File file = new File(currentDir, fileName);
        StringBuilder stringBuilder = new StringBuilder();
        if (file.isFile()) {
            BufferedReader br;
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            br.close();
            return stringBuilder.toString();
        }
        else if (file.isDirectory()){
            for (File obj : Objects.requireNonNull(file.listFiles())) {
                stringBuilder.append(obj.getName());
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
        return "null";
    }
}
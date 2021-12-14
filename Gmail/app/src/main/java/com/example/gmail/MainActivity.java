package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<EmailModel> emails;
    String[] names = { "Abundance", "Anxiety", "Google", "Hust", "App Store", "Android Studio", "Youtube",
            "Bruxism", "Discipline", "Drug Addiction", "Facebook", "Instagram", "Zalo", "Codecademy", "GitLab", "GitHub"};
    String[] contents ={"Hello", "Hi", "Bonjour", "Salut", "Coucou", "Hello, i am Linh", "I love you hihi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emails = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 50; i++){
            emails.add(new EmailModel(names[r.nextInt(names.length)], contents[r.nextInt(contents.length)]));
            emails.get(i).setAvatarText(emails.get(i).getSenderName().substring(0, 1));
            //emails.get(i).setFavouriteImg(R.drawable.ic_baseline_star_border_24);
        }

        EmailAdapter adapter = new EmailAdapter(emails);
        ListView listView = findViewById(R.id.list_email);
        listView.setAdapter(adapter);
    }
}
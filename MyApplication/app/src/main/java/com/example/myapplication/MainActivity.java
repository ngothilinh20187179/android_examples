package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<UserModel> users = new ArrayList<>();
    ListView listView;
    TextView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_user);
        imageView = findViewById(R.id.imageView);
        new GetTask().execute();
    }

    public class GetTask extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            String responseBody = "";
            try {
                URL url = new URL("https://lebavui.github.io/jsons/users.json");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder builder = new StringBuilder();
                while((line = reader.readLine()) != null){
                    builder.append(line);
                }
                responseBody = builder.toString();
                return responseBody;
            }catch (Exception ex){
                ex.printStackTrace();
            }
            return responseBody;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i=0; i<jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String userName = jsonObject.getString("username");
                    users.add(new UserModel(userName, jsonObject.getString("email")));
                    users.get(i).setAvatar(userName.substring(0, 1));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UserAdapter adapter = new UserAdapter(users);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    try {
                        JSONArray jsonArray = new JSONArray(s);
                        JSONObject jsonObject = jsonArray.getJSONObject(position);
                        JSONObject addressObj = jsonObject.getJSONObject("address");
                        JSONObject companyObj = jsonObject.getJSONObject("company");
                        JSONObject avatarObj = jsonObject.getJSONObject("avatar");

                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("name", jsonObject.getString("name"));
                        intent.putExtra("userName", jsonObject.getString("username"));
                        intent.putExtra("email", "Email: " + jsonObject.getString("email"));
                        intent.putExtra("address", "Address: " + addressObj.getString("street") + ", " + addressObj.getString("city") + "\n, zipcode" + addressObj.getString("zipcode"));
                        intent.putExtra("company", "Company: " + companyObj.getString("name"));
                        intent.putExtra("phone", "Phone: " + jsonObject.getString("phone"));
                        intent.putExtra("avatar", avatarObj.getString("photo"));

                        startActivity(intent);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }
}
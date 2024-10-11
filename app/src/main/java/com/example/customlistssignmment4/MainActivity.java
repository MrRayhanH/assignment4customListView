package com.example.customlistssignmment4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] title = {"CSE", "EEE", "CIVIL"};
    String[] subTitle = {"1st", "2nd", "3rd"};
    int[] image = new int[]{R.drawable.one, R.drawable.two, R.drawable.three};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView)findViewById(R.id.costomListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), title, subTitle, image);
        listView.setAdapter(customBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "click "+ position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, itemlistview.class);
                //intent.putExtra("Image", image[position]);
                intent.putExtra("Tittle", title[position]);
                intent.putExtra("Subtitle", subTitle[position]);
                startActivity(intent);
            }
        });

    }
}
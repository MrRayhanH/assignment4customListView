package com.example.customlistssignmment4;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class itemlistview extends AppCompatActivity {

    TextView title, subtitle;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlistview);

        // Initialize the views
        title = findViewById(R.id.tv_single_Tittle);
        subtitle = findViewById(R.id.tv_singlge_Subtittle);
        imageView = findViewById(R.id.singleImageView);

        // Get intent extras
        String titleText = getIntent().getStringExtra("Tittle");
        String subtitleText = getIntent().getStringExtra("Subtitle");
        int imageResource = getIntent().getIntExtra("Image", -1);

        if (titleText != null) {
            title.setText(titleText);
        } else {
            title.setText("Default Title");
        }

        if (subtitleText != null) {
            subtitle.setText(subtitleText);
        } else {
            subtitle.setText("Default Subtitle");
        }
        if (imageResource != -1) {
            imageView.setImageResource(imageResource);
        }

    }
}

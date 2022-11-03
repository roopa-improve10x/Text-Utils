package com.example.textutils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Image_Url_Activity extends AppCompatActivity {

    String url;
    Button previewBtn;
    ImageButton turnLeftIBtn;
    ImageButton turnRightIBtn;
    ImageView dynamicImg;
    EditText imageUrlTxt;
    Button flipHorizontalBtn;
    Button flipVerticalBtn;
    Button showBtn;
    Button hideBtn;
    int angle = 0;
    int scaleX = 1;
    int scaleY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_url);

        dynamicImg = findViewById(R.id.dynamic_img);
        imageUrlTxt = findViewById(R.id.image_url_txt);
        previewBtn = findViewById(R.id.preview_btn);
        turnLeftIBtn = findViewById(R.id.turn_left_ibtn);
        turnRightIBtn = findViewById(R.id.turn_right_ibtn);
        flipHorizontalBtn = findViewById(R.id.flip_horizantal_btn);
        flipVerticalBtn = findViewById(R.id.flip_vertical_btn);
        showBtn = findViewById(R.id.show_btn);
        hideBtn = findViewById(R.id.hide_btn);

        preview();
        leftRotation();
        rightRotation();
        flipHorizontal();
        flipVertical();
        showClick();
        hideClick();
    }

    private void hideClick() {
        hideBtn.setOnClickListener(view -> {
            getSupportActionBar().hide();
        });
    }

    private void showClick() {
        showBtn.setOnClickListener(view -> {
            getSupportActionBar().setTitle("Image Utils");
            getSupportActionBar().show();
        });
    }


    public void preview() {
        previewBtn.setOnClickListener(view -> {
            getSupportActionBar().setTitle("Image Utils");
            url = imageUrlTxt.getText().toString();
            angle = 0;
            scaleX = 1;
            scaleY = 1;
            dynamicImg.setScaleX(scaleX);
            dynamicImg.setScaleY(scaleY);
            Picasso.get().load(url).rotate(angle).into(dynamicImg);
        });
    }

    public void leftRotation() {
        turnLeftIBtn.setOnClickListener(view -> {
            angle = angle + ( scaleX * scaleY * -90);
            Picasso.get().load(url).rotate(angle).into(dynamicImg);
        });
    }

    public void rightRotation() {
        turnRightIBtn.setOnClickListener(view -> {
            angle = angle + (scaleX * scaleY * 90);
            Picasso.get().load(url).rotate(angle).into(dynamicImg);
        });
    }
    public void flipHorizontal() {
        flipHorizontalBtn.setOnClickListener(view -> {
            scaleX = scaleX * -1;
            dynamicImg.setScaleX(scaleX);
        });
    }

    public void flipVertical() {
        flipVerticalBtn.setOnClickListener(view -> {
            scaleY = scaleY * -1;
            dynamicImg.setScaleY(scaleY);
        });
    }
}

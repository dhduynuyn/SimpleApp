package com.mobilepj.simpleapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.time.Instant;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public void OpenCall(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0859155193"));
        startActivity(intent);
    }

    public void OpenMail(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:daki3108kg@gmail.com"));
        startActivity(intent);
    }

    public void OpenHCMUS(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://hcmus.edu.vn/"));
        startActivity(intent);
    }

    private final int GALLERY_REQ_CODE = 1000;
    ImageView imgGallery;
    ImageButton btnskill11;
    ImageButton btnskill22;
    ImageButton btnskill33;
    ImageButton btnskill44;
    ImageButton btnskill55;
    int currentButtonId = 0;
    int PICK_IMAGE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnskill11 = findViewById(R.id.btnskill1);
        btnskill22 = findViewById(R.id.btnskill2);
        btnskill33 = findViewById(R.id.btnskill3);
        btnskill44 = findViewById(R.id.btnskill4);
        btnskill55 = findViewById(R.id.btnskill5);

        imgGallery = findViewById(R.id.imageView);
        ImageButton btnGallery = findViewById(R.id.floatingActionButto);

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery, GALLERY_REQ_CODE);
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentButtonId = v.getId();
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE);
            }
        };

        btnskill11.setOnClickListener(listener);
        btnskill22.setOnClickListener(listener);
        btnskill33.setOnClickListener(listener);
        btnskill44.setOnClickListener(listener);
        btnskill55.setOnClickListener(listener);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            if (selectedImage != null) {
                try {
                    if (requestCode == GALLERY_REQ_CODE) {
                        imgGallery.setImageURI(selectedImage);
                    } else if (requestCode == PICK_IMAGE) {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                        if (currentButtonId == R.id.btnskill1) {
                            btnskill11.setImageBitmap(bitmap);
                        } else if (currentButtonId == R.id.btnskill2) {
                            btnskill11.setImageBitmap(bitmap);
                        } else if (currentButtonId == R.id.btnskill3) {
                            btnskill11.setImageBitmap(bitmap);
                        } else if (currentButtonId == R.id.btnskill4) {
                            btnskill11.setImageBitmap(bitmap);
                        }
                        if (currentButtonId == R.id.btnskill5) {
                            btnskill11.setImageBitmap(bitmap);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

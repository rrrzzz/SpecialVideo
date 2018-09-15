package com.example.nekko.specialvideo;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends FragmentActivity {

    private static final int MY_CAMERA_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    MY_CAMERA_REQUEST_CODE);
        }


        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.button);
        SpannableString text = new SpannableString(b.getText());


        int textLength = text.length();

        for (int i = 0; i < textLength; i++){
            int red = ThreadLocalRandom.current().nextInt(0, 255 + 1);
            int green = ThreadLocalRandom.current().nextInt(0, 255 + 1);
            int blue = ThreadLocalRandom.current().nextInt(0, 255 + 1);
            int myColor = Color.argb(255, red, green, blue);
            text.setSpan(new ForegroundColorSpan(myColor), i, i+1, 0);
        }

        int red = ThreadLocalRandom.current().nextInt(0, 255 + 1);
        int green = ThreadLocalRandom.current().nextInt(0, 255 + 1);
        int blue = ThreadLocalRandom.current().nextInt(0, 255 + 1);
        int myColor = Color.argb(255, red, green, blue);

        // shove our styled text into the Button
        b.setText(text, TextView.BufferType.SPANNABLE);
        b.setBackgroundColor(myColor);
    }

    @Override

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_CAMERA_REQUEST_CODE) {

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();

            } else {

                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();

            }

        }}//end onRequestPermissionsResult

    public void startEshkere(View view){
        Intent intent = new Intent(this, Eshkere.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}

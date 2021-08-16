package com.example.images;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private static ImageView i;
private static Button b;
private  int cur;
    TextView textView;
int []images={R.drawable.hello,R.drawable.flower,R.drawable.ic_launcher_background,R.drawable.image_search_1563196828171};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButtonClick();
    }
    public void ButtonClick(){
    i=(ImageView)findViewById(R.id.imageView2);
    b=(Button)findViewById(R.id.button);
    b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            cur++;
            cur=cur%images.length;
            i.setImageResource(images[cur]);
        }
    });
    }

    public void go(View view) {
        startActivity(new Intent(MainActivity.this,MainActivity2.class));
    }
}
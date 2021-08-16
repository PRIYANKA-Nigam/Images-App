package com.example.images;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import at.markushi.ui.CircleButton;

public class MainActivity2 extends AppCompatActivity {
    public CircleButton c1,c2,c3;
    EditText e1,e2;int gender=0;
    FloatingActionButton fl; RecyclerView recyclerView;
    CustomAdapter customAdapter;
    ArrayList<ClassItem> arrayList=new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fl=(FloatingActionButton)findViewById(R.id.fab);
        recyclerView=(RecyclerView)findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        customAdapter=new CustomAdapter(this,arrayList);
        recyclerView.setAdapter(customAdapter);

        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogs();
            }
        });
    }

    private void showDialogs() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        View view= LayoutInflater.from(this).inflate(R.layout.dialog,null);
        builder.setView(view);
        final AlertDialog dialog=builder.create();
        dialog.show();
        ImageButton im=(ImageButton) view.findViewById(R.id.imageButton);
        CircleButton   c1=(CircleButton)view.findViewById(R.id.imgf);
        CircleButton    c2=(CircleButton)view.findViewById(R.id.imgm);
        final CircleButton   c3=(CircleButton)view.findViewById(R.id.imgl);
        final EditText  e1=(EditText)view.findViewById(R.id.editTextTextPersonName);
        final EditText  e2=(EditText)view.findViewById(R.id.editTextTextPersonName2);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname=e1.getText().toString();String lname=e2.getText().toString();
                arrayList.add(new ClassItem(fname,lname));customAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });

    }
}
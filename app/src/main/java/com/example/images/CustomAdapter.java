package com.example.images;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<com.example.images.CustomAdapter.ClassViewHolder> {
    ArrayList<ClassItem> arrayList=new ArrayList<>();
    Context context;

    public CustomAdapter( Context context,ArrayList<ClassItem> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        holder.t1.setText(arrayList.get(position).getFname());
        holder.t2.setText(arrayList.get(position).getLname());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.textView);
            t2=(TextView)itemView.findViewById(R.id.textView9);



        }
    }
}

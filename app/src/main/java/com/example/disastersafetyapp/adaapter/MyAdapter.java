package com.example.disastersafetyapp.adaapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.disastersafetyapp.R;
import com.example.disastersafetyapp.models.User;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> list;
    private  RecyclerView recyclerView;

    public MyAdapter(Context context, ArrayList<User> list ,RecyclerView recyclerView) {
        this.context = context;
        this.list = list;
        this.recyclerView=recyclerView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.needs_show,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user=list.get(position);
        holder.name.setText(list.get(position).getName());
        holder.location.setText(list.get(position).getLocation());
        holder.shelter.setText(list.get(position).getShelter());
        holder.food.setText(list.get(position).getFood());
        holder.medical.setText(list.get(position).getMedical());
        holder.financial.setText(list.get(position).getFinance());
        holder.counselling.setText(list.get(position).getCounselling());
        holder.sanitation.setText(list.get(position).getSanitation());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,location,shelter,food,medical,financial,counselling,sanitation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            location=itemView.findViewById(R.id.Location);
            shelter=itemView.findViewById(R.id.shelter);
            food=itemView.findViewById(R.id.food);
            medical=itemView.findViewById(R.id.medical);
            financial=itemView.findViewById(R.id.financial);
            counselling=itemView.findViewById(R.id.counselling);
            sanitation=itemView.findViewById(R.id.sanitation);

        }
    }
    public void setData(List<User> newDataList) {
        list = (ArrayList<User>) newDataList;
        notifyDataSetChanged();
    }
}

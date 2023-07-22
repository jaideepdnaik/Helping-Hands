package com.example.disastersafetyapp.adaapter;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.disastersafetyapp.R;
import com.example.disastersafetyapp.models.Info;
import com.example.disastersafetyapp.models.User;

import java.util.ArrayList;
import java.util.List;

public class MyInfoAdapter extends RecyclerView.Adapter<MyInfoAdapter.ViewHolder> {
    private Context context;
    private List<Info> infoList;
    private RecyclerView recyclerView;
    private OnItemclickListen lisner;

    public void setData(List<Info> newVenueList) {
    }

    public interface OnItemclickListen{
        void onItemClick(int position);
    }
    public void setOnclickListener(OnItemclickListen clicklisner){
        lisner=clicklisner;
    }

    public MyInfoAdapter(Context context, ArrayList<Info> infoList, RecyclerView recyclerView) {
        this.context = context;
        this.infoList = infoList;
        this.recyclerView = recyclerView;

    }
    @NonNull
    @Override
    public MyInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.disinfo_show_file,parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = recyclerView.getChildAdapterPosition(view);
                // Handle item click event here
                String clickedItem = String.valueOf(infoList.get(position));
                Toast.makeText(view.getContext(), "Clicked item: " + clickedItem, Toast.LENGTH_SHORT).show();
            }
        });
        return  new ViewHolder(view,lisner);
    }

    @Override
    public void onBindViewHolder(@NonNull MyInfoAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(infoList.get(position).getImg_url()).into(holder.disimg);
        holder.disname.setText(infoList.get(position).getName());
        holder.disdisc.setText(infoList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
       return infoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView disimg;
        ImageView deletebtn;
        TextView disname;
        TextView disdisc;
        public ViewHolder(View view, OnItemclickListen lisner) {
            super(view);
                deletebtn=view.findViewById(R.id.btndelete);
                disdisc=view.findViewById(R.id.disdesc);
                disname=view.findViewById(R.id.disname);
                disimg=view.findViewById(R.id.disinfoimg);

            deletebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lisner.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}

package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPeople extends RecyclerView.Adapter<AdapterPeople.ViewHolder> {


    ArrayList<Employee> dsPeople=new ArrayList<>();
    Context context;

    public AdapterPeople(Context context) {
        super();
        this.context = context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewgroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_employee, viewgroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvId.setText(dsPeople.get(i).id);
        viewHolder.tvName.setText(dsPeople.get(i).name);
        viewHolder.tvPhone.setText(dsPeople.get(i).phone);
    }


    public void delete(int i){
        dsPeople.remove(i);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return dsPeople.size();
    }

    public void setEmployee(ArrayList<Employee> list) {
        dsPeople=list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener  {
        TextView tvId,tvName,tvPhone;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.id);
            tvName = itemView.findViewById(R.id.name);
            tvPhone = itemView.findViewById(R.id.phone);
            linearLayout=itemView.findViewById(R.id.layout_item);
            linearLayout.setOnCreateContextMenuListener(this);
        }


        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(),100,0,"EDIT");
            menu.add(this.getAdapterPosition(),101,1,"DELETE");

        }
    }
}
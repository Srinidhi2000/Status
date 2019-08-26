package com.example.android.status;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class deptlist_adapter extends RecyclerView.Adapter<deptlist_adapter.ViewHolder> {
   private ArrayList<String> name=new ArrayList<>();
   private Context context;

    public deptlist_adapter(ArrayList<String> name, Context context) {
        this.name = name;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
      View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dept_listitem,viewGroup,false);
      return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
viewHolder.text.setText(name.get(i));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.dept_name);
        }
    }
}

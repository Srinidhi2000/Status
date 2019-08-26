package com.example.android.status;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class eventAdapter extends RecyclerView.Adapter<eventAdapter.eventViewHolder> {
List<obj> eventList;
Context context;
private OnItemClickListener listener;
    @NonNull
    @Override
    public eventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview,viewGroup,false);
        eventViewHolder eventView=new eventViewHolder(v,listener);
        return eventView;
    }
public eventAdapter(Context context,List<obj> eventList)
{
    this.eventList=eventList;
    this.context=context;
}
    @Override
    public void onBindViewHolder(@NonNull eventViewHolder eventViewHolder, int i) {
obj current=eventList.get(i);
eventViewHolder.id.setText(current.getId());
eventViewHolder.name.setText(current.getName());
        eventViewHolder.getView().setAnimation(AnimationUtils.loadAnimation(context,R.anim.zoom_in));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
public interface OnItemClickListener{
        void onItemClick(int position);
}
public void setOnItemClickListener(OnItemClickListener listener)
{
    this.listener=listener;
}
    public static class eventViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView name;
        View view;
        public eventViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            view=itemView;
id=itemView.findViewById(R.id.text1);
name=itemView.findViewById(R.id.text2);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(listener!=null)
{
    int position=getAdapterPosition();
    if(position!=RecyclerView.NO_POSITION)
    {listener.onItemClick(position);}
}
}
        });
        }
    public View getView()
    {
        return view;
    }
    }
}

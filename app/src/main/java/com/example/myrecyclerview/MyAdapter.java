package com.example.myrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
     private static ClickListener clickListener;
     Context context;
     String[] studentNames,studentId,section;
    int[] names;

    public MyAdapter(Context context, String[] studentNames, String[] studentId, String[] section, int[] names) {
        this.context = context;
        this.studentNames = studentNames;
        this.studentId = studentId;
        this.section = section;
        this.names = names;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_view,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.studentNamesview.setText(studentNames[position]);
        myViewHolder.studentIdview.setText(studentId[position]);
        myViewHolder.sectionview.setText(section[position]);
        myViewHolder.namesview.setImageResource(names[position]);

    }

    @Override
    public int getItemCount() {
        return studentNames.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        TextView studentNamesview,studentIdview,sectionview;
        ImageView namesview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            studentNamesview = itemView.findViewById(R.id.studentNameid);
            studentIdview = itemView.findViewById(R.id.studentviewid);
            sectionview = itemView.findViewById(R.id.sectionId);
            namesview = itemView.findViewById(R.id.imageviewid);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(),v);

        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(),v);
            return false;
        }
    }
    public interface ClickListener{
        void onItemClick(int position,View v);
        void onItemLongClick(int position,View v);
    }
    public void setOnItemClickListener(ClickListener clickListener){
        MyAdapter.clickListener = clickListener;
    }
}

package com.example.myrecyclerview;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] studentNames,studentId,section;
    int[] names = {R.drawable.abdullah_al_fahim_173_15_10430_,
            R.drawable.ajoy_sutradhar_173_15_10434_,R.drawable.md__aftabur_rahman_tonmoy_173_15_10423_,
            R.drawable.md__fahim_ahmed_173_15_10431_,R.drawable.md__sazzad_hossain__173_15_1044_,R.drawable.md_nasim_173_15_10463_,
            R.drawable.md_tauhid_islam_173_15_10421_,R.drawable.rahima_akter_munni__173_15_10457_,R.drawable.s_m_sohan_173_15_10446_,R.drawable.sabbir_ahamed_173_15_10451,
            R.drawable.sadia_afrin_rajani_173_15_10442_,R.drawable.sazzad_ahamed_173_15_10455_};
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerviewid);
        studentNames = getResources().getStringArray(R.array.studentNames);
        studentId = getResources().getStringArray(R.array.studentId);
        section = getResources().getStringArray(R.array.studentSection);
        myAdapter = new MyAdapter(this,studentNames,studentId,section,names);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                String value= studentNames[position];
                String value1 = studentId[position];
                String value2 = section[position];
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("key",value+" "+value1+" "+value2);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(int position, View v) {
                String value= studentNames[position];
                String value1 = studentId[position];
                String value2 = section[position];
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("key",value+" "+value1+" "+value2);
                startActivity(intent);

            }
        });

    }
}
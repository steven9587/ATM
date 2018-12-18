package com.steven.atm;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AgeActivity extends BasaActivity {

    private EditText edAge;
    private int age;
    int[] ageChoose = {19,20,21,22,23,24,25};
    String[] rainbow= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        RecyclerView ageRecycler =findViewById(R.id.recycler);
        ageRecycler.setHasFixedSize(true);
        ageRecycler.setLayoutManager(new LinearLayoutManager(this));
        ageRecycler.setAdapter(new ageAdapter());
        edAge = findViewById(R.id.ed_age);
        rainbow = getResources().getStringArray(R.array.raincow);
    }

    public void next(View view){
        age = Integer.parseInt(edAge.getText().toString());
//        getSharedPreferences("user",MODE_PRIVATE)
//                .edit()
//                .putInt("USERAGE", age)
//                .apply();
        user.setAge(age);
        Intent gender = new Intent(this,GenderActivity.class);
        startActivity(gender);
    }

    public void back(View view){
        finish();
    }

    class ageAdapter extends RecyclerView.Adapter<ageAdapter.ageViewHolder>{
        @NonNull
        @Override
        //把設計圖變成可用的view(XML→View)
        public ageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.age_row,parent,false);
            return new ageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ageViewHolder holder, final int position) {
            holder.ageText.setText(ageChoose[position]+"");
            holder.itemView.setBackgroundColor(Color.parseColor(rainbow[position%7]));
            //19便紅字
            // if(ageChoose[position] == 19){
            // holder.ageText.setTextColor(Color.RED);
            // }
            //若用ageText 則一定要點在自上才有反應
            //holder.ageText.setOnClickListener(new View.OnClickListener() {
             holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("AgeActivity","onClick" + ageChoose[position]);
                    edAge.setText(ageChoose[position]+"");
                }
            });
        }

        @Override
        //有幾個?
        public int getItemCount() {
            return ageChoose.length;
        }

        class ageViewHolder extends RecyclerView.ViewHolder{
            //讀取XML
            TextView ageText;
            public ageViewHolder(View itemView) {
                super(itemView);
                ageText = itemView.findViewById(R.id.ageText);
            }
        }
    }
}

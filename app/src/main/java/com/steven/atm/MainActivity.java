package com.steven.atm;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BasaActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;
    List<String> fruits = Arrays.asList("香蕉", "鳳梨", "芭樂");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!login) {
            Intent intent = new Intent(this, Login.class);
            //startActivity(intent);
            startActivityForResult(intent, RC_LOGIN);
        }
        //listView建立清單
        //listView();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        //確定size是否固定(也就是有無加入或刪除東西)，避免每次都重畫表格
        recyclerView.setHasFixedSize(true);
        //new出linear(一列一列的)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FruitAdapter());
    }

    class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {
        @NonNull
        @Override
        public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            View view = LayoutInflater.from(context)
                    .inflate(android.R.layout.simple_list_item_1,parent,false);
            FruitViewHolder fruitViewHolder = new FruitViewHolder(view);
            return fruitViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
            holder.fruitname.setText(fruits.get(position));
        }

        @Override
        public int getItemCount() {
            return fruits.size();
        }

        class FruitViewHolder extends RecyclerView.ViewHolder{
            TextView fruitname;
            public FruitViewHolder(View itemView) {
                super(itemView);
                fruitname = itemView.findViewById(android.R.id.text1);
            }
        }
    }

    private void listView() {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruits);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_LOGIN) {
            if (resultCode != RESULT_OK) {
                finish();
            } else {
                //TODO: if nickname / age /gender exist
//                String saveNickname = getSharedPreferences("user",MODE_PRIVATE)
//                        .getString("USERNICKNAME", null);
//                int saveAge = getSharedPreferences("user",MODE_PRIVATE)
//                        .getInt("USERAGE", 0);
//                int saveGender = getSharedPreferences("user",MODE_PRIVATE)
//                        .getInt("USERGENDER", 0);
                if (!user.isValid()) {
                    Intent nickname = new Intent(this, NicknameActivity.class);
                    startActivity(nickname);
                }
            }
        }
    }
}

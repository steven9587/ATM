package com.steven.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends BasaActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!login){
            Intent intent = new Intent(this,Login.class);
            //startActivity(intent);
            startActivityForResult(intent,RC_LOGIN);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if(resultCode != RESULT_OK ){
                finish();
            }else{
                //TODO: if nickname / age /gender exist
//                String saveNickname = getSharedPreferences("user",MODE_PRIVATE)
//                        .getString("USERNICKNAME", null);
//                int saveAge = getSharedPreferences("user",MODE_PRIVATE)
//                        .getInt("USERAGE", 0);
//                int saveGender = getSharedPreferences("user",MODE_PRIVATE)
//                        .getInt("USERGENDER", 0);
                if (!user.isValid()) {
                    Intent nickname = new Intent(this,NicknameActivity.class);
                    startActivity(nickname);
                }
            }
        }
    }
}

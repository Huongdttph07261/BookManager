package com.edu.fpoly.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.fpoly.bookmanager.dao.NguoiDungDAO;
import com.edu.fpoly.bookmanager.model.NguoiDung;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void checkLogin(View view) {
//        EditText edUser = findViewById(R.id.edUser);
//        EditText edPass = findViewById(R.id.edPass);
//        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(this);
//
//        String username = edUser.getText().toString();
//        String password = edPass.getText().toString();
//
//        NguoiDung nguoiDung = new NguoiDung(username, password);
//
//        boolean result = nguoiDungDAO.isLogin(nguoiDung);
//        if(result){
        //Toast.makeText(getApplicationContext(), "Login thành công", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);

//        }
//        else {
//            Toast.makeText(getApplicationContext(), "Login lỗi", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//            startActivity(intent);
//
//
//        }


    }


    public void clear(View view) {
    }
}

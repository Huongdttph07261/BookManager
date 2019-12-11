package com.edu.fpoly.bookmanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.edu.fpoly.bookmanager.model.TheLoai;

public class MainActivity extends AppCompatActivity {
    String strUserName, strPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("QUẢN LÝ SÁCH");
        setContentView(R.layout.activity_main);

    }

    public void viewNguoiDung(View view)
    {
        Intent intent = new Intent(MainActivity.this,ListNguoiDungActivity.class);
        startActivity(intent);
    }

    public void viewTheLoai(View view) {

        Intent intent = new Intent(MainActivity.this,TheLoaiActivity.class);
        startActivity(intent);

    }


    public void ViewThongKeActivity(View view) {
    }

    public void ViewTopSach(View view) {
    }

    public void ViewListHoaDonActivity(View view) {
    }

    public void viewSach(View view) {
    }
}

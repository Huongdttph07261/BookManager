package com.edu.fpoly.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.fpoly.bookmanager.dao.TheLoaiDAO;
import com.edu.fpoly.bookmanager.dao.TheLoaiDAO;
import com.edu.fpoly.bookmanager.model.TheLoai;

public class TheLoaiActivity extends AppCompatActivity {
     Button btnThemTheLoai;
    TheLoaiDAO theLoaiDAO;
    EditText edMaTheLoai,edTenTheLoai,edViTri,edMoTa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);

        setTitle("Them The Loai");
        btnThemTheLoai = (Button)findViewById(R.id.btnAddUser);
        edMaTheLoai = (EditText)findViewById(R.id.edMaTheLoai);
        edTenTheLoai = (EditText)findViewById(R.id.edTenTheLoai);
        edMoTa = (EditText)findViewById(R.id.edMoTa);
        edViTri = (EditText)findViewById(R.id.edViTri);
    }

    public void addTheLoai(View view) {
        theLoaiDAO = new TheLoaiDAO(TheLoaiActivity.this);
        String maTheLoai = edMaTheLoai.getText().toString();
        String tenTheLoai = edTenTheLoai.getText().toString();
        String viTri = edViTri.getText().toString();
        String moTa = edMoTa.getText().toString();
       TheLoai theLoai = new TheLoai(maTheLoai, tenTheLoai, viTri, moTa);
        if(theLoaiDAO.insertTheLoai(theLoai)==1)
        {
            Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Thêm thất bại",Toast.LENGTH_LONG).show();
        }

    }

    public void showTheLoai(View view) {
        Intent intent = new Intent(TheLoaiActivity.this, ListTheLoaiActivity.class);
        startActivity(intent);
    }
}

package com.edu.fpoly.bookmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.fpoly.bookmanager.dao.NguoiDungDAO;
import com.edu.fpoly.bookmanager.model.NguoiDung;

public class NguoiDungActivity extends AppCompatActivity {
    Button btnThemNguoiDung;
    NguoiDungDAO nguoiDungDAO;
    EditText edUser,edPass,edRepass,edPhone,edFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);
        setTitle("Them Nguoi Dung");
        btnThemNguoiDung = (Button)findViewById(R.id.btnAddUser);
        edUser = (EditText)findViewById(R.id.edUserName);
        edPass = (EditText)findViewById(R.id.edPassword);
        edPhone = (EditText)findViewById(R.id.edPhone);
        //edRepass = (EditText)findViewById(R.id.edRePassword);
        edFullName = (EditText)findViewById(R.id.edFullName);
    }

    public void addUser(View view)
    {
        nguoiDungDAO = new NguoiDungDAO(NguoiDungActivity.this);
        NguoiDung nguoiDung = new NguoiDung(edUser.getText().toString(),edPass.getText().toString(),
                edPhone.getText().toString(),edFullName.getText().toString());
        if(nguoiDungDAO.insertNguoiDung(nguoiDung)==1)
        {
            Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Thêm thất bại",Toast.LENGTH_LONG).show();
        }
    }

    public void showUsers(View view) {
        finish();
    }


}

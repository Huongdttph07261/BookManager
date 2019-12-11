package com.edu.fpoly.bookmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.fpoly.bookmanager.dao.NguoiDungDAO;
import  static com.edu.fpoly.bookmanager.ListNguoiDungActivity.layus;
public class UpDateNguoiDung extends AppCompatActivity {
    EditText edTen;
    EditText edSdt;
    Button btnOk;
    NguoiDungDAO nguoiDungDAO ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_date_nguoi_dung);
        edTen = findViewById(R.id.edTen);
        edSdt = findViewById(R.id.edSdt);
        btnOk = findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nguoiDungDAO = new NguoiDungDAO(UpDateNguoiDung.this);
              if (nguoiDungDAO.updateNguoiDung(layus,edTen.getText().toString(),edSdt.getText().toString())==1){
                  Toast.makeText(getApplicationContext(),"sua thanh cong",Toast.LENGTH_LONG).show();
                  finish();
              }
              else {
                  Toast.makeText(getApplicationContext(),"sua that bai",Toast.LENGTH_LONG).show();
              }
            }
        });
    }
}

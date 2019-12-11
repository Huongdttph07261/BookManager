package com.edu.fpoly.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.edu.fpoly.bookmanager.adapter.NguoiDungAdapter;
import com.edu.fpoly.bookmanager.dao.NguoiDungDAO;
import com.edu.fpoly.bookmanager.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class ListNguoiDungActivity extends AppCompatActivity {
    //Intent intent;

    public static List<NguoiDung> dsNguoiDung = new ArrayList<>();
    ListView lvNguoiDung;
    NguoiDungDAO nguoiDungDAO;
    NguoiDungAdapter adapter = null;
    public static  String layus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nguoi_dung);
        lvNguoiDung = findViewById(R.id.lvNguoiDung);
        nguoiDungDAO = new NguoiDungDAO(ListNguoiDungActivity.this);

        dsNguoiDung = nguoiDungDAO.getAllNguoiDung();
        adapter = new NguoiDungAdapter(this,dsNguoiDung);
        lvNguoiDung.setAdapter(adapter);
        lvNguoiDung.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                layus = dsNguoiDung.get(i).getUserName();
                Intent intent = new Intent(ListNguoiDungActivity.this, UpDateNguoiDung.class);
                startActivity(intent);
                return false;
            }
        });

    }

    public void startThemNguoiDung(View view)
    {
        Intent intent = new Intent(ListNguoiDungActivity.this,NguoiDungActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.add:
               // intent = new Intent(ListNguoiDungActivity.this,NguoiDungActivity.class);
               // startActivity(intent);
                return(true);
            case R.id.changePass:
                break;
            case R.id.logOut:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

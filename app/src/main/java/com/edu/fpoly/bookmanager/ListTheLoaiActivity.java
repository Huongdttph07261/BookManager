package com.edu.fpoly.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.edu.fpoly.bookmanager.adapter.NguoiDungAdapter;
import com.edu.fpoly.bookmanager.adapter.TheLoaiAdapter;
import com.edu.fpoly.bookmanager.dao.NguoiDungDAO;
import com.edu.fpoly.bookmanager.dao.TheLoaiDAO;
import com.edu.fpoly.bookmanager.model.NguoiDung;
import com.edu.fpoly.bookmanager.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class ListTheLoaiActivity extends AppCompatActivity {
    public static List<TheLoai> dsTheLoai = new ArrayList<>();
    ListView lvTheLoai;
    TheLoaiDAO theLoaiDAO;
   TheLoaiAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_the_loai);

        lvTheLoai = findViewById(R.id.lvTheLoai);
        theLoaiDAO = new TheLoaiDAO(ListTheLoaiActivity.this);

        dsTheLoai = theLoaiDAO.getAllTheLoai();
        adapter = new TheLoaiAdapter(this,dsTheLoai);
        lvTheLoai.setAdapter(adapter);
        lvTheLoai.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                layus = dsTheLoai.get(i).getMaTheLoai();
                return false;
            }
        });

    }

    public void ThemTheLoai(View view) {
        Intent intent = new Intent(ListTheLoaiActivity.this, TheLoaiActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add:

                return(true);
            case R.id.changePass:
                break;
            case R.id.logOut:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

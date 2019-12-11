package com.edu.fpoly.bookmanager.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.edu.fpoly.bookmanager.database.DatabaseHelper;
import com.edu.fpoly.bookmanager.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    public DatabaseHelper dbHelper;
    public SQLiteDatabase db;
    public static final String SQL_NGUOI_DUNG = "CREATE TABLE NguoiDung (" +
            " userName text primary key, " +
            " password text, " +
            " phone text, " +
            " hoTen text" +
            ");";
    public static final String TABLE_NAME = "NguoiDung";

    public NguoiDungDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertNguoiDung(NguoiDung nguoiDung) {
        ContentValues values = new ContentValues();
        values.put("userName", nguoiDung.getUserName());
        values.put("password", nguoiDung.getPassword());
        values.put("phone", nguoiDung.getPhone());
        values.put("hoTen", nguoiDung.getHoTen());
        try {
            if (db.insert(TABLE_NAME, null, values) < 0) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e("NguoiDungDAO", ex.getMessage());
        }


        return 1;
    }

    //getAll
    public List<NguoiDung> getAllNguoiDung() {
        List<NguoiDung> dsNguoiDung = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null,
                null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            NguoiDung ee = new NguoiDung();
            ee.setUserName(c.getString(0));
            ee.setPassword(c.getString(1));
            ee.setPhone(c.getString(2));
            ee.setHoTen(c.getString(3));
            dsNguoiDung.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return dsNguoiDung;

    }

    public NguoiDung findByUsername(String username) {
        NguoiDung objNguoiDung = null;
        //code ma lenh de lay thong tin nguoi cung trong CSDL khi biet ten nguoi dung
        //select * from NguoiDung where username = ?

        return objNguoiDung;
    }

    public boolean isLogin(NguoiDung nguoiDung) {

        String sqlSelect = "select username, password from nguoidung " +
                "where username=? and password=?";

        String username = nguoiDung.getUserName();
        String password = nguoiDung.getPassword();

        //Thực hiện lệnh truy vấn
        Cursor c = db.rawQuery(sqlSelect, new String[]{username, password});

        //nếu con trỏ, trỏ tới bản ghi đầu tiên, tức là có dữ liệu username và password trong CSDL
        if (c.moveToFirst()) {
            return true;
        }

        return false;
    }

    public int deleteNguoiDung(String username) {
        int r = db.delete(TABLE_NAME, "userName=?", new String[]{username});
        if (r == 0)
            return -1;
        return 1;

    }

    public int updateNguoiDung(String userName, String name, String phone) {
        ContentValues values = new ContentValues();
        values.put("phone", phone);
        values.put("hoTen", name);
        if (db.update(TABLE_NAME, values, "userName=?", new String[]{userName}) == -1) {

        }
        return 1;
    }

}

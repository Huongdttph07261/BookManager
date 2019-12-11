package com.edu.fpoly.bookmanager.dao;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.edu.fpoly.bookmanager.database.DatabaseHelper;
import com.edu.fpoly.bookmanager.model.NguoiDung;
import com.edu.fpoly.bookmanager.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAO {
    public DatabaseHelper dbHelper;
    public SQLiteDatabase db;

    public static final String SQL_THE_LOAI = "CREATE TABLE TheLoai (" +
            " MaTheLoai text primary key, " +
            " TenTheLoai text, " +
            " MoTa text," +
            " ViTri text" +
            ");";
    public static final String TABLE_NAME = "TheLoai";

    public TheLoaiDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertTheLoai(TheLoai theLoai) {
        ContentValues values = new ContentValues();
        values.put("MaTheLoai", theLoai.getMaTheLoai());
        values.put("TenTheLoai", theLoai.getTenTheLoai());
        values.put("MoTa", theLoai.getMoTa());
        values.put("ViTri", theLoai.getViTri());
        try {
            if (db.insert(TABLE_NAME, null, values) < 0) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e("TheLoaiDAO", ex.getMessage());
            ex.printStackTrace();
        }
        return 1;
    }


    public List<TheLoai> getAllTheLoai() {
        List<TheLoai> dsTheLoai = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null,
                null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            TheLoai ee = new TheLoai();
            ee.setMaTheLoai(c.getString(0));
            ee.setTenTheLoai(c.getString(1));
            ee.setViTri(c.getString(2));
            ee.setMoTa(c.getString(3));
            dsTheLoai.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
       return dsTheLoai;

    }

}

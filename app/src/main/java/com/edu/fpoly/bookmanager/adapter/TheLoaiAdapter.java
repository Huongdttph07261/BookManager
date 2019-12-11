package com.edu.fpoly.bookmanager.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.fpoly.bookmanager.R;
import com.edu.fpoly.bookmanager.dao.TheLoaiDAO;
import com.edu.fpoly.bookmanager.model.NguoiDung;
import com.edu.fpoly.bookmanager.model.TheLoai;

import java.util.List;

public class TheLoaiAdapter extends BaseAdapter {
    List<TheLoai> arrTheLoai;
    public Activity context;
    public LayoutInflater inflater;
    TheLoaiDAO theLoaiDAO;


    public TheLoaiAdapter(Activity context, List<TheLoai> arrTheLoai) {
        super();
        this.context = context;
        this.arrTheLoai = arrTheLoai;
        this.inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        theLoaiDAO = new TheLoaiDAO(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_the_loai, null);
            holder.img = (ImageView) convertView.findViewById(R.id.ivIcon);
            holder.txtName = (TextView) convertView.findViewById(R.id.tvName);
            holder.txtMa = (TextView) convertView.findViewById((R.id.tvMa));

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        TheLoai ng = (TheLoai) arrTheLoai.get(position);
        if (position % 3 ==0) {
            holder.img.setImageResource(R.drawable.sach1);
        }else if (position % 3 == 1){
            holder.img.setImageResource(R.drawable.sach1);
        }else {
            holder.img.setImageResource(R.drawable.sach1);
        }
        holder.txtName.setText(ng.getTenTheLoai());
        holder.txtMa.setText(ng.getMaTheLoai());
        return convertView;
    }
    public static class ViewHolder {
        ImageView img;
        TextView txtName;
        TextView txtMa;
    }
}

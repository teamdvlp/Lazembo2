package com.example.dangminhtien.lazembo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dangminhtien.lazembo.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by tiend on 6/5/2017.
 */

public class adapter_sp_account extends RecyclerView.Adapter<adapter_sp_account.view_holder> {
    private ArrayList<String> urls;
    private ArrayList<String> giasp;
    private ArrayList<String> tensp;
    private Context context;
    public adapter_sp_account(Context context,ArrayList<String> url, ArrayList<String> giasp, ArrayList<String> tensp) {
        this.urls = url;
        this.giasp = giasp;
        this.tensp = tensp;
        this.context = context;
    }

    @Override
    public view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.childview_item_recycle_account, parent);
        return new view_holder(view);
    }

    @Override
    public void onBindViewHolder(view_holder holder, int position) {
            holder.txt_ten_sp_account.setText(tensp.get(position));
            holder.txt_gia_sp_account.setText(giasp.get(position));
        try {
            Bitmap bitmap = xuly_hinhanh(position);
            holder.img_hinhsp_account.setImageBitmap(bitmap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Bitmap xuly_hinhanh(int position) throws IOException {
        URL url = new URL(urls.get(position));
        InputStream read_image_from_firebase = url.openStream();
        Bitmap bitmap = BitmapFactory.decodeStream(read_image_from_firebase);
        return bitmap;
    }

    @Override
    public int getItemCount() {
        return tensp.size() ;
    }

    class view_holder extends RecyclerView.ViewHolder {
        ImageView img_hinhsp_account;
        Button btn_popup_menu_account;
        TextView txt_gia_sp_account, txt_ten_sp_account;
        public view_holder(View itemView) {
            super(itemView);
            img_hinhsp_account = (ImageView) itemView.findViewById(R.id.img_hinh_sp_account);
            btn_popup_menu_account = (Button) itemView.findViewById(R.id.btn_pop_up_menu_account);
            txt_gia_sp_account = (TextView) itemView.findViewById(R.id.txt_gia_sp_account);
            txt_ten_sp_account = (TextView) itemView.findViewById(R.id.txt_ten_sp_account);
        }
    }
}
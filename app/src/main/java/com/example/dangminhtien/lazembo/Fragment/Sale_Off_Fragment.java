package com.example.dangminhtien.lazembo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dangminhtien.lazembo.R;


/**
 * Created by phamf on 23-May-17.
 */

public class Sale_Off_Fragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sale_off,container,false);
        return view;
    }
}

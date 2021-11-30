package com.example.remoteemployeeclock.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.remoteemployeeclock.R;


public class ProfileFragment extends Fragment {
    public static final String TAG = "ProfileFragment";
    private ImageView iv_profileimage;
    private TextView tv_profilename;
    private TextView tv_profileposition;
    private TextView tv_profilepay;


    public ProfileFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        iv_profileimage = view.findViewById(R.id.iv_profileimage);
        tv_profilename = view.findViewById(R.id.tv_profilename);
        tv_profileposition = view.findViewById(R.id.tv_profileposition);
        tv_profilepay = view.findViewById(R.id.tv_profilepay);
    }

}
package com.example.remoteemployeeclock.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.remoteemployeeclock.R;


public class TimePickerFragment extends Fragment implements View.OnClickListener {

    private Button btnIn;
    private Button btnOut;
    private Button btnStart;
    private Button btnEnd;

    public TimePickerFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TimePicker picker = (TimePicker) getView().findViewById(R.id.datePicker1);
        picker.setIs24HourView(true);

        btnIn = view.findViewById(R.id.btnIn);
        btnOut = view.findViewById(R.id.btnOut);
        btnEnd = view.findViewById(R.id.btnEnd);
        btnStart = view.findViewById(R.id.btnStart);

        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clockIn();
            }
        });
        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clockOut();
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clockEnd();
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clockStart();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_picker, container, false);

    }

    public void clockIn(){
        Toast.makeText(getContext(), "Time Successfully Submitted!", Toast.LENGTH_SHORT).show();
    }

    public void clockOut(){
        Toast.makeText(getContext(), "Time Successfully Submitted!", Toast.LENGTH_SHORT).show();
    }
    public void clockStart(){
        Toast.makeText(getContext(), "Time Successfully Submitted!", Toast.LENGTH_SHORT).show();
    }
    public void clockEnd(){
        Toast.makeText(getContext(), "Time Successfully Submitted!", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(), "Time Successfully Submitted!", Toast.LENGTH_SHORT).show();
    }
}
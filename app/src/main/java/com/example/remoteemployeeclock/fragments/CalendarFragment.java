package com.example.remoteemployeeclock.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remoteemployeeclock.CalendarAdapter;
import com.example.remoteemployeeclock.R;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CalendarFragment extends Fragment implements CalendarAdapter.OnItemListener{

    private RecyclerView rvCalendar;
    private TextView tvMonthYear;
    private LocalDate selectedDate;
    private Button btnNextMonth;
    private Button btnPrevMonth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }
    public CalendarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCalendar = view.findViewById(R.id.rvCalendar);
        tvMonthYear = view.findViewById(R.id.tvMonthYear);
        btnNextMonth = view.findViewById(R.id.btnNextMonth);
        btnPrevMonth = view.findViewById(R.id.btnPrevMonth);
        selectedDate = LocalDate.now();
        setMonthView();

        btnPrevMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousMonthAction(view);
            }
        });
        btnNextMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextMonthAction(view);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setMonthView(){
        tvMonthYear.setText(monthYearFromDate(selectedDate));
        ArrayList<String> daysInMonth = daysInMonthArray(selectedDate);

        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 7 );
        rvCalendar.setLayoutManager(layoutManager);
        rvCalendar.setAdapter(calendarAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private ArrayList<String> daysInMonthArray(LocalDate date) {
        ArrayList<String> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);
        int daysInMonth = yearMonth.lengthOfMonth();
        LocalDate firstofMonth = selectedDate.withDayOfMonth(1);
        int dayOfWeek  = firstofMonth.getDayOfWeek().getValue();

        for(int i = 1; i <= 42; i++){
            if(i <= dayOfWeek || i > daysInMonth + dayOfWeek){
                daysInMonthArray.add("");
            }
            else{
                daysInMonthArray.add(String.valueOf(i - dayOfWeek));
            }
        }
        return daysInMonthArray;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String monthYearFromDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void previousMonthAction(View view){
        selectedDate = selectedDate.minusMonths(1);
        setMonthView();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void nextMonthAction(View view){
        selectedDate = selectedDate.plusMonths(1);
        setMonthView();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onItemClick(int position, String dayText) {
        if(dayText.equals("")){
            String message = "Selected Date" + dayText + " " + monthYearFromDate(selectedDate);
            //Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

    }
}
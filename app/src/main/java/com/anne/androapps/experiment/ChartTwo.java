package com.anne.androapps.experiment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ChartTwo extends Fragment {


    public ChartTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pie_chart, container, false);
        final PieChart pieChart = (PieChart) view.findViewById(R.id.pie_chart);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(600f, 0));
        entries.add(new Entry(400f, 1));
        entries.add(new Entry(500f, 2));
        entries.add(new Entry(200f, 3));
        entries.add(new Entry(300f, 4));

        PieDataSet pieDataSet = new PieDataSet(entries,"Survey Data");

        ArrayList<String> platform = new ArrayList<String>();
        platform.add("Android");
        platform.add("Windows");
        platform.add("IOS");
        platform.add("FireOS");
        platform.add("BB");

        PieData pieData = new PieData(platform,pieDataSet);
        pieChart.setData(pieData);

        pieChart.setDescription("\n Survey result of mobile platform populations.");

        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        pieChart.animateY(5000);

        Button save = (Button)view.findViewById(R.id.save_piechart);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Save the chart into jpg to external sdcard
                pieChart.saveToGallery("mychart.jpg", 90); // 90 is the quality of the image
            }
        });

        pieChart.invalidate();

        return view;
    }

}

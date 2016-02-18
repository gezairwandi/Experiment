package com.anne.androapps.experiment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ChartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chart, container, false);

        // create a LineDataSet instance
        final LineChart lineChart = (LineChart) view.findViewById(R.id.chart);
        // Entry value data into arraylist
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4.5f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(2f, 3));
        entries.add(new Entry(18f, 4));
        entries.add(new Entry(9f, 5));
        //initialize the LineDataSet and pass the argument as an ArrayList of Entry object
        LineDataSet dataset = new LineDataSet(entries, "# of Calls");

        //Defining X-axis labels
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        /*labels.add("July");
        labels.add("August");
        labels.add("September");
        labels.add("October");
        labels.add("November");
        labels.add("December");*/

        LineData data = new LineData(labels, dataset);//initialize the LineData class
        lineChart.setData(data); // set the data and list of lables into chart

        lineChart.setDescription("Description: ");  // set the description

        dataset.setDrawCubic(true);//Convert Line into cubic form

        //dataset.setDrawFilled(true);//Fill the color below the line

        dataset.setColors(ColorTemplate.COLORFUL_COLORS);//Set the color

        lineChart.animateY(5000);

        //lineChart.animateX(5000);

        Button save = (Button)view.findViewById(R.id.save_chart);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Save the chart into jpg to external sdcard
                lineChart.saveToGallery("mychart.jpg", 90); // 90 is the quality of the image
            }
        });

        lineChart.invalidate();

        return view;
    }

}
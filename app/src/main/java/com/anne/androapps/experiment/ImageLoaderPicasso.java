package com.anne.androapps.experiment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.File;

public class ImageLoaderPicasso extends Fragment {

    public ImageLoaderPicasso() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view  = inflater.inflate(R.layout.fragment_image_loader_picasso, container, false);

        //Initialize ImageView
        final ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView2);

        final ProgressBar progressBar = new ProgressBar(getActivity());
        progressBar.setVisibility(View.VISIBLE);

        //Loading image from below url into imageView

        Picasso.with(getActivity()).setIndicatorsEnabled(true);

        Picasso.with(getActivity())
                .load("https://s-media-cache-ak0.pinimg.com/736x/b3/72/f5/b372f5723d9431bb36f2f924475bb764.jpg")
                //.placeholder(R.drawable.ic_fab_star)
                .resize(300, 300)
                .tag("Test tag Image Picasso.")
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        if (progressBar != null) {
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onError() {

                    }
                });

        //String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        Picasso.with(getActivity())
                .load(new File("/mnt/sdcard/DCIM/BarChart.jpg"))
                //.load(new File(path + File.separator + "BarChart.jpg"))
                .resize(300, 300)
                .tag("Test Image picasso.")
                .into(imageView2);

        return view;
    }
}

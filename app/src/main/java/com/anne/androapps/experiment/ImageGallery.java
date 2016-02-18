package com.anne.androapps.experiment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class ImageGallery extends Fragment {


    public ImageGallery() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_gallery, container, false);

        GridView gridView = (GridView)view.findViewById(R.id.grid);
        gridView.setAdapter(new ImageAdapter(getActivity()));

        return view;
    }

    private static class ImageAdapter extends BaseAdapter {

        private static final String[] IMAGE_URLS = UrlPath.IMAGES;

        private LayoutInflater inflater;

        Context c;

        ImageAdapter(Context context) {
            inflater = LayoutInflater.from(context);
            c = context;

        }

        @Override
        public int getCount() {
            return IMAGE_URLS.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            View view = convertView;
            if (view == null) {
                view = inflater.inflate(R.layout.grid_item_layout, parent, false);
                holder = new ViewHolder();
                assert view != null;

                holder.imageView = (ImageView) view.findViewById(R.id.image);

                holder.progressBar = (ProgressBar) view.findViewById(R.id.progress);

                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            Picasso.with(c)
                    .load(IMAGE_URLS[position])
                    .placeholder(R.drawable.ic_fab_star)
                    .error(R.drawable.fab_bg_mini)
                    .fit()
                    .into(holder.imageView, new Callback() {

                        @Override
                        public void onSuccess() {
                            holder.imageView.setVisibility(View.VISIBLE);
                            holder.progressBar.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onError() {
                            holder.progressBar.setVisibility(View.VISIBLE);
                            holder.imageView.setVisibility(View.INVISIBLE);
                        }
                    });

            return view;
        }
    }

    static class ViewHolder {
        ImageView imageView;
        ProgressBar progressBar;
    }
}

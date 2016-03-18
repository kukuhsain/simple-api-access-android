package com.kukuhsain.kukuh.simpleapiaccess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by kukuh on 18/03/16.
 */
public class ListCustomAdapter extends ArrayAdapter<PhoneList> {
    public ListCustomAdapter(Context context, PhoneList[] phoneLists) {
        super(context, R.layout.custom_row, phoneLists);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        PhoneList list = getItem(position);

//        final ImageView weatherIcon = (ImageView) customView.findViewById(R.id.phone_icon);
        TextView phoneName = (TextView) customView.findViewById(R.id.phone_name);
        TextView phonePrice = (TextView) customView.findViewById(R.id.phone_price);

        phoneName.setText(list.name);
        phonePrice.setText("" + list.price);
//        temperature.setText("Temperature " + list.temp.min + "C - " + list.temp.max + "C");

        /*String image_url = "http://api.openweathermap.org/img/w/" + list.weather.get(0).icon + ".png";
        Log.d("url", image_url);*/

        /*Glide.with(getContext())
                .load(image_url)
                .centerCrop()
//                .placeholder(R.drawable.)
                .crossFade()
                .into(weatherIcon);*/

        return customView;
    }
}
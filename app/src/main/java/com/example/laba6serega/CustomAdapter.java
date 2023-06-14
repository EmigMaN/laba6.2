package com.example.laba6serega;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import model.Sight;

public class CustomAdapter extends ArrayAdapter<Sight> {

    public CustomAdapter(@NonNull Context context, int resource, List<Sight> sights) {
        super(context, resource, sights.toArray(new Sight[0]));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.list_layout, null);
        Sight item = getItem(position);
        ((TextView)view.findViewById(R.id.Names)).setText(item.getName());
        ((TextView)view.findViewById(R.id.times)).setText("Время работы:\n" + (item.getDates().isEmpty()?"Круглосуточно":item.getDates()));
        ((ImageView)view.findViewById(R.id.Images))
                .setImageDrawable(getContext()
                        .getDrawable(getContext().getResources().getIdentifier(item.getImageName(), "drawable", getContext().getPackageName())));

        return view;
    }
}

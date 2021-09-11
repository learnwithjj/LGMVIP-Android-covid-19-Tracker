package com.example.covid_19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Model> {
    private List<Model> modelList;
    private Context context;


    public ListAdapter(Context context, List<Model> modelList) {
        super(context, R.layout.testing,modelList);
        this.modelList=modelList;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View listitem=layoutInflater.inflate(R.layout.testing,null ,true);
        TextView state=listitem.findViewById(R.id.state);
        TextView districtData=listitem.findViewById(R.id.districtData);
        TextView active=listitem.findViewById(R.id.active);
        TextView confirmed=listitem.findViewById(R.id.confirmed);
        TextView deceased=listitem.findViewById(R.id.deceased);
        TextView recovered=listitem.findViewById(R.id.recovered);
        TextView ddeceased=listitem.findViewById(R.id.ddeceased);
        TextView dconfirmed=listitem.findViewById(R.id.dconfirmed);
        TextView drecovered=listitem.findViewById(R.id.drecovered);
        Model model=modelList.get(position);
        state.setText(model.getState());
        districtData.setText(model.getDistrictData());
        active.setText("Active : "+model.getActive());
        confirmed.setText(model.getConfirmed());
        deceased.setText(model.getDeceased());
        recovered.setText(model.getRecovered());
        ddeceased.setText(model.getDdeceased());
        dconfirmed.setText(model.getDconfirmed());
        drecovered.setText(model.getDrecovered());
        return listitem;
    }
}

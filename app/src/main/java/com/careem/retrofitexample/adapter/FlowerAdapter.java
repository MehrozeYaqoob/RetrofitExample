package com.careem.retrofitexample.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.careem.retrofitexample.R;
import com.careem.retrofitexample.databinding.FlowerItemBinding;
import com.careem.retrofitexample.model.Flower;

import java.util.List;

/**
 * Created by hp on 12/15/2017.
 */

public class FlowerAdapter extends ArrayAdapter<Flower> {

    private Context context;
    private List<Flower> values;

    public FlowerAdapter(Context context, List<Flower> values) {
        super(context, R.layout.flower_item, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FlowerItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.flower_item,parent,false);
        binding.setFlower(values.get(position));

        return binding.getRoot();
    }
}

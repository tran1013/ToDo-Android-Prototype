package com.example.duc.todoapp.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.duc.todoapp.R;
import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by Duc on 19/10/16.
 */

public class StatisticsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        PieChart chart = (PieChart) view.findViewById(R.id.pieChartView);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(10, 0));
        entries.add(new Entry(90, 1));

        PieDataSet dataset = new PieDataSet(entries, "");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Done");
        labels.add("Undone");

        PieData data = new PieData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        chart.setDescription("");
        chart.setData(data);
        data.setDrawValues(false);
        chart.getLegend().setEnabled(false);
        chart.animate();

        setLabels(view, entries);

        return view;
    }

    public void setLabels(View view, ArrayList<Entry> entries) {
        TextView doneLabel = (TextView) view.findViewById(R.id.donePercTextView);
        doneLabel.setText(Float.toString(entries.get(0).getVal()) + "%");

        TextView undoneLabel = (TextView) view.findViewById(R.id.undonePercTextView);
        undoneLabel.setText(Float.toString(entries.get(1).getVal()) + "%");
    }
}

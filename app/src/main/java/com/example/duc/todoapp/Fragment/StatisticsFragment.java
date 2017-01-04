package com.example.duc.todoapp.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.duc.todoapp.Model.ItemSingleton;
import com.example.duc.todoapp.R;
import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import static com.example.duc.todoapp.Model.ItemSingleton.object;

/**
 * Created by Duc on 19/10/16.
 */

public class StatisticsFragment extends Fragment {

    View view;
    PieChart chart;
    final ArrayList<Entry> entries = new ArrayList<>();

    /**
     * Initialize statistics view
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_statistics, container, false);
        chart = (PieChart) view.findViewById(R.id.pieChartView);
        final ItemSingleton object = ItemSingleton.getInstance();
        chart.setNoDataText("");
        entries.add(new Entry(object.getDone().floatValue(), 0));
        entries.add(new Entry(object.getUndone().floatValue(), 1));

        setChart(chart, entries);
        setLabels(view, entries);
        return view;
    }

    /**
     * Set the done and undone labels and update them
     *
     * @param view
     * @param entries
     */
    public void setLabels(View view, ArrayList<Entry> entries) {

        TextView doneLabel = (TextView) view.findViewById(R.id.donePercTextView);
        doneLabel.setText(String.format("%.1f", entries.get(0).getVal()) + "%");

        TextView undoneLabel = (TextView) view.findViewById(R.id.undonePercTextView);
        undoneLabel.setText(String.format("%.1f", entries.get(1).getVal()) + "%");
    }


    /**
     * Set the chart and prepare it for statistic view
     *
     * @param chart
     * @param entries
     */
    public void setChart(PieChart chart, ArrayList<Entry> entries) {
        TextView freetimeLabel = (TextView) view.findViewById(R.id.freetimeLabel);
        freetimeLabel.setText("");
        PieDataSet dataset = new PieDataSet(entries, "");

        ArrayList<String> labels = new ArrayList<>();
        labels.add(getString(R.string.done));
        labels.add(getString(R.string.undone));

        if (entries.get(0).getVal() == 0.0 && entries.get(1).getVal() == 0.0) {
            freetimeLabel.setText("Congratulations! Nothing to do!");
        } else {

            if ((entries.get(0).getVal() == 0.0)) {
                labels.set(0, "");
            } else if ((entries.get(1).getVal() == 0.0)) {
                labels.set(1, "");
            }

            PieData data = new PieData(labels, dataset);

            dataset.setColors(ColorTemplate.COLORFUL_COLORS);
            chart.setDescription("");
            chart.setData(data);
            data.setDrawValues(false);
            chart.getLegend().setEnabled(false);
            chart.animate();
        }
    }

    /**
     * Clear the array with entries and chart. Refresh the whole view
     */
    public void refresh() {
        entries.clear();
        chart.clear();
        System.out.println("OBJECT IN STAT: " + " DONE: " + object.getDone() + " UNDONE: " + object.getUndone());
        entries.add(new Entry(object.getDone().floatValue(), 0));
        entries.add(new Entry(object.getUndone().floatValue(), 1));
        setChart(chart, entries);
        setLabels(view, entries);
    }

    /**
     * This method will be called, if the statistics view was called and displayed before.
     */
    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }
}

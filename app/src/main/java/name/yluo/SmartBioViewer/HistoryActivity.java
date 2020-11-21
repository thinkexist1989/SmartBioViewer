package name.yluo.SmartBioViewer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private BarChart chart;
    protected final String[] months = new String[] {
           " ", "Day 1", "Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        chart = findViewById(R.id.barChart);

//        chart.getDescription().setEnabled(false);
        chart.setBackgroundColor(this.getColor(R.color.colorBackground));
        chart.getDescription().setText("Measured Level (pM)");
        chart.getDescription().setTextSize(20);
        chart.getDescription().setTextColor(Color.rgb(50,50,50));
        chart.getDescription().setPosition(800,150);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        chart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setDrawBarShadow(false);
        chart.setDrawGridBackground(false);

        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawLabels(true);
        xAxis.setLabelRotationAngle(-45);
//        xAxis.setTextSize(15f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return months[(int) value % months.length];
            }
        });

        chart.getAxisLeft().setDrawGridLines(false);

        //setting data
        ArrayList<BarEntry> values = new ArrayList<>();
        int[] colors = new int[7];
        values.add(new BarEntry(1, 3.0f));
        colors[0] = Color.rgb(146,146,146);
        values.add(new BarEntry(2, 4.0f));
        colors[1] = Color.rgb(146,146,146);
        values.add(new BarEntry(3, 3.0f));
        colors[2] = Color.rgb(146,146,146);
        values.add(new BarEntry(4, 5.0f));
        colors[3] = Color.rgb(146,146,146);
        values.add(new BarEntry(5, 8.0f));
        colors[4] = Color.rgb(146,146,146);
        values.add(new BarEntry(6, 9.0f));
        colors[5] = Color.rgb(248,195,30);
        values.add(new BarEntry(7, 13.0f));
        colors[6] = Color.rgb(228,58,40);

        BarDataSet set1;
        set1 = new BarDataSet(values, "Data Set");
//        set1.setColors(ColorTemplate.VORDIPLOM_COLORS);
        set1.setColors(colors);
        set1.setDrawValues(false);

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);
        data.setValueTextSize(10f);
        chart.setData(data);
        chart.setFitBars(true);

        //显示数值
        for (IDataSet set : chart.getData().getDataSets())
            set.setDrawValues(!set.isDrawValuesEnabled());

        //自动缩放适合大小
        chart.setAutoScaleMinMaxEnabled(!chart.isAutoScaleMinMaxEnabled());
        chart.notifyDataSetChanged();

        chart.invalidate();


        // add a nice and smooth animation
        chart.animateY(1500);

        chart.getLegend().setEnabled(false);

    }
}
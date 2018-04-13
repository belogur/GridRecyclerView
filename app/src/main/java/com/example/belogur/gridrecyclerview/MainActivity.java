package com.example.belogur.gridrecyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private NumberInfo[] _numbers;

    private RecyclerView _recyclerView;
    private NumbersAdapter _numbersAdapter;

    public MainActivity() {
        _numbers = new NumberInfo[107];
        for(int i = 0; i < _numbers.length; i++)
            _numbers[i] = new NumberInfo(i+1);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        _recyclerView = findViewById(R.id.grid_numbers);
        // recyclerView.setHasFixedSize(true);
        int numberOfColumns = calculateNoOfColumns(this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, numberOfColumns);
        _recyclerView.setLayoutManager(layoutManager);
        _numbersAdapter = new NumbersAdapter(this, _numbers, _itemWidthDpi);
        _recyclerView.setAdapter(_numbersAdapter);
    }

    int _itemWidthDpi;
    public int calculateNoOfColumns(Context context) {
        int itemMarginDpi = 4;

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();

        View view = View.inflate(context, R.layout.grid_numbers_item, null);
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int itemWidthPixels = view.getMeasuredWidth();

        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        float itemsInRow = displayMetrics.widthPixels / (itemWidthPixels + itemMarginDpi * displayMetrics.density * 2);
        int noOfColumns = Math.round(itemsInRow);

        _itemWidthDpi = (int)(displayMetrics.widthPixels / noOfColumns - itemMarginDpi * displayMetrics.density * 2);

        Log.d("CalcNoOfColumns", "noOfColumns: " + noOfColumns + ", itemWidth (dp): " + _itemWidthDpi);

        return noOfColumns;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.belogur.gridrecyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.ViewHolder> {
    private static final SimpleDateFormat _guessDateFormat = new SimpleDateFormat("MMM d");
    private static final SimpleDateFormat _guessTimeFormat = new SimpleDateFormat("haa");

    private final NumberInfo[] _numbers;
    private final int _itemWidthDpi;
    private final Context _context;

    public NumbersAdapter(Context context, NumberInfo[] numbers, int itemWidthDpi) {
        _context = context;
        _numbers = numbers;
        _itemWidthDpi = itemWidthDpi;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.grid_numbers_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view, _itemWidthDpi);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NumberInfo numberInfo = _numbers[position];
        String snumber = Integer.toString(numberInfo.getNumber());
        String sguessDate = null;

        holder._textViewNumber.setText(snumber);
        holder._textViewGuessDate.setText(sguessDate);
        if (position % 2 == 0)
            holder._drawView.setVisibility(View.VISIBLE);
        else
            holder._drawView.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return _numbers.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ViewGroup _layout;
        final TextView _textViewNumber;
        final TextView _textViewGuessDate;
        final DrawView _drawView;

        public ViewHolder(View view, int itemWidthDpi) {
            super(view);

            _layout = (ViewGroup) view;
            GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
            layoutParams.width = _itemWidthDpi;
            layoutParams.height = _itemWidthDpi;

            _textViewNumber = _layout.findViewById(R.id.textview_number);
            _textViewNumber.setTextSize(TypedValue.COMPLEX_UNIT_PX, _itemWidthDpi / 2);
            _textViewGuessDate = _layout.findViewById(R.id.textview_guess_date);

            _drawView = new DrawView(_context);
            _layout.addView(_drawView);
        }
    }
}

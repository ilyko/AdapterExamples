package com.slava.adapterexamples.adapters;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.slava.adapterexamples.*;
/**
 * Created by Slava on 28.03.2017.
 */
    public class MainAdapter implements ListAdapter {

    private DataSetObserver mDataSetObserver;
        private String[] array;

        public MainAdapter(String[] array) {
            this.array = array;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {
            this.mDataSetObserver = observer;
        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {
            this.mDataSetObserver = null;
        }

        @Override
        public int getCount() {
            return array.length;
        }

        @Override
        public Object getItem(int position) {
            return array[position];
        }

        @Override
        public long getItemId(int position) {
            return array[position].hashCode();
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater
                        .from(parent.getContext()).inflate(R.layout.item_list_string, parent, false);
            }

            TextView tvId = (TextView) convertView.findViewById(R.id.text_id);
            TextView tvName = (TextView) convertView.findViewById(R.id.text_name);

            tvId.setText("" + position);
            tvName.setText(array[position]);

            return convertView;
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public boolean isEmpty() {
            return array!=null && array.length > 0;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return true;
        }

        @Override
        public boolean isEnabled(int position) {
            return true;
        }
    }
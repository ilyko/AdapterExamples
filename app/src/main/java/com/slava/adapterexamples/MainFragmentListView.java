package com.slava.adapterexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.ArrayAdapter;

import butterknife.BindView;

/**
 * Created by Slava on 28.03.2017.
 */

public class MainFragmentListView extends BaseFragment{
    @BindView(R.id.spinner)
    protected AppCompatSpinner spinner;
    @BindView(R.id.listview)
    protected ListViewCompat listViewCompat;

    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };

    private ArrayAdapter<String> mArrayAdapter;
    @Override
    public int getLayout() {
        return R.layout.fragment_main_list_view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,names);
    }
    @Override
    public void afterCreatedView(View view, Bundle savedInstanceState){
        listViewCompat.setAdapter(mArrayAdapter);
        spinner.setAdapter(mArrayAdapter);
    }


}

package com.slava.adapterexamples;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.slava.adapterexamples.adapters.MainAdapter;

import butterknife.BindView;

/**
 * Created by Slava on 28.03.2017.
 */

public class MainFragmentGridView extends BaseFragment {
    @BindView(R.id.spinner)
    protected AppCompatSpinner spinner;
    @BindView(R.id.gridview)
    protected GridView gridview;
    private DataSetObserver dataSetObserver;

    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };

    private ArrayAdapter<String> mArrayAdapter;
    private MainAdapter mAdapter;
    @Override
    public int getLayout() {
        return R.layout.fragment_main_grid_view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,names);
        mAdapter = new MainAdapter(names);
    }
    @Override
    public void afterCreatedView(View view, Bundle savedInstanceState){
        gridview.setAdapter(mAdapter);
        spinner.setAdapter(mArrayAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LogUtil.info(this, "Parent: "+parent+ "\nPosition: "+position+" View"+view);
                dataSetObserver.onChanged();
            }
        });
    }
}

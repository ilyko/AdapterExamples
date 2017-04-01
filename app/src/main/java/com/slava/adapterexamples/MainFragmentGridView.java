package com.slava.adapterexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.slava.adapterexamples.adapters.MainAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;

/**
 * Created by Slava on 28.03.2017.
 */

public class MainFragmentGridView extends BaseFragment {
    @BindView(R.id.spinner)
    protected AppCompatSpinner spinner;
    @BindView(R.id.gridview)
    protected GridView gridview;
    @BindView(R.id.editText)
    protected EditText editText;
    @BindView(R.id.addButton)
    protected Button addButton;

    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };
    private ArrayList<String> namesArray;
    private ArrayAdapter<String> mArrayAdapter;
    private MainAdapter mAdapter;
    @Override
    public int getLayout() {
        return R.layout.fragment_main_grid_view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        namesArray = new ArrayList<>(Arrays.asList(names));
        mArrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,names);
        mAdapter = new MainAdapter(namesArray);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namesArray.add(editText.getText().toString());
                mAdapter.getmDataSetObserver().onInvalidated();
            }
        });
    }

    @Override
    public void afterCreatedView(View view, Bundle savedInstanceState){
        gridview.setAdapter(mAdapter);
        spinner.setAdapter(mArrayAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LogUtil.info(this, "Parent: "+parent+ "\nPosition: "+position+" View"+view);
                //mAdapter.getmDataSetObserver().onInvalidated();
            }
        });
    }

}

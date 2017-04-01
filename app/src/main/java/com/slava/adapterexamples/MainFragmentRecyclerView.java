package com.slava.adapterexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.slava.adapterexamples.adapters.MainAdapter;
import com.slava.adapterexamples.adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;

/**
 * Created by Slava on 30.03.2017.
 */

public class MainFragmentRecyclerView extends BaseFragment{

    @BindView(R.id.myRecyclerView)
    protected RecyclerView recyclerView;
    @BindView(R.id.editText)
    protected EditText editText;
    @BindView(R.id.addButton)
    protected Button addButton;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };
    ArrayList<String> namesArray;

    @Override
    public int getLayout() {
        return R.layout.fragment_main_recycler_view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namesArray.add(editText.getText().toString());
                rvAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void afterCreatedView(View view, Bundle savedInstanceState) {
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(rvAdapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        namesArray = new ArrayList<>(Arrays.asList(names));
        mLayoutManager = new LinearLayoutManager(getContext());


        // specify an adapter (see also next example)
        rvAdapter = new RecyclerViewAdapter(namesArray);

    }
}

package com.slava.adapterexamples;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fragment mainFragment = getSupportFragmentManager()
                .findFragmentByTag(MainFragmentGridView.class.getCanonicalName());
        if (mainFragment == null) {
            addFragment(this, new MainFragmentGridView(), R.id.coordinator_layout, false);
        }
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }
}

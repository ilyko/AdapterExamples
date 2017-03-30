package com.slava.adapterexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Slava on 28.03.2017.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
    }

    public void addFragment(BaseActivity activity, Fragment fragment, int container, boolean backStack){

        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.add(container,fragment,fragment.getClass().getCanonicalName());
        if(backStack){
            transaction.addToBackStack(fragment.getClass().getCanonicalName());
        }
        transaction.commitAllowingStateLoss();
    }

    public abstract int getLayout();
}

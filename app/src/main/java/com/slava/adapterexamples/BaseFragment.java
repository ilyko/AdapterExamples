package com.slava.adapterexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Slava on 28.03.2017.
 */

public abstract class BaseFragment extends Fragment{
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    public abstract int getLayout();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        afterCreatedView(view,savedInstanceState);
    }

    protected abstract void afterCreatedView(View view, Bundle savedInstanceState);

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public <T extends BaseActivity> T getAct(){
        return (T) getActivity();
    }


}

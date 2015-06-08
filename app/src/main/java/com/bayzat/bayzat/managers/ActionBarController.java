package com.bayzat.bayzat.managers;


import android.support.v7.widget.Toolbar;

import com.bayzat.bayzat.R;
import com.bayzat.bayzat.basic.BaseActivity;

/**
 * Created by Michael on 08.06.2015.
 */
public final class ActionBarController {

    //_____________________ Public variables ____________________//
    public Toolbar mToolbar;

    public void register(BaseActivity baseActivity){
        mToolbar = (Toolbar) baseActivity.findViewById(R.id.toolbar);
        baseActivity.setSupportActionBar(mToolbar);
    }

    public void changeVisibleArrow(boolean visible){
        //TODO continue work action bar controller configuration
    }
}

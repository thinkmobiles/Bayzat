package com.bayzat.bayzat.ui.activities;

import android.os.Bundle;

import com.bayzat.bayzat.R;
import com.bayzat.bayzat.basic.BaseActivity;
import com.bayzat.bayzat.managers.FragmentNavigator;
import com.bayzat.bayzat.ui.fragments.MyPolicyFragment;

/**
 * Created by Michael on 08.06.2015.
 */
public class MainActivity extends BaseActivity {
    private FragmentNavigator navigator = new FragmentNavigator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigator.register(getFragmentManager(), R.id.container);
        navigator.showFragment(new MyPolicyFragment());
    }
}

package com.bayzat.bayzat.basic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bayzat.bayzat.R;
import com.bayzat.bayzat.managers.ActionBarController;

/**
 * Created by Michael on 08.06.2015.
 */
public abstract class BaseActivity extends AppCompatActivity {

    //_____________________ Private variables ____________________//
    private ActionBarController abController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        abController = new ActionBarController();
        abController.register(this);
    }

    /**
     * The method finding view in activity
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T $(int resId){
        return (T) findViewById(resId);
    }

    /**
     * The method opening new activity
     */
    public void handleToActivity(Class<? extends BaseActivity> activityClass){
        final Intent activityTransactionIntent = new Intent(this, activityClass);
        startActivity(activityTransactionIntent);
    }

    /**
     * The method opening new activity with request code
     */
    public void handleToActivity(Class<? extends BaseActivity> activityClass, int requestCode){
        final Intent activityTransactionIntent = new Intent(this, activityClass);
        startActivityForResult(activityTransactionIntent, requestCode);
    }
}

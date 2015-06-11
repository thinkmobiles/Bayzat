package com.bayzat.bayzat.splash;

import android.os.Bundle;
import android.os.Handler;

import com.bayzat.bayzat.ui.activities.MainActivity;
import com.bayzat.bayzat.R;
import com.bayzat.bayzat.basic.BaseActivity;

/**
 * Created by Michael on 02.06.2015.
 */
public class SplashActivity extends BaseActivity {

    //____________________________ Constants _________________________//
    public static int DELAY_SPLASH = 2000;

    //_______________________ Private variables ______________________//
    private final Handler  mHandlerTask = new Handler();
    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            finish();
            handleToActivity(MainActivity.class);



        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandlerTask.postDelayed(mRunnable, DELAY_SPLASH);
    }
}

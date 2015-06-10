package com.bayzat.bayzat.basic;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Michael on 08.06.2015.
 */
public abstract class BaseFragment extends Fragment {

    //____________________ Protected variables ___________________//
    protected BaseActivity  mActivity;
    protected View          inflatedView;

    //_____________________ Private variables ____________________//
    private int             fragmentResId = -1;

    /**
     * The method sets resources into fragment.
     * @param resId - resource for inflating view in fragment
     */
    protected void setContentView(@LayoutRes int resId){
        this.fragmentResId = resId;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (BaseActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (fragmentResId != -1) {
            inflatedView = inflater.inflate(fragmentResId, container, false);
            return inflatedView;
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * The method finding view in parent view
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T $(@IdRes int resId){
        if (inflatedView == null )
            return null;
        return (T) inflatedView.findViewById(resId);
    }
}

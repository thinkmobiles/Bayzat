package com.bayzat.bayzat.ui.custom_views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bayzat.bayzat.R;

import java.util.List;

/**
 * Created by rMozes on 2015.06.10..
 */
public final class OfferedServicesView extends LinearLayout {

    //Possible services
    private static final String OUT_PATIENT = "Out Patient";
    private static final String IN_PATIENT  = "In Patient";
    private static final String DENTAL      = "Dental";
    private static final String MATERNITY   = "Maternity";

    //Services from server
    private List<String> mOfferedServices;

    //Service indicators
    private ImageView ivOutPatient, ivInPatient, ivDental, ivMaternity;

    //Primitive variables
    private final int mPaddingBetweenImages;

    public OfferedServicesView(Context context) {
        this(context, null);
    }

    public OfferedServicesView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OfferedServicesView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaddingBetweenImages = (int) getResources().getDimension(R.dimen.half_padding);
        initProperties();
    }

    private void initProperties() {
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        initUI();
        initPaddingBetweenImages();
    }

    private void initUI() {
        ivOutPatient = new ImageView(getContext());
        ivOutPatient.setImageResource(android.R.drawable.arrow_down_float);

        ivInPatient = new ImageView(getContext());
        ivInPatient.setImageResource(android.R.drawable.arrow_up_float);

        ivDental = new ImageView(getContext());
        ivDental.setImageResource(android.R.drawable.ic_input_add);

        ivMaternity = new ImageView(getContext());
        ivMaternity.setImageResource(android.R.drawable.ic_delete);
    }

    private void initPaddingBetweenImages() {
        setPaddingToView(ivOutPatient);
        setPaddingToView(ivInPatient);
        setPaddingToView(ivDental);
        setPaddingToView(ivMaternity);
    }

    private void setPaddingToView(final View _view) {
        _view.setPadding(mPaddingBetweenImages, mPaddingBetweenImages,
                mPaddingBetweenImages, mPaddingBetweenImages);
    }

    public final void setOfferedServices(final List<String> _listServices) {
        mOfferedServices = _listServices;
        setVisibilityDependsOnOfferedList();
    }

    private void setVisibilityDependsOnOfferedList() {
        addView(ivOutPatient, mOfferedServices.contains(OUT_PATIENT));
        addView(ivInPatient, mOfferedServices.contains(IN_PATIENT));
        addView(ivDental, mOfferedServices.contains(DENTAL));
        addView(ivMaternity, mOfferedServices.contains(MATERNITY));
    }

    private void addView(final View _view, final boolean _needToAdd) {
        if (_needToAdd)
            addView(_view);
        else
            removeView(_view);
    }

    @Override
    public void addView(View child) {
        if (child.getParent() != null)
            return;

        super.addView(child);
    }
}

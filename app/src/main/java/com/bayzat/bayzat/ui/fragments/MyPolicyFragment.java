package com.bayzat.bayzat.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bayzat.bayzat.R;
import com.bayzat.bayzat.adapters.PolicyAdapter;
import com.bayzat.bayzat.api.models.FeatureModel;
import com.bayzat.bayzat.api.models.PolicyDetails;
import com.bayzat.bayzat.basic.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rMozes on 2015.06.10..
 */
public final class MyPolicyFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {

    //UI
    private RadioGroup rgRadioContainer;
    private RadioButton rbExcluded, rbIncluded;
    private ListView lvPolicyServices;

    //Data from server
    private PolicyDetails mModel;

    //Variables
    private PolicyAdapter mAdapter;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_my_policy);
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new PolicyAdapter(mActivity);
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        findUI();
        initListeners();
        setAdapter();
        downloadData();

        return view;
    }

    private void findUI() {
        rgRadioContainer    = $(R.id.rgRadioContainer_FMP);
        rbExcluded          = $(R.id.rbExcluded_FMP);
        rbIncluded          = $(R.id.rbIncluded_FMP);

        lvPolicyServices    = $(R.id.lvPolicyServices_FMP);
    }

    private void initListeners() {
        rgRadioContainer.setOnCheckedChangeListener(this);
    }

    private void setAdapter() {
        if (lvPolicyServices.getAdapter() == null)
            lvPolicyServices.setAdapter(mAdapter);
    }

    private void downloadData() {
        //TODO: get data from server
        generateDummyData();
        rbIncluded.setChecked(true);
    }

    @Override
    public final void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbIncluded_FMP:
                includedChecked();
                break;
            case R.id.rbExcluded_FMP:
                excludedChecked();
                break;
        }
    }

    private void includedChecked() {
        mAdapter.setData(mModel.includedFeatures);
    }

    private void excludedChecked() {
        mAdapter.setData(mModel.excludedFeatures);
    }

    private void generateDummyData() {
        mModel = new PolicyDetails();
        mModel.excludedFeatures = new ArrayList<>();
        mModel.includedFeatures = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            FeatureModel model = new FeatureModel();
            model.preauthorized = (i % 3) == 0;
            model.id = i;
            model.servicesOffered = new ArrayList<>();
            model.servicesOffered.add("Out Patient");
            model.servicesOffered.add("In Patient");
            model.servicesOffered.add("Dental");
            model.servicesOffered.add("Maternity");
            model.title = "title " + i;
            if (i % 2 == 0) {
                mModel.excludedFeatures.add(model);
            } else {
                mModel.includedFeatures.add(model);
            }
        }
    }
}

package com.bayzat.bayzat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bayzat.bayzat.R;
import com.bayzat.bayzat.api.models.FeatureModel;
import com.bayzat.bayzat.ui.custom_views.OfferedServicesView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rMozes on 2015.06.10..
 */
public final class PolicyAdapter extends BaseAdapter {

    private Context mContext;

    //Data from server
    private List<FeatureModel> mFeatureData;

    public PolicyAdapter(final Context _context) {
        mContext = _context;
        mFeatureData = new ArrayList<>();
    }

    public final void setData(final List<FeatureModel> _models) {
        mFeatureData = _models;
        notifyDataSetChanged();
    }

    @Override
    public final int getCount() {
        return mFeatureData.size();
    }

    @Override
    public final FeatureModel getItem(int _position) {
        return mFeatureData.get(_position);
    }

    @Override
    public final long getItemId(int _position) {
        return _position;
    }

    @Override
    public final View getView(int _position, View _convertView, ViewGroup _parent) {
        ViewHolder viewHolder;
        if (_convertView == null) {
            _convertView = LayoutInflater.from(mContext).inflate(R.layout.item_my_policy, _parent, false);
            viewHolder = new ViewHolder(_convertView);
        } else {
            viewHolder = (ViewHolder) _convertView.getTag();
        }

        viewHolder.updateView(getItem(_position));

        return _convertView;
    }

    private class ViewHolder {
        private TextView tvServiceName, tvPreAuthorized;
        private OfferedServicesView cvOfferedServices;

        public ViewHolder(final View _convertView) {
            initUI(_convertView);

            _convertView.setTag(this);
        }

        private void initUI(final View _convertView) {
            tvServiceName       = (TextView) _convertView.findViewById(R.id.tvServiceName_IMP);
            tvPreAuthorized     = (TextView) _convertView.findViewById(R.id.tvPreAuthorized_IMP);

            cvOfferedServices   = (OfferedServicesView) _convertView.findViewById(R.id.cvOfferedServices_IMP);
        }

        public final void updateView(final FeatureModel _model) {
            tvPreAuthorized.setText(_model.preauthorized ? mContext.getString(R.string.preauthorized_FMP) : "");
            tvServiceName.setText(_model.title);
            cvOfferedServices.setOfferedServices(_model.servicesOffered);
        }
    }
}

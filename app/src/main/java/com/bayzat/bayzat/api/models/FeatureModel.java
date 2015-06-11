package com.bayzat.bayzat.api.models;

import java.util.List;

/**
 * Created by rMozes on 2015.06.10..
 */
public final class FeatureModel {
    public long id;
    public String title;
    public String decription;
    public boolean preauthorized;
    public List<String> servicesOffered; //TODO: add annotation to GSON
}

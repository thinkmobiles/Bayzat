package com.bayzat.bayzat.api.models;

import java.util.List;

/**
 * Created by rMozes on 2015.06.10..
 */
public final class PolicyDetails {
    public List<FeatureModel> includedFeatures; //TODO: add GSON serializer annotation
    public List<FeatureModel> excludedFeatures; //TODO: add GSON serializer annotation
}

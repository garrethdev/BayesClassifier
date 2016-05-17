package com.example.runnableexample;

/**
 * Created by dottig2-adm on 5/16/2016.
 */

/**
 * Simple interface defining the method to calculate the feature probability.
 *
 * @author Philipp Nolte
 *
 * @param <T> The feature class.
 * @param <K> The category class.
 */
public interface IFeatureProbability<T, K> {

    public float featureProbability(T feature, K category);

}

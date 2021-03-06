package com.tevl.ds;

import com.tevl.ds.strategy.ExtrapolationStrategy;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class AutoExtrapolatingDataset<T> implements TimeseriesDataset<T> {

    private final TimeseriesDataset<T> underlyingDataset;
    private final ExtrapolationStrategy<T> extrapolationStrategy;

    public AutoExtrapolatingDataset(TimeseriesDataset<T> dataset, ExtrapolationStrategy<T> strategy)
    {
        this.underlyingDataset = dataset;
        this.extrapolationStrategy = strategy;
    }


    @Override
    public T addValue(long timestamp,T v) {
        return underlyingDataset.addValue(timestamp, v);
    }

    @Override
    public T getValue(long timestamp) {
        T value = underlyingDataset.getValue(timestamp);

        if(value == null)
        {
            return extrapolationStrategy.getValue(timestamp, underlyingDataset);
        }

        return value;
    }

    @Override
    public T getValueBefore(long timestamp) {
        return underlyingDataset.getValueBefore(timestamp);
    }

    @Override
    public Set<Long> getTimestampSeries() {
        return underlyingDataset.getTimestampSeries();
    }

    @Override
    public int size() {
        return underlyingDataset.size();
    }

    @Override
    public T getDefaultValue() {
        return underlyingDataset.getDefaultValue();
    }


    @Override
    public Iterator<Map.Entry<Long,T>> iterator() {
        return underlyingDataset.iterator();
    }
}

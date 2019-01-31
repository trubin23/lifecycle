package ru.trubin23.lifecycle.fourth_activity;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class ModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final long mValue;

    public ModelFactory(long value) {
        super();
        mValue = value;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == MyViewModel.class) {
            //noinspection unchecked
            return (T) new MyViewModel(mValue);
        }
        return super.create(modelClass);
    }
}

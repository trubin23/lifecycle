package ru.trubin23.lifecycle.fourth_activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    Repository mRepository;
    private MutableLiveData<String> mMutableLiveData;

    public LiveData<String> getData() {
        if (mMutableLiveData == null) {
            mMutableLiveData = new MutableLiveData<>();
            mRepository = Repository.getInstance();
            loadData();
        }
        return mMutableLiveData;
    }

    private void loadData() {
        mRepository.getData(new Repository.Callback() {
            @Override
            public void onSuccess(String result) {
                mMutableLiveData.postValue(result);
            }

            @Override
            public void onError() {
            }
        });
    }
}

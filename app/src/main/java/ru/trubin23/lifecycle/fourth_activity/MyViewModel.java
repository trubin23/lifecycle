package ru.trubin23.lifecycle.fourth_activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

public class MyViewModel extends ViewModel {

    private static final String TAG = MyViewModel.class.getSimpleName();

    private Repository mRepository;
    private MutableLiveData<String> mMutableLiveData;
    private long mValue;

    MyViewModel(long value){
        mValue = value;
    }

    LiveData<String> getData() {
        if (mMutableLiveData == null) {
            mMutableLiveData = new MutableLiveData<>();
            mRepository = Repository.getInstance();
            loadData();
        }
        return mMutableLiveData;
    }

    private void loadData() {
        mRepository.getData(mValue, new Repository.Callback() {
            @Override
            public void onSuccess(String result) {
                mMutableLiveData.postValue(result);
            }

            @Override
            public void onError() {
            }
        });
    }

    @Override
    protected void onCleared() {
        Log.d(TAG, "onCleared");
    }
}

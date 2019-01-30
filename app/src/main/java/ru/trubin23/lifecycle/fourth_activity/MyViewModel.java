package ru.trubin23.lifecycle.fourth_activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData mMutableLiveData;

    public LiveData<String> getData(){
        if (mMutableLiveData == null){
            mMutableLiveData = new MutableLiveData();
            loadData();
        }
        return mMutableLiveData;
    }

    private void loadData(){

    }
}

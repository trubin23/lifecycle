package ru.trubin23.lifecycle.second_activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

class UserController {

    private static UserController INSTANCE;

    private MutableLiveData<User> mLiveData = new MutableLiveData<>();

    private UserController() {
    }

    static UserController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserController();
        }
        return INSTANCE;
    }

    LiveData<User> getLiveData() {
        return mLiveData;
    }

    void setUser(final User user) {
        mLiveData.setValue(user);
    }
}
package ru.trubin23.lifecycle.fourth_activity;

class Repository {

    private Repository INSTANCE;

    private Repository() {
    }

    public Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    public void getData(){

    }
}

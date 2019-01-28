package ru.trubin23.lifecycle;

class User {

    User(Integer id) {
        mId = id;
        mFirstName = "firstName " + String.valueOf(id) + " firstName";
        mLastName = "lastName " + String.valueOf(id) + " lastName";
    }

    private Integer mId;
    private String mFirstName;
    private String mLastName;

    @Override
    public String toString() {
        return "{id = " + String.valueOf(mId) +
                "\nFirstName = " + mFirstName +
                "\nLastName = " + mLastName + "}";
    }
}

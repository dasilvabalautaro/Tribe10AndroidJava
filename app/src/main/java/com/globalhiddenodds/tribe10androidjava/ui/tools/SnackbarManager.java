package com.globalhiddenodds.tribe10androidjava.ui.tools;

import androidx.annotation.StringRes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class SnackbarManager {
    private static SnackbarManager snackbarManager;
    private final MutableLiveData<String> mutableMessage = new MutableLiveData<>();
    LiveData<String> messages = mutableMessage;
    private SnackbarManager(){}

    public static SnackbarManager getSingletonInstance() {
        if (snackbarManager == null) {
            snackbarManager = new SnackbarManager();
        }
        return snackbarManager;
    }

    public void showMessage(@StringRes int message) {
        mutableMessage.setValue(SnackbarMessage.getSingletonInstance().toMessage(message));
    }

    public void showMessage(String message) {
        mutableMessage.setValue(message);
    }
}

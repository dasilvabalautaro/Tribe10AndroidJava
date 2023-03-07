package com.globalhiddenodds.tribe10androidjava.ui.tools;

import android.content.res.Resources;

import androidx.annotation.StringRes;

public class SnackbarMessage {
    private static SnackbarMessage snackbarMessage;

    private SnackbarMessage(){}
    public static SnackbarMessage getSingletonInstance() {
        if (snackbarMessage == null) {
            snackbarMessage = new SnackbarMessage();
        }

        return snackbarMessage;
    }

    String toMessage(String message) {
        return message;
    }

    String toMessage(@StringRes int message) {
        return Resources.getSystem().getString(message);
    }

}

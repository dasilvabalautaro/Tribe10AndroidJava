package com.globalhiddenodds.tribe10androidjava.data;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface HistoryRepository {
    LiveData<List<History>> getAllHistoriesStream();
    LiveData<History> getHistoryStream(int id);
    void insertHistory(History item);
}

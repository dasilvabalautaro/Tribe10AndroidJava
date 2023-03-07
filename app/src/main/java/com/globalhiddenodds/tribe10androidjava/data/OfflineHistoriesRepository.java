package com.globalhiddenodds.tribe10androidjava.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class OfflineHistoriesRepository implements HistoryRepository{
    private final HistoryDao historyDao;
    private final LiveData<List<History>> allHistory;

    public OfflineHistoriesRepository(Application application) {
        HistoryDatabase db = HistoryDatabase.getDatabase(application);
        this.historyDao = db.historyDao();
        this.allHistory = this.historyDao.getAllHistories();
    }

    @Override
    public LiveData<List<History>> getAllHistoriesStream() {
        return this.allHistory;
    }

    @Override
    public LiveData<History> getHistoryStream(int id) {
        return historyDao.getHistory(id);
    }

    @Override
    public void insertHistory(History item) {
        HistoryDatabase.databaseWriteExecutor.execute(() -> {
            historyDao.insert(item);
        });

    }


}
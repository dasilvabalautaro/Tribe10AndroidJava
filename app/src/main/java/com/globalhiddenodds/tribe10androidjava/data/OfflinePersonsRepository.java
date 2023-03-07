package com.globalhiddenodds.tribe10androidjava.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

public class OfflinePersonsRepository implements PersonRepository{

    private final PersonDao personDao;

    public OfflinePersonsRepository(Application application) {

        HistoryDatabase db = HistoryDatabase.getDatabase(application);
        this.personDao = db.personDao();
    }

    @Override
    public LiveData<Integer> getCount() {
        return personDao.getCount();
    }

    @Override
    public void insertPerson(Person item) {
        HistoryDatabase.databaseWriteExecutor.execute(() -> {
            personDao.insert(item);
        });

    }
}

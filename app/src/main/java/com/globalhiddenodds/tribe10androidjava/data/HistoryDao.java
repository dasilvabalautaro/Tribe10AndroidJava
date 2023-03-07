package com.globalhiddenodds.tribe10androidjava.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDao {
    @Query("SELECT * from histories ORDER BY id ASC")
    LiveData<List<History>> getAllHistories();

    @Query("SELECT * from histories WHERE id = :id")
    LiveData<History> getHistory(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(History item);
}

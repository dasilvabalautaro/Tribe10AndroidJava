package com.globalhiddenodds.tribe10androidjava.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface PersonDao {
    @Query("SELECT COUNT(id) FROM persons")
    LiveData<Integer> getCount();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Person item);
}

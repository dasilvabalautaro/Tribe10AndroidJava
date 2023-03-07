package com.globalhiddenodds.tribe10androidjava.data;

import androidx.lifecycle.LiveData;

public interface PersonRepository {
    LiveData<Integer> getCount();
    void insertPerson(Person item);
}

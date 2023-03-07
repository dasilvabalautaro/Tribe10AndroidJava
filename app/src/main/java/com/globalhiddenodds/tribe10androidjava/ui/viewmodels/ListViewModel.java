package com.globalhiddenodds.tribe10androidjava.ui.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.globalhiddenodds.tribe10androidjava.data.History;
import com.globalhiddenodds.tribe10androidjava.data.OfflineHistoriesRepository;

import java.util.List;

public class ListViewModel extends AndroidViewModel {
    private final OfflineHistoriesRepository historyRepository;
    private final MutableLiveData<List<History>> _uiState = new MutableLiveData<>();
    public LiveData<List<History>> uiState;

    public ListViewModel(Application application) {
        super(application);
        this.historyRepository = new OfflineHistoriesRepository(application);
        this.uiState = historyRepository.getAllHistoriesStream();

    }

    public LiveData<List<History>> onGetList() {
        return uiState;
    }


}

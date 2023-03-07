package com.globalhiddenodds.tribe10androidjava.ui.viewmodels;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.globalhiddenodds.tribe10androidjava.R.drawable;
import com.globalhiddenodds.tribe10androidjava.data.OfflineHistoriesRepository;
import com.globalhiddenodds.tribe10androidjava.ui.data.EntryUiState;
import com.globalhiddenodds.tribe10androidjava.ui.tools.Transform;

public class EntryViewModel extends AndroidViewModel {
    private final OfflineHistoriesRepository historyRepository;
    private EntryUiState entryUiState;
    private final MutableLiveData<EntryUiState> _uiState = new MutableLiveData<>();
    public LiveData<EntryUiState> uiState = _uiState;

    public EntryViewModel(Application application) {
        super(application);
        this.historyRepository = new OfflineHistoriesRepository(application);
    }

    public void initialize(Context context) {
        this.entryUiState = new EntryUiState("",
                Transform.getSingletonInstance()
                        .getBitmapFromDrawable(context, drawable.camera_google), false);
        _uiState.setValue(this.entryUiState);
    }

    public void onDescriptionChange(String newValue){
        this.entryUiState.setDescription(newValue);
        _uiState.setValue(this.entryUiState);
    }

    public void onImageChange(Bitmap newValue) {
        this.entryUiState.setImage(Transform.getSingletonInstance().resizeBitmap(newValue));
        this.entryUiState.setCapture(true);
        _uiState.setValue(this.entryUiState);

    }

    public void onSaveHistory() {
        if (validateInput()) {
            historyRepository.insertHistory(this.entryUiState.toHistory());

        }
    }

    private boolean validateInput() {
        return !this.entryUiState.getDescription().isEmpty() && this.entryUiState.isCapture();
    }
}

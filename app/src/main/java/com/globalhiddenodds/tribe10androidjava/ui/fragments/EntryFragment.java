package com.globalhiddenodds.tribe10androidjava.ui.fragments;

import static androidx.navigation.Navigation.findNavController;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.globalhiddenodds.tribe10androidjava.R;
import com.globalhiddenodds.tribe10androidjava.databinding.FragmentEntryBinding;
import com.globalhiddenodds.tribe10androidjava.ui.viewmodels.EntryViewModel;

public class EntryFragment extends Fragment {
    FragmentEntryBinding binding;
    private EntryViewModel entryViewModel;

    ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == AppCompatActivity.RESULT_OK) {
                    Intent data = result.getData();
                    if(data != null && data.getExtras() != null){
                        Bitmap photoBitmap = (Bitmap) data.getExtras().get("data");
                        if (photoBitmap != null) {
                            entryViewModel.onImageChange(photoBitmap);
                        }
                    }
                }
            }
    );

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        binding = FragmentEntryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        entryViewModel = new ViewModelProvider(requireActivity()).get(EntryViewModel.class);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setEntryModel(entryViewModel);
        entryViewModel.initialize(this.getContext());

        binding.txtDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                entryViewModel.onDescriptionChange(s.toString());
            }
        });

        binding.icoTrash.setOnClickListener(v -> {
            entryViewModel.initialize(v.getContext());
            binding.txtDescription.setText("");
        });

        binding.btnSave.setOnClickListener(v -> {
            entryViewModel.onSaveHistory();
            findNavController(v).navigate(R.id.next_action_post);
        });

        binding.icoCapture.setOnClickListener(v -> {
            Intent photoIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult.launch(photoIntent);
        });
    }


}

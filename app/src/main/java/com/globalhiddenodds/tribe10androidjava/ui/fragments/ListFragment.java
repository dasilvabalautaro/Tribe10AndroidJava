package com.globalhiddenodds.tribe10androidjava.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.globalhiddenodds.tribe10androidjava.databinding.FragmentListBinding;
import com.globalhiddenodds.tribe10androidjava.ui.adapters.PostAdapter;
import com.globalhiddenodds.tribe10androidjava.ui.viewmodels.ListViewModel;

public class ListFragment extends Fragment {
    FragmentListBinding binding;
    ListViewModel listViewModel;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listViewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewModel(listViewModel);
        PostAdapter adapter = new PostAdapter(new PostAdapter.ItemDiff());
        binding.rvPost.setAdapter(adapter);
        listViewModel.onGetList().observe(requireActivity(), adapter::submitList);

    }
}

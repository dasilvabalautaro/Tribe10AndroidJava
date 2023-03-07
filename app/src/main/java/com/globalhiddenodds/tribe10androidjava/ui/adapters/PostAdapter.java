package com.globalhiddenodds.tribe10androidjava.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.globalhiddenodds.tribe10androidjava.data.History;
import com.globalhiddenodds.tribe10androidjava.databinding.PostItemBinding;

public class PostAdapter extends ListAdapter<History, PostAdapter.PostItemViewHolder> {
    public PostAdapter(@NonNull DiffUtil.ItemCallback<History> diffCallback) {
        super(diffCallback);
    }


    @NonNull
    @Override
    public PostItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)  {

        return new PostItemViewHolder(PostItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull PostItemViewHolder holder, int position) {
        History current = getItem(position);
        holder.bind(current);
    }

     static class PostItemViewHolder extends RecyclerView.ViewHolder {
        private final PostItemBinding binding;
        public PostItemViewHolder(@NonNull PostItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(History history) {
            binding.setHistory(history);
            binding.executePendingBindings();
        }
    }

    public static class ItemDiff extends DiffUtil.ItemCallback<History> {

        @Override
        public boolean areItemsTheSame(@NonNull History oldItem, @NonNull History newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull History oldItem, @NonNull History newItem) {
            return oldItem.getId() == newItem.getId();
        }
    }
}

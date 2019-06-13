package com.phuong.apptruyen.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.phuong.apptruyen.R;
import com.phuong.apptruyen.inter.IStore;
import com.phuong.apptruyen.item.Store;

public class AdapterStore extends RecyclerView.Adapter<AdapterStore.StoreViewHolder>{
    private IStore inter;

    public AdapterStore(IStore inter) {
        this.inter = inter;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).
            inflate(R.layout.item_store,viewGroup,false);
        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StoreViewHolder storeViewHolder, int i) {
        Store store=inter.getStore(i);
        storeViewHolder.tvName.setText(store.getName());
        storeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inter.onClick(storeViewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return inter.getSize();
    }

    static class StoreViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView title;
        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tv_store);
        }
    }
}

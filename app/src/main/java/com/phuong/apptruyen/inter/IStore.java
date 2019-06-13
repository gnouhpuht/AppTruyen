package com.phuong.apptruyen.inter;

import com.phuong.apptruyen.item.Store;

public interface IStore {
    int getSize();
    Store getStore(int position);
    void onClick(int position);
}

package com.phuong.apptruyen.inter;

import com.phuong.apptruyen.item.Topic;

public interface ITopic {
    int getSize();
    Topic getTopic(int position);
    void onClick(int position);
}

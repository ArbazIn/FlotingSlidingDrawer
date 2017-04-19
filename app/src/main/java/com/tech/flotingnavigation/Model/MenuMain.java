package com.tech.flotingnavigation.Model;

import java.io.Serializable;

/**
 * Created by arbaz on 19/4/17.
 */

public class MenuMain implements Serializable {
    public String ItemName;
    public int imgResID;

    public MenuMain(String itemName) {
        ItemName = itemName;
    }

    public MenuMain(String itemName, int imgResID) {
        ItemName = itemName;
        this.imgResID = imgResID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getImgResID() {
        return imgResID;
    }

    public void setImgResID(int imgResID) {
        this.imgResID = imgResID;
    }
}

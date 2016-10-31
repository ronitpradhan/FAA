package com.example.ronit.faa.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by RONIT on 11/1/2016.
 */

public class Aid extends RealmObject{
    public Aid(String search) {
        this.search = search;
    }

    @PrimaryKey
    private String search;

    public Aid() {
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}

package com.cesi.library_project.database.models;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Livre implements IMetaDataProvider, IIdSetter {

    @PrimaryKey(autoIncrement = true)
    private long id;
    private String name;

    @ForeignKey(table = "MetaData", column = "id", childReference = "meta_data")
    private long meta_data_id;
    private MetaData meta_data;

    public Livre() {

    }

    public Livre(long status, MetaData meta_data) {
        setMetaData(meta_data);
        setName(name);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public MetaData getMetaData() {
        return meta_data;
    }

    @Override
    public void setMetaData(MetaData meta_data) {
        this.meta_data_id = meta_data.getId();
        this.meta_data = meta_data;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

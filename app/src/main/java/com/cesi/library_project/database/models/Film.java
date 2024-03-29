package com.cesi.library_project.database.models;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Film implements IMetaDataProvider, IIdSetter {

    @PrimaryKey(autoIncrement = true)
    private long id;

    private long duration;

    private String name;

    @ForeignKey(table = "MetaData", column = "id", childReference = "meta_data")
    private long meta_data_id;

    private MetaData meta_data;

    public Film() {

    }

    public Film(long duration, MetaData meta_data) {
        setDuration(duration);
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

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
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

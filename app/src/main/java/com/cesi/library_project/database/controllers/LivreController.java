package com.cesi.library_project.database.controllers;

import com.cesi.library_project.database.db.LibraryDatabase;
import com.cesi.library_project.database.models.Film;
import com.cesi.library_project.database.models.Livre;
import com.sun.istack.internal.NotNull;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;

import java.sql.ResultSet;
import java.util.HashMap;

public class LivreController extends AbstractController<Livre> {

    private static final LivreController CATEGORY_CONTROLLER = new LivreController ();

    public static LivreController getInstance() {
        return CATEGORY_CONTROLLER;
    }

    private LivreController() {
        super();
    }

    @NotNull
    @Override
    protected Class<Livre> getModelClass() {
        return Livre.class;
    }

    @Override
    protected ObjectModel<Livre, ResultSet, HashMap<String, Object>> createJDBCObject(LibraryDatabase instance) throws NoSuchFieldException, ClassNotFoundException {
        return new JdbcObjectModel<Livre> (instance) {
        };
    }
}

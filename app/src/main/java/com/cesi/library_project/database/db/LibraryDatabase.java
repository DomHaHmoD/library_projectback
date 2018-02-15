package com.cesi.library_project.database.db;

import com.cesi.library_project.database.controllers.CategoryController;
import com.cesi.library_project.database.controllers.FilmController;
import com.cesi.library_project.database.controllers.MetaDataController;
import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.database.models.Film;
import com.cesi.library_project.database.models.MetaData;
import com.cesi.library_project.database.models.Status;
import za.co.neilson.sqlite.orm.DatabaseDriverInterface;
import za.co.neilson.sqlite.orm.DatabaseInfo;
import za.co.neilson.sqlite.orm.DatabaseModel;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcSqliteDatabaseDriverInterface;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

public class LibraryDatabase extends DatabaseModel<ResultSet, HashMap<String, Object>> {

    public LibraryDatabase() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        super((Object[]) null);
    }

    @Override
    public ObjectModel<DatabaseInfo, ResultSet, HashMap<String, Object>> onCreateDatabaseInfoModel() throws ClassNotFoundException, NoSuchFieldException {
        return new JdbcObjectModel<DatabaseInfo>(this) {
            //abstract class
        };
    }

    @Override
    protected DatabaseDriverInterface<ResultSet, HashMap<String, Object>> onInitializeDatabaseDriverInterface(Object... objects) {
        return new JdbcSqliteDatabaseDriverInterface(this);
    }

    @Override
    protected void onRegisterObjectModels(HashMap<Type, ObjectModel<?, ResultSet, HashMap<String, Object>>> hashMap) throws ClassNotFoundException, NoSuchFieldException {
        /*
         * Tables Managed By This Model
         */
        MetaDataController.getInstance().initModelForDatabase(objectModels, this);
        CategoryController.getInstance().initModelForDatabase(objectModels, this);
        FilmController.getInstance().initModelForDatabase(objectModels, this);
    }

    @Override
    public String getDatabaseName() {
        return "library.db";
    }

    @Override
    public int getDatabaseVersion() {
        return 1;
    }

    @Override
    protected void onInsertDefaultValues() {
        CategoryController.getInstance().init(this);
        FilmController.getInstance().init(this);
        MetaDataController.getInstance().init(this);

        Category[] categories = new Category[]{
                new Category("Film"),
                new Category("Musique"),
                new Category("Livre"),
                new Category("Jeu"),
                new Category("Table"), // add this category to test a table
        };

        MetaData meta_data = new MetaData("Une metadata",
                1,
                "carrefour",
                new Date(),
                "il était bien",
                Status.ABANDONNED);
        MetaDataController.getInstance().create(meta_data);
        System.out.println(meta_data.toString());
        Film film = new Film(90, meta_data);

        FilmController.getInstance().create(film);

        for (Category category : categories) {
            CategoryController.getInstance().create(category);
        }
    }
}

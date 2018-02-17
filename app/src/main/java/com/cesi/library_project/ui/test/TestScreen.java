package com.cesi.library_project.ui.test;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.content.MainContent;
import com.cesi.library_project.ui.listeners.ICategoryClicked;
import com.cesi.library_project.ui.menu.CategoryMenu;
import com.cesi.library_project.ui.navbar.NavBar;
import org.eclipse.swt.widgets.Composite;

public class TestScreen implements IComponentProvider, ICategoryClicked {

    private CategoryMenu mMenu;
    private MainContent mMainContent;
    private NavBar mNavBar;

    public TestScreen() {

    }

    @Override
    public void implement(Composite composite) {

        // add navbar
        mNavBar = new NavBar (this);
        mNavBar.implement (composite);

        //and push a menu on their right
        mMenu = new CategoryMenu(this);
        mMenu.implement(composite);

        mMainContent = new MainContent();
        mMainContent.implement(composite);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onCategoryClicked(Category category) {
        mMainContent.onCategoryClicked(category);
    }
}

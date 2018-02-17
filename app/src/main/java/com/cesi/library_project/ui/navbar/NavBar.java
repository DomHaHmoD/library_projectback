package com.cesi.library_project.ui.navbar;


        import com.cesi.library_project.database.controllers.CategoryController;
        import com.cesi.library_project.database.models.Category;
        import com.cesi.library_project.ui.DisplayController;
        import com.cesi.library_project.ui.IComponentProvider;
        import com.cesi.library_project.ui.listeners.ICategoryClicked;
        import com.cesi.library_project.ui.menu.CategoryItem;
        import com.cesi.library_project.ui.test.TestScreen;
        import org.eclipse.swt.SWT;
        import org.eclipse.swt.layout.FillLayout;
        import org.eclipse.swt.layout.GridData;
        import org.eclipse.swt.layout.GridLayout;
        import org.eclipse.swt.layout.RowLayout;
        import org.eclipse.swt.widgets.Composite;
        import org.eclipse.swt.widgets.Label;
        import org.jetbrains.annotations.NotNull;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Represents the whole left menu
 */
public class NavBar implements IComponentProvider, ICategoryClicked {

    private GridLayout mGrid;
    private Composite mComposite;
    private ArrayList<IComponentProvider> mCategoriesItem;
    private TestScreen mParent;

    public NavBar(@NotNull TestScreen parent) {
        mParent = parent;
    }

    /**
     * For each Category from the database, add a new CategpryItem
     * and add it to the internal list of UI
     *
     * @param composite inject the view into it
     */
    @Override
    public void implement(Composite composite) {

        List<Category> list = CategoryController.getInstance().list();

        if (mGrid == null) {
            mGrid = new GridLayout(1, true);

            mComposite = new Composite(composite, SWT.PUSH);

            GridData data = new GridData();
            data.horizontalSpan = 3; // pour prendre toute la place en horizontal
            data.verticalAlignment = SWT.BEGINNING; // pour démarrer en haut à gauche
            data.horizontalAlignment = SWT.FILL; //
            mComposite.setLayoutData(data);
            mComposite.setLayout(mGrid);
            mComposite.setBackground(DisplayController.getInstance()
                    .getColor(255, 255, 0));
        }

        // add to put centered text in the navbar
        Label labeltext = new Label(mComposite, SWT.FILL);
        labeltext.setText("La bibliotheque de Babar");
        labeltext.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, true));


        //mCategoriesItem = new ArrayList<IComponentProvider>();

        /*for (Category category : list) {
            CategoryItem item = new CategoryItem(this, category);
            mCategoriesItem.add(item);
            item.implement(mComposite);
        }*/

    }

    /**
     * For each UI Element, dispose its ressources
     */
    @Override
    public void dispose() {
        for (IComponentProvider item : mCategoriesItem) {
            item.dispose();
        }
    }

    @Override
    public void onCategoryClicked(Category category) {
        mParent.onCategoryClicked(category);
    }
}

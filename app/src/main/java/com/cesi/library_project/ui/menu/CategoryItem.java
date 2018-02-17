package com.cesi.library_project.ui.menu;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.IComponentProvider;
import com.cesi.library_project.ui.navbar.NavBar;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a Menu Item
 */
public class CategoryItem implements IComponentProvider, MouseListener {

    private CategoryMenu mParent;
    private Category mCategory;
    private Button mLabel;

    public CategoryItem(@NotNull CategoryMenu parent, @NotNull Category category) {
        setCategory(category);
        setCategoryParent(parent);
    }

    public void setCategory(@NotNull Category category) {
        mCategory = category;

        if (mLabel != null) {
            mLabel.setText(mCategory.getName());
        }
    }

    public void setCategoryParent(@NotNull CategoryMenu category_menu) {
        mParent = category_menu;
    }

    public Category getCategory() {
        return mCategory;
    }

    /**
     * Creates the button and set its text to the category name
     *
     * @param composite inject the view into it
     */
    @Override
    public void implement(@NotNull Composite composite) {
        if (mLabel != null) mLabel.dispose();

        mLabel = new Button(composite, SWT.PUSH);

        mLabel.addMouseListener(this);


        if (mCategory != null) {
            mLabel.setText(mCategory.getName());
        }
    }

    @Override
    public void dispose() {
        mLabel.dispose();
    }

    @Override
    public void mouseDoubleClick(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDown(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseUp(MouseEvent mouseEvent) {
        mParent.onCategoryClicked(mCategory);
    }
}

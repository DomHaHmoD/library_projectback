package com.cesi.library_project.ui.content;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.IComponentProvider;
import com.sun.tools.javac.util.Name;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import org.jetbrains.annotations.NotNull;
import org.eclipse.swt.widgets.Text;


import javax.swing.*;

public class CategoryListContent implements IComponentProvider {
    private final String name;
    private Composite mChildComposite;
    private ScrolledComposite mScrollComposite;
    private Category category;
    private Label label;
    private Image imageofcategory;
    private String titles;


    public CategoryListContent(Category category) {
        this.category = category; // use to work with switchcase
        name = this.category.getName (); // use to work with switchcase
    }

    @Override
    public void implement(@NotNull Composite composite) {

        //proxy composite to display the internal component easily
        mScrollComposite = new ScrolledComposite (composite, SWT.V_SCROLL);
        mChildComposite = new Composite (mScrollComposite, SWT.NONE);

        RowLayout layout = new RowLayout (SWT.HORIZONTAL);
        layout.wrap = true;
        mChildComposite.setLayout (layout);

        mScrollComposite.setContent (mChildComposite);
        mScrollComposite.setExpandHorizontal (true);
        mScrollComposite.setExpandVertical (true);
        mScrollComposite.addControlListener (new ControlListener () {
            @Override
            public void controlMoved(ControlEvent controlEvent) {

            }

            // to control the windows by size
            @Override
            public void controlResized(ControlEvent controlEvent) {
                Rectangle r = mScrollComposite.getClientArea ();
                mScrollComposite.setMinSize (mChildComposite.computeSize (r.width, SWT.DEFAULT));
            }
        });
        mChildComposite.setBackground (DisplayController.getInstance ().getColor (200, 100, 100));

        /*Image imageofcategory = DisplayController.getInstance()
                .loadImage("/com/cesi/resources/book.png", 150);*/



        /*if (name.equals("Livre")) {
            Image imageofcategory = DisplayController.getInstance()
                    .loadImage("/com/cesi/resources/book.png", 150);
            } else if (name.equals("Film")) {
                    Image imageofcategory = DisplayController.getInstance()
                            .loadImage("/com/cesi/resources/heroes.png", 150);
                    } else if (name.equals("Musique")) {
                            Image imageofcategory = DisplayController.getInstance()
                                    .loadImage("/com/cesi/resources/screen.png", 150);
                            } else if (name.equals("Video")) {
                                    Image imageofcategory = DisplayController.getInstance()
                                            .loadImage("/com/cesi/resources/fusee.png", 150);
                                    }*/
        // switch to select the category (image)
        switch (name) {
            case "Livre":
                imageofcategory = DisplayController.getInstance ()
                        .loadImage ("/com/cesi/resources/livre.png", 150);
                break;
            case "Film":
                imageofcategory = DisplayController.getInstance ()
                        .loadImage ("/com/cesi/resources/video.png", 150);
                break;
            case "Musique":
                imageofcategory = DisplayController.getInstance ()
                        .loadImage ("/com/cesi/resources/music.png", 150);
                break;
            case "Jeu":
                imageofcategory = DisplayController.getInstance ()
                        .loadImage ("/com/cesi/resources/jeu.png", 150);
                break;
            case "Table":

                break;
            default:
                ;
                break;
        }

        if (name.equals ("tableau")) {
            Label label = new Label (mChildComposite, SWT.NONE);
            Table tabletest = new Table (mChildComposite, SWT.NONE);
            tabletest.setHeaderVisible(true);
            String[] titles = { "Col 1", "Col 2", "Col 3", "Col 4" };

            for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
                TableColumn column = new TableColumn(tabletest, SWT.NULL);
                column.setText(titles[loopIndex]);
            }

            for (int loopIndex = 0; loopIndex < 24; loopIndex++) {
                TableItem item = new TableItem(tabletest, SWT.NULL);
                item.setText("Item " + loopIndex);
                item.setText(0, "Item " + loopIndex);
                item.setText(1, "Yes");
                item.setText(2, "No");
                item.setText(3, "A table item");
            }

            for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
                tabletest.getColumn(loopIndex).pack();
            }

            tabletest.setBounds(25, 25, 220, 200);

            /*tabletest.addListener(SWT.Selection, new Listener() {
                public void handleEvent(Event event) {
                    if (event.detail == SWT.CHECK) {
                        text.setText("You checked " + event.item);
                    } else {
                        text.setText("You selected " + event.item);
                    }
                }
            });*/



        } else {
            int i = 0;
            while (i < 100) {
                Label label = new Label (mChildComposite, SWT.NONE);
                label.setImage (imageofcategory);
                i++;
            }

        }
    }


    @Override
    public void dispose() {
        mScrollComposite.dispose();
    }

    public void resize() {
        mChildComposite.layout();
        DisplayController.getInstance().layout(mChildComposite);
    }
}

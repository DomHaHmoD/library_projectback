package com.cesi.library_project.ui.content;

import com.cesi.library_project.database.models.Category;
import com.cesi.library_project.ui.DisplayController;
import com.cesi.library_project.ui.IComponentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.jetbrains.annotations.NotNull;

public class CategoryListContent implements IComponentProvider {
    private final String name;
    private Composite mChildComposite;
    private ScrolledComposite mScrollComposite;
    private Category category;
    private Label label;
    private Image imageofcategory;

    public CategoryListContent(Category category) {
        this.category = category;

        name = this.category.getName();
    }

    @Override
    public void implement(@NotNull Composite composite) {

        //proxy composite to display the internal component easily
        mScrollComposite = new ScrolledComposite(composite, SWT.V_SCROLL);
        mChildComposite = new Composite(mScrollComposite, SWT.NONE);

        RowLayout layout = new RowLayout(SWT.HORIZONTAL);
        layout.wrap = true;
        mChildComposite.setLayout(layout);

        mScrollComposite.setContent(mChildComposite);
        mScrollComposite.setExpandHorizontal(true);
        mScrollComposite.setExpandVertical(true);
        mScrollComposite.addControlListener(new ControlListener() {
            @Override
            public void controlMoved(ControlEvent controlEvent) {

            }
                    // to control the windows by size
            @Override
            public void controlResized(ControlEvent controlEvent) {
                Rectangle r = mScrollComposite.getClientArea();
                mScrollComposite.setMinSize(mChildComposite.computeSize(r.width, SWT.DEFAULT));
            }
        });
        mChildComposite.setBackground(DisplayController.getInstance().getColor(200,100,100));

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
            default:
                ;
                break;
        }


            int i = 0;
        while (i < 100) {
            Label label = new Label(mChildComposite, SWT.NONE);
            label.setImage(imageofcategory);
            i++;
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

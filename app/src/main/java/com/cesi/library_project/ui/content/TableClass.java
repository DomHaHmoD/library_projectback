package com.cesi.library_project.ui.content;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Table;


public class TableClass  {
    private final Composite mChildComposite;
    private Object TableClass;

    public TableClass (Composite composite) {
        /*Display display = new Display();
        Shell shell = new Shell(display);
        Label label = new Label (shell, SWT.NONE); // add to include
        shell.setSize(280, 300);*/

         mChildComposite = composite;

        //mChildComposite.setText("Table pour la bibliothèque");

        final Text text = new Text(mChildComposite, SWT.BORDER);
        text.setBounds(25, 240, 220, 25);

        Table table = new Table(mChildComposite, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL
                | SWT.H_SCROLL);
        table.setHeaderVisible(true);
        String[] titles = { "Titre", "Auteur", "Notation", "Origine" };

        for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
            TableColumn column = new TableColumn(table, SWT.NULL);
            column.setText(titles[loopIndex]);
        }

        for (int loopIndex = 0; loopIndex < 24; loopIndex++) {
            TableItem item = new TableItem(table, SWT.NULL);
            item.setText("Item " + loopIndex);
            item.setText(0, "Item " + loopIndex);
            item.setText(1, "Yes");
            item.setText(2, "No");
            item.setText(3, "A table item");
        }

        for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
            table.getColumn(loopIndex).pack();
        }

        table.setBounds(25, 25, 220, 200);

        table.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                if (event.detail == SWT.CHECK) {
                    text.setText("You checked " + event.item);
                } else {
                    text.setText("You selected " + event.item);
                }
            }
        });

        /*shell.open();
        while (!shell.isDisposed()) {
            if (!shell.readAndDispatch())
                shell.sleep();
        }
        shell.dispose();*/
    }


    public Object getTabList() {
        return TableClass;
    }

}

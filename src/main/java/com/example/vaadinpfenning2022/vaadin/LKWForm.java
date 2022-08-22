package com.example.vaadinpfenning2022.vaadin;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(layout = MainLayout.class)
@PageTitle("LKW Form | Vaadin Pfenning")
public class LKWForm extends FormLayout {

    TextField kenz = new TextField("Personalnummer");
    TextField marke = new TextField("Rewe Nummer");


    //ComboBox<Status> status = new ComboBox<>("Status");
    //ComboBox<Company> company = new ComboBox<>("Company");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");
    Button edit = new Button("Edit");




    public LKWForm() {
        addClassName("LKW-form");

        //company.setItems(companies);
        //company.setItemLabelGenerator(Company::getName);
        //status.setItems(statuses);
        //status.setItemLabelGenerator(Status::getName);

        add(kenz,marke,
                createButtonsLayout());
        configureLKWForm();
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close, edit);
    }

    private void configureLKWForm() {
        //form = new ContactForm(Collections.emptyList(), Collections.emptyList());
        setWidth("25em");

    }
}

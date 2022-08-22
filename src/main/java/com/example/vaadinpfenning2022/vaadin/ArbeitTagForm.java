package com.example.vaadinpfenning2022.vaadin;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


//@PageTitle("Arbeit Tag Form | Vaadin Pfenning")
public class ArbeitTagForm extends FormLayout {

    TextField Fahrer_id = new TextField("Personalnummer");
    TextField arbeitsbeginn = new TextField("Arbeitbegin");
    TextField arbeitsende = new TextField("Arbeitende");
    TextField kilometer = new TextField("Kilometer");
    TextField kilometer_Rewe = new TextField("REWE kilometer");
    TextField pause = new TextField("pause");
    TextField fuhrerbruch = new TextField("Fuhrerbruch");
    TextField unfall = new TextField("unfall");


    //ComboBox<Status> status = new ComboBox<>("Status");
    //ComboBox<Company> company = new ComboBox<>("Company");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");
    Button edit = new Button("Edit");




    public ArbeitTagForm() {
        addClassName("Arbeit-Tag-form");

        //company.setItems(companies);
        //company.setItemLabelGenerator(Company::getName);
        //status.setItems(statuses);
        //status.setItemLabelGenerator(Status::getName);

        add(Fahrer_id,arbeitsbeginn,arbeitsende,kilometer,kilometer_Rewe ,pause,fuhrerbruch ,unfall,
                createButtonsLayout());
        configureArbeitTagForm();
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close, edit);
    }

    private void configureArbeitTagForm() {
        //arbeitTagForm = new ArbeitTagForm();
        setWidth("25em");

    }
}

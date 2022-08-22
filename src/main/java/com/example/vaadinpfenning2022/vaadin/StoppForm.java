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
@PageTitle("Stopp Form | Vaadin Pfenning")
public class StoppForm extends FormLayout {

    TextField Tour_nr_Tour = new TextField("Tour_nr_Tour");
    TextField Tour_abfahrtLager = new TextField("Tour_abfahrtLagerr");
    TextField Markt_Liferung_stoppbegin = new TextField("Markt_Liferung_stoppbegin");
    TextField Markt_Liferung_Markt_id_markt = new TextField("Markt_Liferung_Markt_id_markt");


    //ComboBox<Status> status = new ComboBox<>("Status");
    //ComboBox<Company> company = new ComboBox<>("Company");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");
    Button edit = new Button("Edit");




    public StoppForm() {
        addClassName("stopp-form");

        //company.setItems(companies);
        //company.setItemLabelGenerator(Company::getName);
        //status.setItems(statuses);
        //status.setItemLabelGenerator(Status::getName);

        add(Tour_nr_Tour,
                Tour_abfahrtLager,
                Markt_Liferung_stoppbegin,
                Markt_Liferung_Markt_id_markt,
                createButtonsLayout());
        configureStoppForm();
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close, edit);
    }

    private void configureStoppForm() {
        //form = new ContactForm(Collections.emptyList(), Collections.emptyList());
        setWidth("25em");

    }
}

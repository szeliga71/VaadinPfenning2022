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
@PageTitle("Liferung Form | Vaadin Pfenning")
public class LiferungForm extends FormLayout {

    TextField Ware_id = new TextField("Ware_id");
    TextField Markt_Liferung_stoppbegin = new TextField("Markt_Liferung_stoppbegin");
    TextField Markt_Liferung_Markt_id_markt = new TextField("Markt_Liferung_Markt_id_markt");
    TextField menge = new TextField("menge");

    //ComboBox<Status> status = new ComboBox<>("Status");
    //ComboBox<Company> company = new ComboBox<>("Company");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");
    Button edit = new Button("Edit");




    public LiferungForm() {
        addClassName("fahrer-form");

        //company.setItems(companies);
        //company.setItemLabelGenerator(Company::getName);
        //status.setItems(statuses);
        //status.setItemLabelGenerator(Status::getName);

        add(Ware_id,Markt_Liferung_stoppbegin,Markt_Liferung_Markt_id_markt ,menge,
                createButtonsLayout());
        configureLiferungForm();
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close, edit);
    }

    private void configureLiferungForm() {
        //form = new ContactForm(Collections.emptyList(), Collections.emptyList());
        setWidth("25em");

    }
}

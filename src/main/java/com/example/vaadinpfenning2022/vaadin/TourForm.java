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
@PageTitle("Tour Form | Vaadin Pfenning")

public class TourForm extends FormLayout{

    TextField nrTour=new TextField("id Tour");
    TextField abfahrtLager=new TextField("abfahrtLager");
    TextField LKW_kenz=new TextField("LKW_kenz");
    TextField tourEnde=new TextField("tourEnde");
    TextField tour_kilometer=new TextField("tour_kilometer");
    TextField Arbeit_Tag_Fahrer_id=new TextField("Arbeit_Tag_Fahrer_id");
    TextField Arbeit_Tag_arbeitsbeginn=new TextField("Arbeit_Tag_arbeitsbeginn");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");
    Button edit = new Button("Edit");

    public TourForm() {
        addClassName("Tour-form");

        //company.setItems(companies);
        //company.setItemLabelGenerator(Company::getName);
        //status.setItems(statuses);
        //status.setItemLabelGenerator(Status::getName);

        add(nrTour,
                abfahrtLager,
                LKW_kenz,
                tourEnde,
                tour_kilometer,
                Arbeit_Tag_Fahrer_id,
                Arbeit_Tag_arbeitsbeginn,
                createButtonsLayout());

        configureTourForm();
    }
    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close, edit);
    }

    private void configureTourForm() {
        //form = new ContactForm(Collections.emptyList(), Collections.emptyList());
        setWidth("25em");

    }

}

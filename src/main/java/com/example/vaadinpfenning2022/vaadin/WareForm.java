package com.example.vaadinpfenning2022.vaadin;

import com.example.vaadinpfenning2022.model.Fahrer;
import com.example.vaadinpfenning2022.model.Ware;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;


public class WareForm extends FormLayout {

    private Ware ware;

    TextField id = new TextField("id");
    TextField bezeichnung = new TextField("bezeichnung");


    //ComboBox<Status> status = new ComboBox<>("Status");
    //ComboBox<Company> company = new ComboBox<>("Company");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");
    Button edit = new Button("Edit");


    Binder<Ware> binder = new BeanValidationBinder<>(Ware.class);

    public WareForm() {
        addClassName("Ware-form");
        binder.bindInstanceFields(this);
        //company.setItems(companies);
        //company.setItemLabelGenerator(Company::getName);
        //status.setItems(statuses);
        //status.setItemLabelGenerator(Status::getName);

        add(id,bezeichnung,
                createButtonsLayout());

        //configureWareForm();
    }

    public void setWare(Ware ware) {
        this.ware = ware;
        binder.readBean(ware);
    }
    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, ware)));
        close.addClickListener(event -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close, edit);
    }

   /* private void configureWareForm() {
        wareForm = new WareForm();
        setWidth("25em");

    }*/

    private void validateAndSave() {
        try {
            binder.writeBean(ware);
            fireEvent(new SaveEvent(this, ware));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

//=000=====

    //==========================================

    public static abstract class WareFormEvent extends ComponentEvent<WareForm> {
        private Ware ware;

        protected WareFormEvent(WareForm source, Ware ware) {
            super(source, false);
            this.ware= ware;
        }

        public Ware getWare() {
            return ware;
        }
    }

    public static class SaveEvent extends WareFormEvent {
        SaveEvent(WareForm source, Ware ware) {
            super(source, ware);
        }
    }

    public static class DeleteEvent extends WareFormEvent {
        DeleteEvent(WareForm source, Ware ware) {
            super(source, ware);
        }

    }

    public static class CloseEvent extends WareFormEvent {
        CloseEvent(WareForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener (Class < T > eventType,
                                                                   ComponentEventListener< T > listener){
        return getEventBus().addListener(eventType, listener);
    }
}


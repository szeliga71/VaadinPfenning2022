package com.example.vaadinpfenning2022.vaadin;


import com.example.vaadinpfenning2022.model.Fahrer;
import com.example.vaadinpfenning2022.model.Ware;
import com.example.vaadinpfenning2022.servis.FahrerServis;
import com.example.vaadinpfenning2022.servis.WareServis;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(layout = MainLayout.class)
@PageTitle("Ware List | Vaadin Pfenning")
public class WareList extends VerticalLayout {
    Grid<Ware> grid = new Grid<>(Ware.class);
    TextField filterText = new TextField();
    WareServis wareServis;
    WareForm wareForm;

    public WareList(WareServis wareServis) {
        this.wareServis = wareServis;
        addClassName("Ware-list");
        setSizeFull();
        configureGrid();
        configureWareForm();

        //add(getToolbar(), grid);
        add(getToolbar(), getContent());
        updateList();
        closeEditor();
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid,wareForm);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, wareForm);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    private void configureGrid() {
        grid.addClassNames("ware-grid");
        grid.setSizeFull();
        grid.setColumns("id");
        //grid.addColumn(contact -> contact.getStatus().getName()).setHeader("Status");
        //grid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event ->
                editWare(event.getValue()));
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by bezeichnung...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addWare = new Button("Add Ware");
        addWare.addClickListener(click -> addWare());
        Button deleteWare = new Button("Delete Ware");
        Button updateWare = new Button("Update Ware");

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addWare,
                deleteWare, updateWare);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
    public void editWare(Ware ware) {
        if (ware == null) {
            closeEditor();
        } else {
            wareForm.setWare(ware);
            wareForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        wareForm.setWare(null);
        wareForm.setVisible(false);
        removeClassName("editing");
    }

    private void addWare() {
        grid.asSingleSelect().clear();
        editWare(new Ware());
    }

    private void updateList() {
        grid.setItems(wareServis.findAllWare(filterText.getValue()));
    }

    private void configureWareForm() {
        wareForm = new WareForm();
        wareForm.setWidth("25em");
        wareForm.addListener(WareForm.SaveEvent.class, this::saveWare);
        wareForm.addListener(WareForm.DeleteEvent.class, this::deleteWare);
        wareForm.addListener(WareForm.CloseEvent.class, e -> closeEditor());
    }

    private void saveWare(WareForm.SaveEvent event) {
        wareServis.saveWare(event.getWare());
        updateList();
        closeEditor();
    }

    private void deleteWare(WareForm.DeleteEvent event) {
        wareServis.deleteWare(event.getWare());
        updateList();
        closeEditor();
    }
}

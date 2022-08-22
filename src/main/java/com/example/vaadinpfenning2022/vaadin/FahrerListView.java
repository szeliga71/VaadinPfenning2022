package com.example.vaadinpfenning2022.vaadin;


import com.example.vaadinpfenning2022.model.Fahrer;
import com.example.vaadinpfenning2022.servis.FahrerServis;
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
@PageTitle("Fahrer | Vaadin Pfenning")
public class FahrerListView extends VerticalLayout {
    Grid<Fahrer> grid = new Grid<>(Fahrer.class);
    TextField filterText = new TextField();
    FahrerServis fahrerServis;
    FahrerForm fahrerForm;

    public FahrerListView(FahrerServis fahrerServis) {
        this.fahrerServis = fahrerServis;
        addClassName("Fahrer-list-view");
        setSizeFull();
        configureGrid();
        configureFahrerForm();

        //add(getToolbar(), grid);
        add(getToolbar(), getContent());
        updateList();
        closeEditor();
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid,fahrerForm);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, fahrerForm);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    private void configureGrid() {
        grid.addClassNames("fahrer-grid");
        grid.setSizeFull();
        grid.setColumns("id", "id_pf", "id_rewe", "name", "vorname");
        //grid.addColumn(contact -> contact.getStatus().getName()).setHeader("Status");
        //grid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event ->
                editFahrer(event.getValue()));
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addFahrer = new Button("Add Fahrer");
        addFahrer.addClickListener(click -> addFahrer());
        Button deleteFahrer = new Button("Delete Fahrer");
        Button updateFahrer = new Button("Update Fahrer");

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addFahrer,
                deleteFahrer, updateFahrer);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
    public void editFahrer(Fahrer fahrer) {
        if (fahrer == null) {
            closeEditor();
        } else {
            fahrerForm.setFahrer(fahrer);
            fahrerForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        fahrerForm.setFahrer(null);
        fahrerForm.setVisible(false);
        removeClassName("editing");
    }

    private void addFahrer() {
        grid.asSingleSelect().clear();
        editFahrer(new Fahrer());
    }

    private void updateList() {
        grid.setItems(fahrerServis.findAllFahrers(filterText.getValue()));
    }

    private void configureFahrerForm() {
        fahrerForm = new FahrerForm();
        fahrerForm.setWidth("25em");
        fahrerForm.addListener(FahrerForm.SaveEvent.class, this::saveFahrer);
        fahrerForm.addListener(FahrerForm.DeleteEvent.class, this::deleteFahrer);
        fahrerForm.addListener(FahrerForm.CloseEvent.class, e -> closeEditor());
    }

    private void saveFahrer(FahrerForm.SaveEvent event) {
        fahrerServis.saveFahrer(event.getFahrer());
        updateList();
        closeEditor();
    }

    private void deleteFahrer(FahrerForm.DeleteEvent event) {
        fahrerServis.deleteFahrer(event.getFahrer());
        updateList();
        closeEditor();
    }
}
package com.example.vaadinpfenning2022.vaadin;

import com.example.vaadinpfenning2022.model.ArbeitTag;
import com.example.vaadinpfenning2022.model.Fahrer;
import com.example.vaadinpfenning2022.servis.ArbeitTagServis;
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
@PageTitle("Arbeit Tag List | Vaadin Pfenning")
public class ArbeitTagList extends VerticalLayout {


    Grid<ArbeitTag> grid = new Grid<>(ArbeitTag.class);
    TextField filterText1 = new TextField();
    TextField filterText2 = new TextField();
     TextField filterText3 = new TextField();
     ArbeitTagServis arbeitTagServis;

     ArbeitTagForm arbeitTagForm;

    public ArbeitTagList(ArbeitTagServis arbeitTagServis) {
        this.arbeitTagServis=arbeitTagServis;
        addClassName("Arbeit-Tag-list-view");
        setSizeFull();
        configureGrid();

        //add(getToolbar(), grid);
        add(getToolbar(), getContent());
       updateList();

    }
    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid);
        content.setFlexGrow(2, grid);
        //content.setFlexGrow(1, arbeitTagForm);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }
    private void configureGrid() {
        grid.addClassNames("arbeitTag-grid");
        grid.setSizeFull();
        grid.setColumns("arbeitsbeginn","arbeitsende","kilometer","kilometer_Rewe","pause","fuhrerbruch","unfall");

        //grid.addColumn(contact -> contact.getStatus().getName()).setHeader("Status");
        //grid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolbar() {
        filterText1.setPlaceholder("Filter by name...");
        filterText1.setClearButtonVisible(true);
        filterText2.setPlaceholder("Filter by arbeitsbegin von...");
        filterText2.setClearButtonVisible(true);
        filterText3.setPlaceholder("Filter by arbeitsbegin bis...");
        filterText3.setClearButtonVisible(true);
        filterText1.setValueChangeMode(ValueChangeMode.LAZY);
        filterText1.addValueChangeListener(e -> updateList());

        Button addArbeitTagButton = new Button("Add Arbeit Tag");

        HorizontalLayout toolbar = new HorizontalLayout(filterText1,filterText2,filterText3, addArbeitTagButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void updateList() {

        grid.setItems(arbeitTagServis.findAllArbeitTages(filterText1.getValue()));
        //grid.setItems(arbeitTagServis.findAllArbeitTages(filterText2.getValue()));
        //grid.setItems(arbeitTagServis.findAllArbeitTages(filterText3.getValue()));
    }
}
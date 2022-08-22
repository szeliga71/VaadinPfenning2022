package com.example.vaadinpfenning2022.vaadin;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Tlo")
@Route(value = "",layout = MainLayout.class)
public class Tlo extends VerticalLayout {


    public Tlo() {

        setSpacing(false);

        Image img = new Image("/images/pfenning111.png", "placeholder plant");
        img.setWidth("100%");
        add(img);

        //add(new H2("This place intentionally left empty"));
       // add(new Paragraph("It’s a place where you can grow your own UI 🤗"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }
}
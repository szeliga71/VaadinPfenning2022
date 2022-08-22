package com.example.vaadinpfenning2022.vaadin;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;

//@Route(value = "MainLayout")
//@PageTitle("Main Layout | Vaadin Pfenning")
public class MainLayout extends AppLayout {


    //private final SecurityService securityService;

    //public MainLayout(SecurityService securityService) {

        //this.securityService = securityService;
       // createHeader();
        //createDrawer();
   // }

    public MainLayout(){



        createHeader();
        createDrawer();
    }

    private void createHeader() {

        //setSpacing(false);

        //Image img1 = new Image("/images/loggo.png", "placeholder plant");
        //img1.setWidth("10%");


        H1 logo = new H1("pfenning");
        logo.addClassNames("text-l", "m-m");


        Button logout = new Button("Log out");//, e -> securityService.logout());

        HorizontalLayout header = new HorizontalLayout(
                new DrawerToggle(),
                logo,logout
        );

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        header.expand(logo);

        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);

    }

    private void createDrawer() {
       /* RouterLink listLink0 = new RouterLink("Arbeit Tag List", ArbeitTagList.class);
        listLink0.setHighlightCondition(HighlightConditions.sameLocation());*/

       /* RouterLink listLink1 = new RouterLink("Fahrer List", FahrerListView.class);
        listLink1.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink2 = new RouterLink("Liferung Form", LiferungForm.class);
        listLink2.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink3 = new RouterLink("LKW Form", LKWForm.class);
        listLink3.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink4 = new RouterLink("Markt Form", MarktForm.class);
        listLink4.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink5 = new RouterLink("Markt Liferung Form", MarktLiferungForm.class);
        listLink5.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink6 = new RouterLink("Stopp Form", StoppForm.class);
        listLink6.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink7 = new RouterLink("Tour Form", TourForm.class);
        listLink7.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink8 = new RouterLink("Ware Form", WareForm.class);
        listLink8.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLinkT = new RouterLink("Tlo", Tlo.class);
        listLinkT.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink10 = new RouterLink("Arbeit Tag Form", ArbeitTagForm.class);
        listLink0.setHighlightCondition(HighlightConditions.sameLocation());*/

        /*RouterLink listLink12 = new RouterLink("Ware List", WareList.class);
        listLink12.setHighlightCondition(HighlightConditions.sameLocation());*/

       // RouterLink listLink11 = new RouterLink("Fahrer Form", FahrerForm.class);
        //listLink1.setHighlightCondition(HighlightConditions.sameLocation());
        RouterLink listLink1 = new RouterLink("Fahrer List", FahrerListView.class);
        listLink1.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink0 = new RouterLink("Arbeit Tag List", ArbeitTagList.class);
        listLink0.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLink12 = new RouterLink("Ware List", WareList.class);
        listLink12.setHighlightCondition(HighlightConditions.sameLocation());

        RouterLink listLinkT = new RouterLink("Tlo", Tlo.class);
        listLinkT.setHighlightCondition(HighlightConditions.sameLocation());

       //addToDrawer(new VerticalLayout(listLink0,listLink10,listLink1,/*listLink11*/listLink2,listLink3 ,listLink4,listLink5,listLink6,listLink7/*listLink8listLink12*/,listLinkT
               addToDrawer(new VerticalLayout(listLink1,listLink12,listLink0,
                       listLinkT));

       /* addToDrawer(new VerticalLayout(
                listLink,
                new RouterLink("Tour Form", TourForm.class)
        ));
        addToDrawer(new VerticalLayout(
                listLink,
                new RouterLink("ArbeitTag Form", ArbeitTagForm.class)
        ));

        addToDrawer(new VerticalLayout
                (
                listLink,
                new RouterLink("ArbeTag Form", ArbeitTagForm.class)
        ));*/
    }


}

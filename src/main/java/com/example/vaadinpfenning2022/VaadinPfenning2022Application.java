package com.example.vaadinpfenning2022;

import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
//@Theme(value = "flowcrmtutorial")
//@PWA(name = "Flow CRM Tutorial", shortName = "Flow CRM Tutorial", offlineResources = {})

public class VaadinPfenning2022Application {

    public static void main(String[] args) {
        SpringApplication.run(VaadinPfenning2022Application.class, args);
    }

}

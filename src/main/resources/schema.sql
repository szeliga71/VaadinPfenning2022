CREATE TABLE Fahrer
( id BIGINT AUTO_INCREMENT primary key,
  id_pf  integer NOT NULL,
  id_rewe integer  NOT NULL,
  name varchar(50)  NOT NULL,
  vorname varchar(50)  NOT NULL

);

CREATE TABLE Arbeit_Tag (


                             Fahrer_id BIGINT  NOT NULL,
                             arbeitsbeginn timestamp  NOT NULL,
                             arbeitsende timestamp  NOT NULL,
                             kilometer integer  NOT NULL,
                             kilometer_Rewe integer  NOT NULL,
                             pause integer  NOT NULL,
                             fuhrerbruch varchar(4)  NOT NULL,
                             unfall varchar(4)  NOT NULL,
                             PRIMARY KEY (Fahrer_id,arbeitsbeginn)

) ;

CREATE TABLE LKW (
                     kenz varchar(20)  PRIMARY KEY ,
                     marke varchar(20)  NOT NULL,
                     nr_rewe integer  NOT NULL

) ;

CREATE TABLE Ware (
                       id BIGINT   AUTO_INCREMENT primary key,
                       bezeichnung varchar(30)  NOT NULL

) ;

CREATE TABLE Markt (
                       id_markt integer  PRIMARY KEY ,
                       adres varchar (400)not null

) ;

CREATE TABLE Liferung (
                                Ware_id integer  not null,
                                Markt_Liferung_stoppbegin timestamp  not null,
                                Markt_Liferung_Markt_id_markt varchar(10)  not null,
                                menge integer  NOT NULL,
                                PRIMARY KEY(Ware_id,Markt_Liferung_stoppbegin,Markt_Liferung_Markt_id_markt)

) ;
-- Table: Markt_Dostawa
CREATE TABLE Markt_Liferung (
                               Markt_id_markt varchar(10)  not null,
                               stoppbegin timestamp  not null,
                               stoppende timestamp  NOT NULL,
                                   PRIMARY KEY(Markt_id_markt,stoppbegin)
) ;

CREATE TABLE Stopp (
                       Tour_nr_Tour varchar(10)  not null,
                       Tour_abfahrtLager timestamp  not null,
                       Markt_Liferung_stoppbegin timestamp  not null,
                       Markt_Liferung_Markt_id_markt varchar(10)  not null,
                       PRIMARY KEY(Tour_nr_Tour,Tour_abfahrtLager,Markt_Liferung_stoppbegin,Markt_Liferung_Markt_id_markt)

) ;

CREATE TABLE Tour (
                      nr_Tour varchar(10) not null,
                      abfahrtLager timestamp  not null ,
                      LKW_kenz varchar(20)  NOT NULL,
                      tourEnde timestamp  NOT NULL,
                      tour_kilometer integer  NOT NULL,
                      Arbeit_Tag_Fahrer_id integer NOT NULL,
                      Arbeit_Tag_arbeitsbeginn timestamp NOT NULL,
                      PRIMARY KEY( nr_Tour,abfahrtLager)

) ;

-- Reference: Dzien_pracy_Pracownik (table: Dzien_pracy)
ALTER TABLE Arbeit_Tag ADD CONSTRAINT Arbeit_Tag_Fahrer
    FOREIGN KEY (Fahrer_id)
        REFERENCES Fahrer (id);

ALTER TABLE Liferung ADD CONSTRAINT Dostawa_towaru_Markt_Dostawa
    FOREIGN KEY (Markt_Liferung_Markt_id_markt,Markt_Liferung_stoppbegin)
        REFERENCES Markt_Liferung (Markt_id_markt,stoppbegin);

-- Reference: Dostawa_towaru_Towar (table: Dostawa_towaru)
ALTER TABLE Liferung ADD CONSTRAINT Liferung_Ware
    FOREIGN KEY (Ware_id)
        REFERENCES Ware (id);



-- Reference: Markt_Dostawa_Markt (table: Markt_Dostawa)
ALTER TABLE Markt_Liferung ADD CONSTRAINT Markt_Liferung_Markt
    FOREIGN KEY (Markt_id_markt)
        REFERENCES Markt (id_markt);

-- Reference: Sklepy_w_Turze_Tura (table: Stops)
ALTER TABLE Stopp ADD CONSTRAINT Stopp_Tour
    FOREIGN KEY (Tour_nr_Tour,Tour_abfahrtLager)
        REFERENCES Tour (nr_Tour,abfahrtLager);

-- Reference: Stops_Markt_Dostawa (table: Stops)
ALTER TABLE Stopp ADD CONSTRAINT Stopp_Markt_Liferung
    FOREIGN KEY (Markt_Liferung_stoppbegin,Markt_Liferung_Markt_id_markt)
        REFERENCES Markt_Liferung (stoppbegin,Markt_id_markt);

-- Reference: Tura_Dzien_pracy (table: Tura)
ALTER TABLE Tour ADD CONSTRAINT Tour_Arbeit_Tag
    FOREIGN KEY (Arbeit_Tag_Fahrer_id,Arbeit_Tag_arbeitsbeginn)
        REFERENCES Arbeit_Tag (Fahrer_id,arbeitsbeginn);

-- Reference: Tura_LKW (table: Tura)
ALTER TABLE Tour ADD CONSTRAINT Tour_LKW
    FOREIGN KEY (LKW_kenz)
        REFERENCES LKW (kenz);
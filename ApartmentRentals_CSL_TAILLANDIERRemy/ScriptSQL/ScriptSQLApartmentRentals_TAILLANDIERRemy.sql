CREATE TABLE Apartment_Buildings(
    building_id INTEGER NOT NULL,
    building_short_name CHAR(15),
    building_full_name VARCHAR(80) NOT NULL,
    building_description VARCHAR(255),
    building_address VARCHAR(255) NOT NULL,
    building_manager VARCHAR(50) NOT NULL,
    building_phone VARCHAR(80) NOT NULL,
    other_building_details VARCHAR(255),
    CONSTRAINT pk_building_id_Apartment_Buildings PRIMARY KEY(building_id)
);

INSERT INTO Apartment_Buildings VALUES(1, null, 'Le Garden', null, 'Avenue De Trivaux, 92190 Meudon', 'André GARCIA', '0172614711', null);
INSERT INTO Apartment_Buildings VALUES(2, null, 'Les Terrasses d''Hélène', null, 'Rue Hélène Berteaux, 95400 Villiers-le-Bel', 'Arthur DUPOND', '0141727374', null);

/************************************/
/************************************/

CREATE TABLE Ref_Apartment_Facilities(
    facility_code CHAR(15) NOT NULL,
    facility_description VARCHAR(255),
    CONSTRAINT pk_facility_code_Ref_Apartment_Facilities PRIMARY KEY(facility_code)
);
INSERT INTO Ref_Apartment_Facilities VALUES('facility01', 'Broadband');
INSERT INTO Ref_Apartment_Facilities VALUES('facility02', 'WIFI');
INSERT INTO Ref_Apartment_Facilities VALUES('facility03', 'Canal+');
INSERT INTO Ref_Apartment_Facilities VALUES('facility04', 'Bein Sport');

/************************************/
/************************************/

CREATE TABLE Ref_Apartment_Types(
    apt_type_code CHAR(15) NOT NULL,
    apt_type_description VARCHAR(255),
    CONSTRAINT pk_apt_type_code_Ref_Apartment_Types PRIMARY KEY(apt_type_code)
);

INSERT INTO Ref_Apartment_Types VALUES('apttype01', 'Studio');
INSERT INTO Ref_Apartment_Types VALUES('apttype02', 'Duplex');

/************************************/
/************************************/

CREATE TABLE Ref_Booking_Status(
    booking_status_code CHAR(15) NOT NULL,
    booking_status_description VARCHAR(255),
    CONSTRAINT pk_booking_status_code_Ref_Booking_Status PRIMARY KEY(booking_status_code)
);

INSERT INTO Ref_Booking_Status VALUES('bkgstatut01', 'Confirmer');
INSERT INTO Ref_Booking_Status VALUES('bkgstatut02', 'Provisoire');
INSERT INTO Ref_Booking_Status VALUES('bkgstatut03', 'Annuler');

/************************************/
/************************************/

CREATE TABLE Guests(
    guest_id INTEGER NOT NULL,
    gender_code CHAR(1) NOT NULL,
    guest_first_name VARCHAR(80) NOT NULL,
    guest_last_name VARCHAR(80) NOT NULL,
    date_of_birth CHAR(15) NOT NULL,
    other_guest_details VARCHAR(255),
    CONSTRAINT pk_guest_id_Guests PRIMARY KEY(guest_id),
    CONSTRAINT Guests_check CHECK(gender_code = 'M' OR gender_code = 'F' OR gender_code = 'U')
);

INSERT INTO Guests VALUES(1, 'M', 'Lucas', 'Perez', '25/06/1990', null);
INSERT INTO Guests VALUES(2, 'F', 'Clara', 'Perez', '20/11/1990', null);
INSERT INTO Guests VALUES(3, 'F', 'Laura', 'Perez', '01/01/2017', null);

/************************************/
/************************************/
CREATE TABLE Apartments(
    apt_id INTEGER NOT NULL,
    building_id INTEGER NOT NULL,
    apt_type_code CHAR(15) NOT NULL,
    apt_number CHAR(10) NOT NULL,
    bathroom_count INTEGER NOT NULL,
    bedroom_count INTEGER NOT NULL,
    room_count CHAR(5) NOT NULL,
    other_apartment_details VARCHAR(255),
    CONSTRAINT pk_apt_id_Apartments PRIMARY KEY(apt_id),
    CONSTRAINT fk_building_id_Apartments FOREIGN KEY(building_id) REFERENCES Apartment_Buildings(building_id) ON DELETE CASCADE,
    CONSTRAINT fk_apt_type_code_Apartments FOREIGN KEY(apt_type_code) REFERENCES Ref_Apartment_Types(apt_type_code)  ON DELETE CASCADE  
);

INSERT INTO Apartments VALUES(1, 1, 'apttype02', 'A1', 1, 3,'6', null);
INSERT INTO Apartments VALUES(2, 1, 'apttype01', 'B1', 1, 1, '2', null);

/************************************/
/************************************/

CREATE TABLE Apartment_Bookings(
    apt_booking_id INTEGER NOT NULL,
    apt_id INTEGER NOT NULL,
    guest_id INTEGER NOT NULL,
    booking_status_code CHAR(15) NOT NULL,
    booking_start_date CHAR(15) NOT NULL,
    booking_end_date CHAR(15) NOT NULL,
    other_booking_details VARCHAR(255),
    CONSTRAINT pk_apt_booking_id_Apartment_Bookings PRIMARY KEY(apt_booking_id),
    CONSTRAINT fk_apt_id_Apartment_Bookings FOREIGN KEY(apt_id) REFERENCES Apartments(apt_id) ON DELETE CASCADE,
    CONSTRAINT fk_guest_id_Apartment_Bookings FOREIGN KEY(guest_id) REFERENCES Guests(guest_id) ON DELETE CASCADE,
    CONSTRAINT fk_booking_status_code_Apartment_Bookings FOREIGN KEY(booking_status_code) REFERENCES Ref_Booking_Status(booking_status_code) ON DELETE CASCADE    
);

INSERT INTO Apartment_Bookings VALUES(1, 1, 1, 'bkgstatut01', '16/07/2019', '30/07/2023', null);
INSERT INTO Apartment_Bookings VALUES(2, 1, 2, 'bkgstatut01', '16/07/2019', '30/07/2023', null);
INSERT INTO Apartment_Bookings VALUES(3, 1, 3, 'bkgstatut01', '16/07/2019', '30/07/2023', null);

/************************************/
/************************************/
CREATE TABLE View_Unit_Status(
    status_date CHAR(15) NOT NULL,
    apt_id INTEGER NOT NULL,
    apt_booking_id INTEGER NOT NULL,
    available_yn CHAR(1) NOT NULL,
    CONSTRAINT pk_status_date_View_Unit_Status PRIMARY KEY(status_date),
    CONSTRAINT fk_apt_id_View_Unit_Status FOREIGN KEY(apt_id) REFERENCES Apartments(apt_id) ON DELETE CASCADE,
    CONSTRAINT fk_apt_booking_id_View_Unit_Status FOREIGN KEY(apt_booking_id) REFERENCES Apartment_Bookings(apt_booking_id) ON DELETE CASCADE,
    CONSTRAINT View_Unit_Status_check CHECK(available_yn = '0' OR available_yn = '1')
);

INSERT INTO View_Unit_Status VALUES('17/07/2019', 1, 1, '1');
/************************************/
/************************************/
CREATE TABLE Apartment_Facilities(
    apt_id INTEGER NOT NULL,
    facility_code CHAR(15) NOT NULL,
    CONSTRAINT pk_Apartment_Facilities PRIMARY KEY(apt_id, facility_code),
    CONSTRAINT fk_apt_id_Apartment_Facilities FOREIGN KEY(apt_id) REFERENCES Apartments(apt_id) ON DELETE CASCADE,
    CONSTRAINT fk_facility_code_View_Unit_Status FOREIGN KEY(facility_code) REFERENCES Ref_Apartment_Facilities(facility_code) ON DELETE CASCADE
);

INSERT INTO Apartment_Facilities VALUES(1, 'facility02');
INSERT INTO Apartment_Facilities VALUES(1, 'facility03');


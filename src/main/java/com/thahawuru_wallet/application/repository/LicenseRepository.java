package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<License,Long> {

}
//
//    CREATE TABLE licenses (
//        license_number VARCHAR(50) PRIMARY KEY,
//    identity_number VARCHAR(50),
//    name VARCHAR(100),
//    living_address VARCHAR(255),
//    birth_date TIMESTAMP,
//    issued_date TIMESTAMP,
//    expiry_date TIMESTAMP,
//    blood_group VARCHAR(3),
//    vehicles_allowed TEXT[],
//    document TEXT
//);



//
//    INSERT INTO licenses (
//        license_number,
//        identity_number,
//        name,
//        living_address,
//        birth_date,
//        issued_date,
//        expiry_date,
//        blood_group,
//        vehicles_allowed,
//        document
//        ) VALUES
//    ('LIC001', 'ID001', 'John Doe', 'Address 1', TO_TIMESTAMP(946684800000 / 1000), TO_TIMESTAMP(1622547800000 / 1000), TO_TIMESTAMP(1672531200000 / 1000), 'A+', ARRAY['Car', 'Bike'], 'Document 1'),
//            ('LIC002', 'ID002', 'Jane Smith', 'Address 2', TO_TIMESTAMP(946684800000 / 1000), TO_TIMESTAMP(1622547800000 / 1000), TO_TIMESTAMP(1672531200000 / 1000), 'B+', ARRAY['Truck', 'Bus'], 'Document 2'),
//            ('LIC003', 'ID003', 'Jane Smith', 'Address 3', TO_TIMESTAMP(9464484800000 / 1000), TO_TIMESTAMP(1622533800000 / 1000), TO_TIMESTAMP(1679931200000 / 1000), 'B+', ARRAY['Car', 'Bus'], 'Document 2'),
//            ('LIC004', 'ID004', 'Alice Johnson', 'Address 4', TO_TIMESTAMP(800000000000 / 1000), TO_TIMESTAMP(1609459200000 / 1000), TO_TIMESTAMP(1672531200000 / 1000), 'O-', ARRAY['Bike'], 'Document 3'),
//            ('LIC005', 'ID005', 'Bob Brown', 'Address 5', TO_TIMESTAMP(1234567890000 / 1000), TO_TIMESTAMP(1622547800000 / 1000), TO_TIMESTAMP(1700000000000 / 1000), 'AB+', ARRAY['Car'], 'Document 4'),
//            ('LIC006', 'ID006', 'Charlie Davis', 'Address 6', TO_TIMESTAMP(987654321000 / 1000), TO_TIMESTAMP(1612137600000 / 1000), TO_TIMESTAMP(1672531200000 / 1000), 'A-', ARRAY['Truck'], 'Document 5'),
//            ('LIC007', 'ID007', 'Diana Evans', 'Address 7', TO_TIMESTAMP(1356998400000 / 1000), TO_TIMESTAMP(1622547800000 / 1000), TO_TIMESTAMP(1683033600000 / 1000), 'B-', ARRAY['Bus'], 'Document 6'),
//            ('LIC008', 'ID008', 'Ethan Foster', 'Address 8', TO_TIMESTAMP(1596240000000 / 1000), TO_TIMESTAMP(1612137600000 / 1000), TO_TIMESTAMP(1682531200000 / 1000), 'O+', ARRAY['Car', 'Truck'], 'Document 7'),
//            ('LIC009', 'ID009', 'Fiona Green', 'Address 9', TO_TIMESTAMP(946684800000 / 1000), TO_TIMESTAMP(1596240000000 / 1000), TO_TIMESTAMP(1672531200000 / 1000), 'AB-', ARRAY['Bike', 'Bus'], 'Document 8'),
//            ('LIC010', 'ID010', 'George Harris', 'Address 10', TO_TIMESTAMP(1293840000000 / 1000), TO_TIMESTAMP(1622547800000 / 1000), TO_TIMESTAMP(1672531200000 / 1000), 'A+', ARRAY['Car', 'Bus'], 'Document 9');

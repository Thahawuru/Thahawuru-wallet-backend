package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<License,Long> {

}


//    INSERT INTO licenses (license_number, identity_id, name, living_address, birth_date, issued_date, expiry_date, blood_group, vehicles_allowed, document)
//    VALUES
//            ('LN001', 'ID001', 'John Doe', '1234 Elm St', '1985-05-15', '2022-01-01', '2027-01-01', 'A+', 'Car,Bike', 'doc1.pdf'),
//('LN002', 'ID002', 'Jane Smith', '5678 Oak St', '1990-07-22', '2022-02-01', '2027-02-01', 'B+', 'Car', 'doc2.pdf'),
//        ('LN003', 'ID003', 'Michael Johnson', '9101 Pine St', '1982-10-11', '2022-03-01', '2027-03-01', 'O+', 'Truck,Car', 'doc3.pdf'),
//        ('LN004', 'ID004', 'Emily Davis', '1122 Maple St', '1995-01-25', '2022-04-01', '2027-04-01', 'AB+', 'Bike,Car', 'doc4.pdf'),
//        ('LN005', 'ID005', 'Christopher Brown', '1314 Cedar St', '1988-08-17', '2022-05-01', '2027-05-01', 'A-', 'Car', 'doc5.pdf'),
//        ('LN006', 'ID006', 'Amanda Wilson', '1516 Birch St', '1992-03-19', '2022-06-01', '2027-06-01', 'B-', 'Car,Bike,Truck', 'doc6.pdf'),
//        ('LN007', 'ID007', 'Matthew Martinez', '1718 Walnut St', '1980-12-12', '2022-07-01', '2027-07-01', 'O-', 'Car', 'doc7.pdf'),
//        ('LN008', 'ID008', 'Jessica Garcia', '1920 Spruce St', '1997-04-14', '2022-08-01', '2027-08-01', 'AB-', 'Bike', 'doc8.pdf'),
//        ('LN009', 'ID009', 'Joshua Hernandez', '2122 Willow St', '1993-06-18', '2022-09-01', '2027-09-01', 'A+', 'Car', 'doc9.pdf'),
//        ('LN010', 'ID010', 'Megan Lee', '2324 Cypress St', '1991-09-29', '2022-10-01', '2027-10-01', 'B+', 'Truck', 'doc10.pdf'),
//        ('LN011', 'ID011', 'Daniel Gonzalez', '2526 Palm St', '1987-11-05', '2022-11-01', '2027-11-01', 'O+', 'Bike,Car', 'doc11.pdf'),
//        ('LN012', 'ID012', 'Sarah Perez', '2728 Ash St', '1994-02-15', '2022-12-01', '2027-12-01', 'AB+', 'Car', 'doc12.pdf'),
//        ('LN013', 'ID013', 'Andrew White', '2930 Fir St', '1989-08-23', '2023-01-01', '2028-01-01', 'A-', 'Car,Bike', 'doc13.pdf'),
//        ('LN014', 'ID014', 'Laura Thompson', '3132 Holly St', '1986-03-11', '2023-02-01', '2028-02-01', 'B-', 'Car', 'doc14.pdf'),
//        ('LN015', 'ID015', 'Ethan Anderson', '3334 Cherry St', '1998-05-27', '2023-03-01', '2028-03-01', 'O-', 'Truck,Car', 'doc15.pdf'),
//        ('LN016', 'ID016', 'Hannah Robinson', '3536 Poplar St', '1990-12-02', '2023-04-01', '2028-04-01', 'AB-', 'Bike', 'doc16.pdf'),
//        ('LN017', 'ID017', 'Mason Clark', '3738 Sycamore St', '1995-09-15', '2023-05-01', '2028-05-01', 'A+', 'Car', 'doc17.pdf'),
//        ('LN018', 'ID018', 'Sophia Lewis', '3940 Magnolia St', '1992-01-20', '2023-06-01', '2028-06-01', 'B+', 'Car,Bike', 'doc18.pdf'),
//        ('LN019', 'ID019', 'Olivia Allen', '4142 Hickory St', '1985-11-17', '2023-07-01', '2028-07-01', 'O+', 'Truck', 'doc19.pdf'),
//        ('LN020', 'ID020', 'James King', '4344 Maple St', '1993-02-21', '2023-08-01', '2028-08-01', 'AB+', 'Car,Bike', 'doc20.pdf');

package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<License,Long> {

}

//
//INSERT INTO licenses (
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
//('LN001', 'ID001', 'John Doe', '123 Main St', '1990-01-01', '2020-01-01', '2030-01-01', 'O+', 'Car,Bike', 'doc01.pdf'),
//        ('LN002', 'ID002', 'Jane Smith', '456 Elm St', '1991-02-02', '2021-02-02', '2031-02-02', 'A-', 'Bike', 'doc02.pdf'),
//        ('LN003', 'ID003', 'Mike Johnson', '789 Oak St', '1992-03-03', '2022-03-03', '2032-03-03', 'B+', 'Car', 'doc03.pdf'),
//        ('LN004', 'ID004', 'Emily Davis', '101 Pine St', '1993-04-04', '2023-04-04', '2033-04-04', 'AB+', 'Car,Truck', 'doc04.pdf'),
//        ('LN005', 'ID005', 'Chris Brown', '202 Maple St', '1994-05-05', '2024-05-05', '2034-05-05', 'B-', 'Truck', 'doc05.pdf'),
//        ('LN006', 'ID006', 'Jessica White', '303 Birch St', '1995-06-06', '2025-06-06', '2035-06-06', 'A+', 'Car,Bike', 'doc06.pdf'),
//        ('LN007', 'ID007', 'Daniel Harris', '404 Cedar St', '1996-07-07', '2026-07-07', '2036-07-07', 'O-', 'Bike', 'doc07.pdf'),
//        ('LN008', 'ID008', 'Sarah Wilson', '505 Spruce St', '1997-08-08', '2027-08-08', '2037-08-08', 'AB-', 'Car', 'doc08.pdf'),
//        ('LN009', 'ID009', 'David Martinez', '606 Poplar St', '1998-09-09', '2028-09-09', '2038-09-09', 'O+', 'Car,Bike,Truck', 'doc09.pdf'),
//        ('LN010', 'ID010', 'Ashley Clark', '707 Willow St', '1999-10-10', '2029-10-10', '2039-10-10', 'A-', 'Bike,Truck', 'doc10.pdf'),
//        ('LN011', 'ID011', 'Matthew Lewis', '808 Ash St', '1988-11-11', '2018-11-11', '2028-11-11', 'B+', 'Car', 'doc11.pdf'),
//        ('LN012', 'ID012', 'Olivia Walker', '909 Redwood St', '1989-12-12', '2019-12-12', '2029-12-12', 'AB+', 'Car,Bike', 'doc12.pdf'),
//        ('LN013', 'ID013', 'James Young', '1010 Chestnut St', '1990-01-13', '2020-01-13', '2030-01-13', 'O+', 'Truck', 'doc13.pdf'),
//        ('LN014', 'ID014', 'Sophia Allen', '1111 Aspen St', '1991-02-14', '2021-02-14', '2031-02-14', 'A-', 'Bike', 'doc14.pdf'),
//        ('LN015', 'ID015', 'Liam Scott', '1212 Fir St', '1992-03-15', '2022-03-15', '2032-03-15', 'B-', 'Car,Bike', 'doc15.pdf'),
//        ('LN016', 'ID016', 'Emma King', '1313 Magnolia St', '1993-04-16', '2023-04-16', '2033-04-16', 'AB-', 'Truck', 'doc16.pdf'),
//        ('LN017', 'ID017', 'Noah Wright', '1414 Olive St', '1994-05-17', '2024-05-17', '2034-05-17', 'O-', 'Car', 'doc17.pdf'),
//        ('LN018', 'ID018', 'Isabella Green', '1515 Sequoia St', '1995-06-18', '2025-06-18', '2035-06-18', 'A+', 'Bike', 'doc18.pdf'),
//        ('LN019', 'ID019', 'Mason Baker', '1616 Beech St', '1996-07-19', '2026-07-19', '2036-07-19', 'B+', 'Car,Truck', 'doc19.pdf'),
//        ('LN020', 'ID020', 'Mia Hernandez', '1717 Dogwood St', '1997-08-20', '2027-08-20', '2037-08-20', 'AB+', 'Car,Bike', 'doc20.pdf');

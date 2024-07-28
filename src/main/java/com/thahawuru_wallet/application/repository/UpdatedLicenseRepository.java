package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.UpdatedLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdatedLicenseRepository extends JpaRepository<UpdatedLicense,Long> {
}

//
//INSERT INTO updated_Licenses (
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
//('LN001', 'ID001', 'John Doe', '1234 Elm St', '1980-01-15', '2020-01-15', '2030-01-15', 'A+', 'Car,Bike', 'doc01.pdf'),
//        ('LN002', 'ID002', 'Jane Smith', '2345 Oak St', '1985-02-20', '2021-02-20', '2031-02-20', 'B-', 'Bike,Truck', 'doc02.pdf'),
//        ('LN003', 'ID003', 'Robert Johnson', '3456 Maple St', '1990-03-25', '2022-03-25', '2032-03-25', 'O+', 'Car', 'doc03.pdf'),
//        ('LN004', 'ID004', 'Emily Davis', '4567 Pine St', '1995-04-30', '2023-04-30', '2033-04-30', 'AB+', 'Car,Truck', 'doc04.pdf'),
//        ('LN005', 'ID005', 'Michael Brown', '5678 Cedar St', '2000-05-05', '2024-05-05', '2034-05-05', 'A-', 'Bike', 'doc05.pdf'),
//        ('LN006', 'ID006', 'Sarah Wilson', '6789 Birch St', '1982-06-10', '2025-06-10', '2035-06-10', 'B+', 'Car,Bike', 'doc06.pdf'),
//        ('LN007', 'ID007', 'James Lee', '7890 Spruce St', '1988-07-15', '2026-07-15', '2036-07-15', 'O-', 'Truck', 'doc07.pdf'),
//        ('LN008', 'ID008', 'Olivia Martinez', '8901 Fir St', '1993-08-20', '2027-08-20', '2037-08-20', 'AB-', 'Car', 'doc08.pdf'),
//        ('LN009', 'ID009', 'William Anderson', '9012 Willow St', '1998-09-25', '2028-09-25', '2038-09-25', 'A+', 'Bike,Truck', 'doc09.pdf'),
//        ('LN010', 'ID010', 'Isabella Thomas', '0123 Sequoia St', '2001-10-30', '2029-10-30', '2039-10-30', 'B-', 'Car,Bike', 'doc10.pdf'),
//        ('LN011', 'ID011', 'David Harris', '1234 Redwood St', '1980-11-05', '2020-11-05', '2030-11-05', 'O+', 'Truck', 'doc11.pdf'),
//        ('LN012', 'ID012', 'Sophia Clark', '2345 Aspen St', '1985-12-10', '2021-12-10', '2031-12-10', 'A-', 'Car,Bike', 'doc12.pdf'),
//        ('LN013', 'ID013', 'Christopher Lewis', '3456 Chestnut St', '1990-01-15', '2022-01-15', '2032-01-15', 'B+', 'Bike', 'doc13.pdf'),
//        ('LN014', 'ID014', 'Emma Walker', '4567 Hickory St', '1995-02-20', '2023-02-20', '2033-02-20', 'AB-', 'Car,Truck', 'doc14.pdf'),
//        ('LN015', 'ID015', 'Daniel Young', '5678 Poplar St', '2000-03-25', '2024-03-25', '2034-03-25', 'O-', 'Car', 'doc15.pdf'),
//        ('LN016', 'ID016', 'Mia Allen', '6789 Oak St', '1982-04-30', '2025-04-30', '2035-04-30', 'A+', 'Bike', 'doc16.pdf'),
//        ('LN017', 'ID017', 'Matthew King', '7890 Pine St', '1988-05-05', '2026-05-05', '2036-05-05', 'B-', 'Truck', 'doc17.pdf'),
//        ('LN018', 'ID018', 'Avery Wright', '8901 Cedar St', '1993-06-10', '2027-06-10', '2037-06-10', 'AB+', 'Car', 'doc18.pdf'),
//        ('LN019', 'ID019', 'Lucas Scott', '9012 Birch St', '1998-07-15', '2028-07-15', '2038-07-15', 'O+', 'Car,Bike', 'doc19.pdf'),
//        ('LN020', 'ID020', 'Harper Green', '0123 Maple St', '2001-08-20', '2029-08-20', '2039-08-20', 'A-', 'Bike,Truck', 'doc20.pdf');

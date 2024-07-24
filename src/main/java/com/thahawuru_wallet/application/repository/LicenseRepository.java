package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<License,Long> {

}

//
//    INSERT INTO licenses (license_number, identity_id, name, living_address, birth_date, issued_date, expiry_date, blood_group, document) VALUES
//('LIC001', 1, 'John Doe', 'Address 1', '1980-01-01', '2022-01-01', '2023-01-01', 'A+', 'Document 1'),
//        ('LIC002', 2, 'Jane Smith', 'Address 2', '1985-05-15', '2022-01-02', '2023-01-02', 'B+', 'Document 2'),
//        ('LIC003', 3, 'Alice Johnson', 'Address 3', '1990-10-10', '2022-01-03', '2023-01-03', 'O-', 'Document 3'),
//        ('LIC004', 4, 'Bob Brown', 'Address 4', '1988-03-25', '2022-01-04', '2023-01-04', 'AB+', 'Document 4'),
//        ('LIC005', 5, 'Charlie Davis', 'Address 5', '1992-07-30', '2022-01-05', '2023-01-05', 'A-', 'Document 5'),
//        ('LIC006', 6, 'Diana Evans', 'Address 6', '1983-11-20', '2022-01-06', '2023-01-06', 'B-', 'Document 6'),
//        ('LIC007', 7, 'Edward Green', 'Address 7', '1979-06-18', '2022-01-07', '2023-01-07', 'O+', 'Document 7'),
//        ('LIC008', 8, 'Fiona Harris', 'Address 8', '1987-02-28', '2022-01-08', '2023-01-08', 'AB-', 'Document 8'),
//        ('LIC009', 9, 'George King', 'Address 9', '1991-09-05', '2022-01-09', '2023-01-09', 'A+', 'Document 9'),
//        ('LIC010', 10, 'Hannah Lewis', 'Address 10', '1986-12-12', '2022-01-10', '2023-01-10', 'B+', 'Document 10'),
//        ('LIC011', 11, 'Ian Martin', 'Address 11', '1982-04-15', '2022-01-11', '2023-01-11', 'O-', 'Document 11'),
//        ('LIC012', 12, 'Jasmine Nelson', 'Address 12', '1989-08-22', '2022-01-12', '2023-01-12', 'AB+', 'Document 12'),
//        ('LIC013', 13, 'Kevin Oliver', 'Address 13', '1994-03-10', '2022-01-13', '2023-01-13', 'A-', 'Document 13'),
//        ('LIC014', 14, 'Laura Parker', 'Address 14', '1995-07-05', '2022-01-14', '2023-01-14', 'B-', 'Document 14'),
//        ('LIC015', 15, 'Michael Quinn', 'Address 15', '1980-11-30', '2022-01-15', '2023-01-15', 'O+', 'Document 15'),
//        ('LIC016', 16, 'Nora Robinson', 'Address 16', '1984-09-25', '2022-01-16', '2023-01-16', 'AB-', 'Document 16'),
//        ('LIC017', 17, 'Oscar Smith', 'Address 17', '1993-06-22', '2022-01-17', '2023-01-17', 'A+', 'Document 17'),
//        ('LIC018', 18, 'Patricia Taylor', 'Address 18', '1988-10-01', '2022-01-18', '2023-01-18', 'B+', 'Document 18'),
//        ('LIC019', 19, 'Quincy Upton', 'Address 19', '1990-05-11', '2022-01-19', '2023-01-19', 'O-', 'Document 19'),
//        ('LIC020', 20, 'Rachel Valdez', 'Address 20', '1987-12-05', '2022-01-20', '2023-01-20', 'AB+', 'Document 20');
//
//
//        INSERT INTO vehicles_allowed (license_id, vehicle) VALUES
//        (1, 'Car'),
//        (1, 'Bike'),
//        (2, 'Car'),
//        (3, 'Bike'),
//        (4, 'Car'),
//        (4, 'Truck'),
//        (5, 'Car'),
//        (6, 'Bike'),
//        (7, 'Car'),
//        (7, 'Bike'),
//        (8, 'Car'),
//        (9, 'Bike'),
//        (10, 'Car'),
//        (11, 'Bike'),
//        (12, 'Car'),
//        (13, 'Truck'),
//        (14, 'Bike'),
//        (14, 'Car'),
//        (15, 'Car'),
//        (16, 'Bike'),
//        (17, 'Car'),
//        (17, 'Bike'),
//        (18, 'Car'),
//        (19, 'Bike'),
//        (20, 'Car'),
//        (20, 'Bike');

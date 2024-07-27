package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.NewLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NewLicenseRepository extends JpaRepository<NewLicense,Long> {
}


//INSERT INTO new_licenses (
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
//('LN021', 'ID021', 'Michael Adams', '1818 Maple St', '1998-09-21', '2028-09-21', '2038-09-21', 'O+', 'Car,Bike', 'doc21.pdf'),
//        ('LN022', 'ID022', 'Ava Carter', '1919 Pine St', '1999-10-22', '2029-10-22', '2039-10-22', 'A-', 'Bike,Truck', 'doc22.pdf'),
//        ('LN023', 'ID023', 'William Lee', '2020 Oak St', '1988-11-23', '2018-11-23', '2028-11-23', 'B+', 'Car', 'doc23.pdf'),
//        ('LN024', 'ID024', 'Sophia Mitchell', '2121 Birch St', '1989-12-24', '2019-12-24', '2029-12-24', 'AB+', 'Car,Truck', 'doc24.pdf'),
//        ('LN025', 'ID025', 'James Rodriguez', '2222 Cedar St', '1990-01-25', '2020-01-25', '2030-01-25', 'O-', 'Bike', 'doc25.pdf'),
//        ('LN026', 'ID026', 'Amelia Perez', '2323 Elm St', '1991-02-26', '2021-02-26', '2031-02-26', 'A+', 'Car,Bike', 'doc26.pdf'),
//        ('LN027', 'ID027', 'Benjamin Murphy', '2424 Willow St', '1992-03-27', '2022-03-27', '2032-03-27', 'B-', 'Truck', 'doc27.pdf'),
//        ('LN028', 'ID028', 'Charlotte Hughes', '2525 Spruce St', '1993-04-28', '2023-04-28', '2033-04-28', 'AB-', 'Car', 'doc28.pdf'),
//        ('LN029', 'ID029', 'Alexander Howard', '2626 Poplar St', '1994-05-29', '2024-05-29', '2034-05-29', 'O+', 'Car,Bike,Truck', 'doc29.pdf'),
//        ('LN030', 'ID030', 'Mia Turner', '2727 Chestnut St', '1995-06-30', '2025-06-30', '2035-06-30', 'A-', 'Bike,Truck', 'doc30.pdf'),
//        ('LN031', 'ID031', 'Ethan King', '2828 Redwood St', '1996-07-31', '2026-07-31', '2036-07-31', 'B+', 'Car', 'doc31.pdf'),
//        ('LN032', 'ID032', 'Isabella Wright', '2929 Ash St', '1997-08-01', '2027-08-01', '2037-08-01', 'AB+', 'Car,Bike', 'doc32.pdf'),
//        ('LN033', 'ID033', 'Logan Martin', '3030 Fir St', '1998-09-02', '2028-09-02', '2038-09-02', 'O+', 'Truck', 'doc33.pdf'),
//        ('LN034', 'ID034', 'Mila Walker', '3131 Sequoia St', '1999-10-03', '2029-10-03', '2039-10-03', 'A-', 'Bike', 'doc34.pdf'),
//        ('LN035', 'ID035', 'Lucas Scott', '3232 Magnolia St', '1988-11-04', '2018-11-04', '2028-11-04', 'B-', 'Car,Bike', 'doc35.pdf'),
//        ('LN036', 'ID036', 'Harper Lewis', '3333 Beech St', '1989-12-05', '2019-12-05', '2029-12-05', 'AB-', 'Truck', 'doc36.pdf'),
//        ('LN037', 'ID037', 'Elijah Green', '3434 Dogwood St', '1990-01-06', '2020-01-06', '2030-01-06', 'O-', 'Car', 'doc37.pdf'),
//        ('LN038', 'ID038', 'Ella Baker', '3535 Oak St', '1991-02-07', '2021-02-07', '2031-02-07', 'A+', 'Bike', 'doc38.pdf'),
//        ('LN039', 'ID039', 'Mason Young', '3636 Maple St', '1992-03-08', '2022-03-08', '2032-03-08', 'B+', 'Car,Truck', 'doc39.pdf'),
//        ('LN040', 'ID040', 'Liam Hernandez', '3737 Pine St', '1993-04-09', '2023-04-09', '2033-04-09', 'AB+', 'Car,Bike', 'doc40.pdf');

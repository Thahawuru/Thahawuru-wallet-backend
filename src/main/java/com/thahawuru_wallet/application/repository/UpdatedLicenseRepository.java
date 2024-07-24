package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.UpdatedLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdatedLicenseRepository extends JpaRepository<UpdatedLicense,Long> {
}


//    INSERT INTO updated_licenses (license_number, identity_id, name, living_address, birth_date, issued_date, expiry_date, blood_group, vehicles_allowed, document)
//    VALUES
//            ('LN001', 'ID101', 'Alice Brown', '123 Elm St', '1985-06-15', '2022-01-10', '2027-01-10', 'A+', 'Car,Bike', 'docA1.pdf'),
//('LN002', 'ID102', 'Bob Smith', '456 Oak St', '1990-07-22', '2022-02-11', '2027-02-11', 'B+', 'Car', 'docB2.pdf'),
//        ('LN003', 'ID103', 'Carol Johnson', '789 Pine St', '1982-08-11', '2022-03-12', '2027-03-12', 'O+', 'Truck,Car', 'docC3.pdf'),
//        ('LN004', 'ID104', 'David Lee', '234 Maple St', '1978-09-30', '2022-04-10', '2027-04-10', 'AB-', 'Car,Bike', 'docD4.pdf'),
//        ('LN005', 'ID105', 'Eva Green', '345 Cedar St', '1995-11-20', '2022-05-15', '2027-05-15', 'A-', 'Car', 'docE5.pdf'),
//        ('LN006', 'ID106', 'Frank Wright', '456 Birch St', '1987-12-02', '2022-06-10', '2027-06-10', 'B-', 'Truck', 'docF6.pdf'),
//        ('LN007', 'ID107', 'Grace Hill', '567 Oak St', '1979-01-15', '2022-07-11', '2027-07-11', 'O-', 'Bike', 'docG7.pdf'),
//        ('LN008', 'ID108', 'Hannah Fox', '678 Willow St', '1992-02-28', '2022-08-12', '2027-08-12', 'A+', 'Car,Truck', 'docH8.pdf'),
//        ('LN009', 'ID109', 'Ian Black', '789 Elm St', '1984-03-19', '2022-09-13', '2027-09-13', 'B+', 'Car', 'docI9.pdf'),
//        ('LN010', 'ID110', 'Jack White', '890 Pine St', '1991-04-04', '2022-10-14', '2027-10-14', 'O+', 'Bike,Car', 'docJ10.pdf'),
//        ('LN011', 'ID111', 'Kara Gray', '123 Cedar St', '1983-05-22', '2022-11-15', '2027-11-15', 'AB+', 'Car,Truck', 'docK11.pdf'),
//        ('LN012', 'ID112', 'Liam Adams', '234 Birch St', '1989-06-06', '2022-12-16', '2027-12-16', 'A-', 'Car,Bike', 'docL12.pdf'),
//        ('LN013', 'ID113', 'Mia Johnson', '345 Oak St', '1976-07-10', '2023-01-17', '2028-01-17', 'B-', 'Truck', 'docM13.pdf'),
//        ('LN014', 'ID114', 'Nina Brown', '456 Maple St', '1988-08-13', '2023-02-18', '2028-02-18', 'O-', 'Car', 'docN14.pdf'),
//        ('LN015', 'ID115', 'Oscar Green', '567 Elm St', '1994-09-20', '2023-03-19', '2028-03-19', 'A+', 'Car,Truck', 'docO15.pdf'),
//        ('LN016', 'ID116', 'Paula White', '678 Pine St', '1981-10-15', '2023-04-20', '2028-04-20', 'B+', 'Bike', 'docP16.pdf'),
//        ('LN017', 'ID117', 'Quincy Black', '789 Cedar St', '1977-11-30', '2023-05-21', '2028-05-21', 'O+', 'Car', 'docQ17.pdf'),
//        ('LN018', 'ID118', 'Rachel Fox', '890 Birch St', '1985-12-12', '2023-06-22', '2028-06-22', 'AB-', 'Truck,Car', 'docR18.pdf'),
//        ('LN019', 'ID119', 'Sam Hill', '123 Maple St', '1993-01-25', '2023-07-23', '2028-07-23', 'A-', 'Car,Bike', 'docS19.pdf'),
//        ('LN020', 'ID120', 'Tina Adams', '234 Willow St', '1990-02-14', '2023-08-24', '2028-08-24', 'B-', 'Car', 'docT20.pdf');

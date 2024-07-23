package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityRepository extends JpaRepository<Identity,Long> {

}

//    CREATE TABLE identities (
//        issued_date TIMESTAMP NOT NULL,
//        identity_number VARCHAR(10) PRIMARY KEY,
//    name VARCHAR(100) NOT NULL,
//    other_names VARCHAR(100),
//    birth_date TIMESTAMP NOT NULL,
//    birth_place VARCHAR(100),
//    job VARCHAR(50),
//    living_address TEXT,
//    document VARCHAR(100)
//);



//
//    INSERT INTO identities (issued_date, identity_number, name, other_names, birth_date, birth_place, job, living_address, document)
//    VALUES
//            (TO_TIMESTAMP(1672547800000 / 1000), 'ID004', 'Alice Johnson', 'Ali', TO_TIMESTAMP(945684800000 / 1000), 'City D', 'Artist', 'Address 4', 'Document 4'),
//        (TO_TIMESTAMP(1697547800000 / 1000), 'ID005', 'Bob Brown', 'Bobby', TO_TIMESTAMP(949684800000 / 1000), 'City E', 'Chef', 'Address 5', 'Document 5'),
//        (TO_TIMESTAMP(1702547800000 / 1000), 'ID006', 'Carol White', 'Carrie', TO_TIMESTAMP(946884800000 / 1000), 'City F', 'Teacher', 'Address 6', 'Document 6'),
//        (TO_TIMESTAMP(1652547800000 / 1000), 'ID007', 'David Black', 'Dave', TO_TIMESTAMP(948684800000 / 1000), 'City G', 'Musician', 'Address 7', 'Document 7'),
//        (TO_TIMESTAMP(1637547800000 / 1000), 'ID008', 'Emily Green', 'Em', TO_TIMESTAMP(949684800000 / 1000), 'City H', 'Scientist', 'Address 8', 'Document 8'),
//        (TO_TIMESTAMP(1622547800000 / 1000), 'ID009', 'Frank Gray', 'Frankie', TO_TIMESTAMP(949684800000 / 1000), 'City I', 'Architect', 'Address 9', 'Document 9'),
//        (TO_TIMESTAMP(1612547800000 / 1000), 'ID010', 'Grace Lee', 'Gracie', TO_TIMESTAMP(950684800000 / 1000), 'City J', 'Engineer', 'Address 10', 'Document 10'),
//        (TO_TIMESTAMP(1602547800000 / 1000), 'ID011', 'Hannah King', 'Hanny', TO_TIMESTAMP(951684800000 / 1000), 'City K', 'Doctor', 'Address 11', 'Document 11'),
//        (TO_TIMESTAMP(1592547800000 / 1000), 'ID012', 'Ivy Scott', 'Ives', TO_TIMESTAMP(952684800000 / 1000), 'City L', 'Lawyer', 'Address 12', 'Document 12'),
//        (TO_TIMESTAMP(1582547800000 / 1000), 'ID013', 'Jack Wright', 'Jackie', TO_TIMESTAMP(953684800000 / 1000), 'City M', 'Journalist', 'Address 13', 'Document 13');

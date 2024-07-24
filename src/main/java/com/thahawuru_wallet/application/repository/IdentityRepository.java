package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IdentityRepository extends JpaRepository<Identity,Long> {
    List<Identity> findAll();

}

//
//        INSERT INTO identities (issued_date, identity_number, name, other_names, birth_date, birth_place, job, living_address, document) VALUES
//        ('2022-01-01', 'ID001', 'John Doe', 'Johnny', '1980-01-01', 'City A', 'Engineer', 'Address 1', 'Document 1'),
//        ('2022-01-02', 'ID002', 'Jane Smith', 'Janie', '1985-05-15', 'City B', 'Doctor', 'Address 2', 'Document 2'),
//        ('2022-01-03', 'ID003', 'Alice Johnson', 'Ally', '1990-10-10', 'City C', 'Teacher', 'Address 3', 'Document 3'),
//        ('2022-01-04', 'ID004', 'Bob Brown', 'Bobby', '1988-03-25', 'City D', 'Artist', 'Address 4', 'Document 4'),
//        ('2022-01-05', 'ID005', 'Charlie Davis', 'Chuck', '1992-07-30', 'City E', 'Scientist', 'Address 5', 'Document 5'),
//        ('2022-01-06', 'ID006', 'Diana Evans', 'Di', '1983-11-20', 'City F', 'Nurse', 'Address 6', 'Document 6'),
//        ('2022-01-07', 'ID007', 'Edward Green', 'Eddie', '1979-06-18', 'City G', 'Engineer', 'Address 7', 'Document 7'),
//        ('2022-01-08', 'ID008', 'Fiona Harris', 'Fi', '1987-02-28', 'City H', 'Lawyer', 'Address 8', 'Document 8'),
//        ('2022-01-09', 'ID009', 'George King', 'Geo', '1991-09-05', 'City I', 'Chef', 'Address 9', 'Document 9'),
//        ('2022-01-10', 'ID010', 'Hannah Lewis', 'Hanny', '1986-12-12', 'City J', 'Dentist', 'Address 10', 'Document 10'),
//        ('2022-01-11', 'ID011', 'Ian Martin', 'Ike', '1982-04-15', 'City K', 'Musician', 'Address 11', 'Document 11'),
//        ('2022-01-12', 'ID012', 'Jasmine Nelson', 'Jazz', '1989-08-22', 'City L', 'Photographer', 'Address 12', 'Document 12'),
//        ('2022-01-13', 'ID013', 'Kevin Oliver', 'Kev', '1994-03-10', 'City M', 'Architect', 'Address 13', 'Document 13'),
//        ('2022-01-14', 'ID014', 'Laura Parker', 'Laurie', '1995-07-05', 'City N', 'Pharmacist', 'Address 14', 'Document 14'),
//        ('2022-01-15', 'ID015', 'Michael Quinn', 'Mike', '1980-11-30', 'City O', 'Pilot', 'Address 15', 'Document 15'),
//        ('2022-01-16', 'ID016', 'Nora Robinson', 'Nori', '1984-09-25', 'City P', 'Veterinarian', 'Address 16', 'Document 16'),
//        ('2022-01-17', 'ID017', 'Oscar Smith', 'Ossie', '1993-06-22', 'City Q', 'Police Officer', 'Address 17', 'Document 17'),
//        ('2022-01-18', 'ID018', 'Patricia Taylor', 'Patty', '1988-10-01', 'City R', 'Social Worker', 'Address 18', 'Document 18'),
//        ('2022-01-19', 'ID019', 'Quincy Upton', 'Quin', '1990-05-11', 'City S', 'Electrician', 'Address 19', 'Document 19'),
//        ('2022-01-20', 'ID020', 'Rachel Valdez', 'Rae', '1987-12-05', 'City T', 'Journalist', 'Address 20', 'Document 20');

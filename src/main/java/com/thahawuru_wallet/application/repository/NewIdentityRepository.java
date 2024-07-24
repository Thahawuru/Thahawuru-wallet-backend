package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.NewIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewIdentityRepository extends JpaRepository<NewIdentity,Long> {
}


//    INSERT INTO new_identities (issued_date, identity_number, name, other_names, birth_date, birth_place, job, living_address, document)
//    VALUES
//            ('2022-01-21', 'ID021', 'Steven Moore', 'Steve', '1983-01-15', 'City U', 'Engineer', 'Address 21', 'Document 21'),
//('2022-01-22', 'ID022', 'Tina Garcia', 'Tee', '1992-05-28', 'City V', 'Doctor', 'Address 22', 'Document 22'),
//        ('2022-01-23', 'ID023', 'Uma Patel', 'Umi', '1986-11-09', 'City W', 'Teacher', 'Address 23', 'Document 23'),
//        ('2022-01-24', 'ID024', 'Victor Lee', 'Vic', '1980-04-18', 'City X', 'Artist', 'Address 24', 'Document 24'),
//        ('2022-01-25', 'ID025', 'Wendy Martinez', 'Wen', '1989-08-07', 'City Y', 'Scientist', 'Address 25', 'Document 25'),
//        ('2022-01-26', 'ID026', 'Xavier Brown', 'Xav', '1981-02-20', 'City Z', 'Nurse', 'Address 26', 'Document 26'),
//        ('2022-01-27', 'ID027', 'Yara Wilson', 'Yari', '1995-06-15', 'City AA', 'Engineer', 'Address 27', 'Document 27'),
//        ('2022-01-28', 'ID028', 'Zack Johnson', 'Z', '1990-10-30', 'City BB', 'Lawyer', 'Address 28', 'Document 28'),
//        ('2022-01-29', 'ID029', 'Amy Davis', 'Ames', '1985-03-14', 'City CC', 'Chef', 'Address 29', 'Document 29'),
//        ('2022-01-30', 'ID030', 'Brian Taylor', 'Bri', '1988-09-09', 'City DD', 'Dentist', 'Address 30', 'Document 30'),
//        ('2022-01-31', 'ID031', 'Claire Evans', 'Clare', '1991-12-25', 'City EE', 'Musician', 'Address 31', 'Document 31'),
//        ('2022-02-01', 'ID032', 'David King', 'Dave', '1982-07-13', 'City FF', 'Photographer', 'Address 32', 'Document 32'),
//        ('2022-02-02', 'ID033', 'Eve Harris', 'Evie', '1993-11-17', 'City GG', 'Architect', 'Address 33', 'Document 33'),
//        ('2022-02-03', 'ID034', 'Frankie Lewis', 'Frank', '1984-05-30', 'City HH', 'Pharmacist', 'Address 34', 'Document 34'),
//        ('2022-02-04', 'ID035', 'Grace Martin', 'Gracie', '1989-02-02', 'City II', 'Pilot', 'Address 35', 'Document 35'),
//        ('2022-02-05', 'ID036', 'Harry Robinson', 'Hal', '1987-06-21', 'City JJ', 'Veterinarian', 'Address 36', 'Document 36'),
//        ('2022-02-06', 'ID037', 'Isabella Scott', 'Izzy', '1994-08-16', 'City KK', 'Police Officer', 'Address 37', 'Document 37'),
//        ('2022-02-07', 'ID038', 'Jackie Turner', 'Jack', '1983-03-25', 'City LL', 'Social Worker', 'Address 38', 'Document 38'),
//        ('2022-02-08', 'ID039', 'Kevin Young', 'Kev', '1986-10-05', 'City MM', 'Electrician', 'Address 39', 'Document 39'),
//        ('2022-02-09', 'ID040', 'Lily White', 'Lil', '1990-01-15', 'City NN', 'Journalist', 'Address 40', 'Document 40');

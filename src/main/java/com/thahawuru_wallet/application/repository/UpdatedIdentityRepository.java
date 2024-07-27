package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.UpdatedIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdatedIdentityRepository extends JpaRepository<UpdatedIdentity,Long> {
}

//
//    INSERT INTO updated_identities (identity_number, issued_date, name, other_names, birth_date, birth_place, job, living_address, document) VALUES
//('ID001', '2023-01-01', 'John Doe Updated', 'Johnny U', '1981-01-01', 'Updated City A', 'Senior Engineer', 'Updated Address 1', 'Updated Document 1'),
//        ('ID002', '2023-01-02', 'Jane Smith Updated', 'Janie U', '1986-05-15', 'Updated City B', 'Consultant Doctor', 'Updated Address 2', 'Updated Document 2'),
//        ('ID003', '2023-01-03', 'Alice Johnson Updated', 'Ally U', '1991-10-10', 'Updated City C', 'Head Teacher', 'Updated Address 3', 'Updated Document 3'),
//        ('ID004', '2023-01-04', 'Bob Brown Updated', 'Bobby U', '1989-03-25', 'Updated City D', 'Lead Artist', 'Updated Address 4', 'Updated Document 4'),
//        ('ID005', '2023-01-05', 'Charlie Davis Updated', 'Chuck U', '1993-07-30', 'Updated City E', 'Chief Scientist', 'Updated Address 5', 'Updated Document 5'),
//        ('ID006', '2023-01-06', 'Diana Evans Updated', 'Di U', '1984-11-20', 'Updated City F', 'Head Nurse', 'Updated Address 6', 'Updated Document 6'),
//        ('ID007', '2023-01-07', 'Edward Green Updated', 'Eddie U', '1980-06-18', 'Updated City G', 'Chief Engineer', 'Updated Address 7', 'Updated Document 7'),
//        ('ID008', '2023-01-08', 'Fiona Harris Updated', 'Fi U', '1988-02-28', 'Updated City H', 'Senior Lawyer', 'Updated Address 8', 'Updated Document 8'),
//        ('ID009', '2023-01-09', 'George King Updated', 'Geo U', '1992-09-05', 'Updated City I', 'Head Chef', 'Updated Address 9', 'Updated Document 9'),
//        ('ID010', '2023-01-10', 'Hannah Lewis Updated', 'Hanny U', '1987-12-12', 'Updated City J', 'Lead Dentist', 'Updated Address 10', 'Updated Document 10'),
//        ('ID011', '2023-01-11', 'Ian Martin Updated', 'Ike U', '1983-04-15', 'Updated City K', 'Senior Musician', 'Updated Address 11', 'Updated Document 11'),
//        ('ID012', '2023-01-12', 'Jasmine Nelson Updated', 'Jazz U', '1990-08-22', 'Updated City L', 'Lead Photographer', 'Updated Address 12', 'Updated Document 12'),
//        ('ID013', '2023-01-13', 'Kevin Oliver Updated', 'Kev U', '1995-03-10', 'Updated City M', 'Chief Architect', 'Updated Address 13', 'Updated Document 13'),
//        ('ID014', '2023-01-14', 'Laura Parker Updated', 'Laurie U', '1996-07-05', 'Updated City N', 'Senior Pharmacist', 'Updated Address 14', 'Updated Document 14'),
//        ('ID015', '2023-01-15', 'Michael Quinn Updated', 'Mike U', '1981-11-30', 'Updated City O', 'Chief Pilot', 'Updated Address 15', 'Updated Document 15'),
//        ('ID016', '2023-01-16', 'Nora Robinson Updated', 'Nori U', '1985-09-25', 'Updated City P', 'Lead Veterinarian', 'Updated Address 16', 'Updated Document 16'),
//        ('ID017', '2023-01-17', 'Oscar Smith Updated', 'Ossie U', '1994-06-22', 'Updated City Q', 'Senior Police Officer', 'Updated Address 17', 'Updated Document 17'),
//        ('ID018', '2023-01-18', 'Patricia Taylor Updated', 'Patty U', '1989-10-01', 'Updated City R', 'Senior Social Worker', 'Updated Address 18', 'Updated Document 18'),
//        ('ID019', '2023-01-19', 'Quincy Upton Updated', 'Quin U', '1991-05-11', 'Updated City S', 'Chief Electrician', 'Updated Address 19', 'Updated Document 19'),
//        ('ID020', '2023-01-20', 'Rachel Valdez Updated', 'Rae U', '1988-12-05', 'Updated City T', 'Lead Journalist', 'Updated Address 20', 'Updated Document 20');
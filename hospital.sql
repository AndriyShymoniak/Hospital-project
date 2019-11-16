DROP DATABASE IF EXISTS hospital_project;
CREATE DATABASE hospital_project;

USE hospital_project;

#DROP TABLE IF EXISTS doctor;
CREATE TABLE doctor (
	doctor_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(30) NOT NULL,
	middle_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	phone_number VARCHAR(13),
	email_address VARCHAR(100),
	speciality VARCHAR(100) NOT NULL,
	birth_date DATE,
	patient_id INT
);

CREATE TABLE patient (
	patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(30),
	middle_name VARCHAR(30),
	last_name VARCHAR(30),
	phone_number VARCHAR(13),
	email_address VARCHAR(100),
	address VARCHAR(100),
	birth_date DATE,
	doctor_id INT
);

CREATE TABLE medicine (
	medicine_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    analog_id INT,
	medicine_name VARCHAR(30),
	price INT,
	description TEXT,
	diagnosis_id INT
);

CREATE TABLE diagnosis (
	diagnosis_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	diagnosis_name VARCHAR(100) NOT NULL,
    diagnosis_date DATE NOT NULL,
	description TEXT,
	medicine_id INT,
	doctor_id INT,
	patient_id INT,
	feedback_id INT
);

CREATE TABLE doctor_patient (
	doctor_patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
#    doctor_patient_id INT PRIMARY KEY NOT NULL,
	patient_id INT,
	doctor_id INT
);

CREATE TABLE feedback (
	feedback_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	quality VARCHAR(20),
	feedback_comment TEXT,
    feedback_date DATE
);

INSERT INTO 
doctor(first_name, middle_name, last_name , phone_number, email_address, speciality, birth_date, patient_id)
VALUES
	('DocName1','DocMidName1', 'DocLastName1', '+380985559934', 'mail@mail.com', 'dantist', '2000-08-27', 1),
	('DocName2','DocMidName2', 'DocLastName2', '+380985559934', 'mail@mail.com', 'dantist', '2000-08-27', 2),
	('DocName3','DocMidName3', 'DocLastName3', '+380985559934', 'mail@mail.com', 'dantist', '2000-08-27', 3),
	('DocName4','DocMidName4', 'DocLastName4', '+380985559934', 'mail@mail.com', 'dantist', '2000-08-27', 4),
	('DocName5','DocMidName5', 'DocLastName5', '+380985559934', 'mail@mail.com', 'dantist', '2000-08-27', 5)
;

INSERT INTO 
patient(first_name, middle_name, last_name , phone_number, email_address, address, birth_date, doctor_id)
VALUES
	('PatName1','PatMidName1', 'PatLastName1', '+380985559934', 'mail@mail.com', 'Lviv Lychakivska 228', '2000-08-27', 1),
	('PatName2','PatMidName2', 'PatLastName2', '+380985559934', 'mail@mail.com', 'Lviv Lychakivska 228', '2000-08-27', 2),
	('PatName3','PatMidName3', 'PatLastName3', '+380985559934', 'mail@mail.com', 'Lviv Lychakivska 228', '2000-08-27', 3),
	('PatName4','PatMidName4', 'PatLastName4', '+380985559934', 'mail@mail.com', 'Lviv Lychakivska 228', '2000-08-27', 4),
	('PatName5','PatMidName5', 'PatLastName5', '+380985559934', 'mail@mail.com', 'Lviv Lychakivska 228', '2000-08-27', 5)
;

INSERT INTO 
medicine(analog_id, medicine_name, price, description , diagnosis_id)
VALUES
	(1, 'MedName1', 1000, 'description description, descriptrion', 1),
	(null, 'MedName11', 1000, 'description description, descriptrion', 1),
	(null, 'MedName12', 1000, 'description description, descriptrion', 1),
	(null, 'MedName13', 1000, 'description description, descriptrion', 1),
	(1, 'MedName2', 1000, 'description description, descriptrion', 2),
	(1, 'MedName3', 1000, 'description description, descriptrion', 3),
	(1, 'MedName4', 1000, 'description description, descriptrion', 4),
	(1, 'MedName5', 1000, 'description description, descriptrion', 5)
;

INSERT INTO 
diagnosis(diagnosis_name, diagnosis_date, description, medicine_id, doctor_id, patient_id, feedback_id)
VALUES
	('DiagName1', '2019-07-12', "description description description", 1, 1, 1, 1),
	('DiagName2', '2019-07-12', "description description description", 2, 2, 2, 2),
	('DiagName3', '2019-07-12', "description description description", 3, 3, 3, 3),
	('DiagName4', '2019-07-12', "description description description", 4, 4, 4, 4),
	('DiagName5', '2019-07-12', "description description description", 5, 5, 5, 5)
;

INSERT INTO 
feedback(quality, feedback_comment, feedback_date)
VALUES
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-1'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-2'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-3'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-4'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-5')
;

INSERT INTO
doctor_patient(patient_id, doctor_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5)
;

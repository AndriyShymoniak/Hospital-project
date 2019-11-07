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
#	doctor_patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    doctor_patient_id INT PRIMARY KEY NOT NULL,
	patient_id INT,
	doctor_id INT
);

CREATE TABLE feedback (
	feedback_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	quality VARCHAR(20),
	feedback_comment TEXT,
    feedback_date DATE
);





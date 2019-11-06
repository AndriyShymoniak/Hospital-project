DROP DATABASE IF EXISTS hospital_project;
CREATE DATABASE hospital_project;

USE hospital_project;

#DROP TABLE IF EXISTS doctor;
CREATE TABLE doctor (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(30),
	middle_name VARCHAR(30),
	last_name VARCHAR(30),
	phone_number VARCHAR(13),
	mail VARCHAR(100),
	speciality VARCHAR(100),
	birth_date DATE,
	patient_id INT
);

CREATE TABLE patient (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(30),
	middle_name VARCHAR(30),
	last_name VARCHAR(30),
	phone_number VARCHAR(13),
	mail VARCHAR(100),
	address VARCHAR(100),
	birth_date DATE,
	doctor_id INT
);

CREATE TABLE medicine (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	medicine_name VARCHAR(30),
	price INT,
	description TEXT,
	doctor_id INT
);

CREATE TABLE diagnosis (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	diagnosis_name VARCHAR(30),
    daignosis_date DATE,
	description TEXT,
	medicine_id INT,
	doctor_id INT,
	patient_id INT,
	feedback_id INT
);

CREATE TABLE doctor_patient (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	patient_id INT,
	doctor_id INT
);

CREATE TABLE feedback (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	quality VARCHAR(20),
	feedback_comment TEXT,
    feedback_date DATE
);

#public class Diagnosis {
#    private int id;
#    private String name;
#    private String description;
#    private Date diagnosisDate;

#    private Doctor doctor;
#    private Patient patient;
#    private List<Medicine> medicines = new ArrayList<>();



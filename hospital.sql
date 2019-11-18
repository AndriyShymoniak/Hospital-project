DROP DATABASE IF EXISTS hospital_project;
CREATE DATABASE hospital_project CHAR SET UTF8;

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
	birth_date DATE
#	patient_id INT
);

CREATE TABLE patient (
	patient_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(30),
	middle_name VARCHAR(30),
	last_name VARCHAR(30),
	phone_number VARCHAR(13),
	email_address VARCHAR(100),
	address VARCHAR(100),
	birth_date DATE
#	doctor_id INT
);

CREATE TABLE medicine (
	medicine_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    analog_id INT,
	medicine_name VARCHAR(30),
	price INT,
	description TEXT
#	diagnosis_id INT
);

CREATE TABLE diagnosis (
	diagnosis_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	diagnosis_name VARCHAR(100) NOT NULL,
    diagnosis_date DATE NOT NULL,
	description TEXT,
#	medicine_id INT,
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

CREATE TABLE medicine_diagnosis (
	medicine_diagnosis_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
#    doctor_patient_id INT PRIMARY KEY NOT NULL,
	medicine_id INT,
	diagnosis_id INT
);

CREATE TABLE feedback (
	feedback_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	quality VARCHAR(20),
	feedback_comment TEXT,
    feedback_date DATE
);

# 13 records
INSERT INTO 
doctor(first_name, middle_name, last_name , phone_number, email_address, speciality, birth_date)
VALUES
	('Федір','Андрійович', 'Микитюк', '+38098581632', 'mykytiuk@mail.com', 'Сімейний лікар', '1974-05-21'),
	('Петро','Сергійович', 'Жук', '+38098581632', 'juk@mail.com', 'Сімейний лікар', '1970-07-01'),
	('Кирило','Романович', 'Боднаренко', '+380985559934', 'kir9bond@mail.com', 'Кардіолог', '1968-04-19'),
	('Валентина','Олексіївна', 'Іванченко', '+380985559934', 'ivanchenko@mail.com', 'Масажист', '1970-02-02'),
	('Валерій','Альбертович', 'Жмишенко', '+380985559934', 'mops69@mail.com', 'Проктолог', '1965-10-04'),
    ('Констянтин','Ярославович', 'Войтович', '+380985559934', 'yarik@mail.com', 'Хірург', '1981-08-17'),
    ('Дарія','Федорівна', 'Крамарчук', '+380985559934', 'kramar@mail.com', 'Отоларинолог', '1985-09-24'),
    ('Анастасія','Валентинівна', 'Середа', '+380985559934', 'sereda@mail.com', 'Терапевт', '1979-11-29'),
    ('Олександр','Олексанлрович', 'Шляпик', '+380985559934', 'sashkashlyapka@mail.com', 'Венеролог', '1978-10-01'),
    ('Денис','Петрович', 'Боров', '+380985559934', 'boroff@mail.com', 'Уролог', '1969-01-10'),

    ('Дмитро','Орестович', 'Урич', '+380985559934', 'dimaurich@mail.com', 'Психолог', '1990-03-03'),
    ('Ярема','Андрійович', 'Торч', '+38093101500', 'pisos420@mail.com', 'Нарколог', '1985-04-07'),
	('Єлизавета','Степанівна', 'Кравченко', '+380985559934', 'likar@mail.com', 'Дерматолог', '1987-05-13')
;

# 20 records
INSERT INTO 
patient(first_name, middle_name, last_name , phone_number, email_address, address, birth_date)
VALUES
	('Адам','Володимирович', 'Лисенко', '+380985559934', 'adam@mail.com', 'С. Мшана, Вул. Тараса Шевченка, 10', '2070-03-14'),
	('Світлана','Романівна', 'Лисенко', '+380985559934', 'lissveta@mail.com', 'С. Мшана, Вул. Тараса Шевченка, 10', '2075-02-05'),
	('Валерій','Адамович', 'Лисенко', '+380985559934', 'valavam@mail.com', 'С. Мшана, Вул. Тараса Шевченка, 10', '2000-04-13'),
	('Олег','Євгенович', 'Монгол', '+380985559934', 'mongo@mail.com', 'С. Мшана, Вул. Тараса Шевченка, 14', '1970-11-23'),
	('Павло','Євгенович', 'Монгол', '+380985559934', 'bezumniy@mail.com', 'С. Мшана, Вул. Тараса Шевченка, 14', '1970-06-20'),
	('Ірина','Євгенівна', 'Монгол', '+380985559934', 'irishka@mail.com', 'С. Мшана, Вул. Тараса Шевченка, 14', '1970-10-04'),
	('Раїса','Андріївна', 'Іванченко', '+380985559934', 'raya@mail.com', 'С. Мшана, Вул. Зелена, 21', '1984-09-08'),
	('Віталій','Олексадрович', 'Іванченко', '+380985559934', 'vitalekiva@mail.com', 'С. Мшана, Вул. Зелена, 21', '1984-02-03'),
	('Іван','Вікторович', 'Панасюк', '+380985559934', 'panos1@mail.com', 'С. Мшана, Вул. Зелена, 3', '1980-01-05'),
	('Софія','Віталіївна', 'Панасюк', '+380985559934', 'panosiuk@mail.com', 'С. Мшана, Вул. Зелена, 3', '1980-11-12'),

	('Анастасія','Олександрівна', 'Панасюк', '+380985559934', 'panya@mail.com', 'С. Мшана, Вул. Зелена, 3', '2001-12-12'),
	('Євгенія','Ростиславівна', 'Романченко', '+380985559934', 'jekaroma@mail.com', 'С. Мшана, Вул. Олександра Довженка, 8', '1987-03-20'),
	('Віктор','Олегович', 'Романченко', '+380985559934', 'vitya1@mail.com', 'С. Мшана, Вул. Олександра Довженка, 8', '1985-07-28'),
	('Лариса','Олександрівна', 'Гнатюк', '+380985559934', 'gnatiuklara@mail.com', 'С. Мшана, Вул. Олександра Довженка, 31', '1992-06-27'),
	('Наталія','Олександрівна', 'Гнатюк', '+380985559934', 'gnatiuknata@mail.com', 'С. Мшана, Вул. Олександра Довженка, 31', '1990-05-16'),
	('Борис','Арсентійович', 'Гнатюк', '+380985559934', 'bor9@mail.com', 'С. Мшана, Вул. Олександра Довженка, 31', '1999-02-19'),
	('Станіслав','Григорович', 'Стефанів', '+380985559934', 'stefka@mail.com', 'С. Мшана, Вул. Степана Бандери, 14', '1999-01-01'),
	('Микола','Володимирович', 'Вареник', '+380985559934', 'varenik@mail.com', 'С. Мшана, Вул. Степана Бандери, 37', '2000-10-07'),
	('Роман','Ігорович', 'Кацків', '+380985559934', 'pisooos@mail.com', 'С. Мшана, Вул. Степана Бандери, 14', '2000-11-15'),
	('Євгенія','Романівна', 'Петрунів', '+380985559934', 'patient@mail.com', 'С. Мшана, Вул. Степана Бандери, 1', '1963-08-17')
;

# 25 records
INSERT INTO 
medicine(analog_id, medicine_name, price, description)
VALUES
	(1, 'Парацетамол', 21,
    'таблетки по 200 мг по 10 таблеток у блістерах; по 10 таблеток у блістері, по 2 блістери в пачці
Країна-виробник: Україна
Реєстраційний номер: UA/8334/01/01
Склад діючих речовин: 1 таблетка містить парацетамолу, у перерахуванні на 100 % речовину, 200 мг'),
	(1, 'Аміцитрон', 136, 'порошок для орального розчину по 23 г у саше; по 23 г у саше; по 10 саше в пачці з картону
Країна-виробник: Україна
Реєстраційний номер: UA/13911/01/01
Склад діючих речовин: 1 саше містить парацетамолу 500 мг, фенілефрину гідрохлориду 10 мг, феніраміну малеату 20 мг, кислоти аскорбінової 50 мг'),
	(1, 'Піарол', 20, 'таблетки, вкриті оболонкою, по 500 мг по 10 таблеток у блістері, по 1 або по 2 блістери в картонній упаковці
Країна-виробник: Україна
Реєстраційний номер: UA/9270/01/01
Склад діючих речовин: 1 таблетка містить парацетамолу 500 мг;'),
	(2, 'Аквамакс', 49, 'спрей назальний 0,65 %, по 20 мл у флаконах з клапаном-насосом, назальною насадкою-розпилювачем; по 1 флакону в коробці з картону; по 50 мл або по 100 мл у флаконах з клапаном-насосом, назальною насадкою-розпилювачем; по 1 флакону в коробці з картону; по 50 мл, по 100 мл або по 150 мл у балоні з клапаном-пакетом, назальною насадкою - розпилювачем та захисним ковпачком; по 1 балону у коробці з картону
Країна-виробник: Україна
Реєстраційний номер: UA/12832/02/01
Склад діючих речовин: 1 мл препарату містить натрію хлориду 6,5 мг'),
	(2, 'Но-соль', 64, 'спрей назальний 0,65 % по 10 мл у флаконі скляному; по 1 флакону у пачці з картону або по 15 мл у флаконі поліетиленовому; по 1 флакону з дозатором у пачці з картону
Країна-виробник: Україна
Реєстраційний номер: UA/1877/02/01
Склад діючих речовин: 1 мл розчину містить натрію хлориду 6,5 мг'),
	(2, 'Аква Маріс', 124, 'спрей назальний 0,65 %, по 50 мл у флаконах з клапаном-насосом, назальною насадкою-розпилювачем; по 1 флакону в коробці з картону; по 50 мл або по 100 мл у флаконах з клапаном-насосом, назальною насадкою-розпилювачем; по 1 флакону в коробці з картону; по 50 мл, по 100 мл або по 150 мл у балоні з клапаном-пакетом, назальною насадкою - розпилювачем та захисним ковпачком; по 1 балону у коробці з картону
Країна-виробник: Україна
Реєстраційний номер: UA/12832/02/01
Склад діючих речовин: 1 мл препарату містить натрію хлориду 6,5 мг'),
	(3, 'Атоксіл', 209, 'Порошок по 10 г у флаконах № 1, по 2 г у пакетах-саше № 20
Країна-виробник: Україна
Реєстраційний номер: UA/2616/01/01
Склад діючих речовин: 1 флакон містить 10,0 г кремнію діоксиду (високодисперсного);1 пакет-саше містить 2,0 г кремнію діоксиду (високодисперсного).'),
	(3, 'Ентеросгель', 92, 'паста для перорального застосування, 70 г/100 г по 135 г або 270 г, або 405 г у контейнері; по 1 контейнеру в коробці з картону; по 15 г у пакеті; по 15 або 30 пакетів у коробці з картону
Країна-виробник: Україна
Реєстраційний номер: UA/4415/02/01
Склад діючих речовин: 100 г пасти містить гідрогель метилкремнієвої кислоти 70 г'),
	(3, 'Смекта', 86, 'Порошок для оральної суспензії по 3 г; по 3,76 г порошку у пакетику, по 10 або 30 пакетиків у коробці
Країна-виробник: Франція
Реєстраційний номер: UA/10103/01/01
Склад діючих речовин: 1 пакетик містить діосмектиту (смектиту діоктаедричного) 3 г'),
	(3, 'Біле вугілля', 54, 'таблетки, 210 мг №10 (10х1) або №24 (12х2) у блістері
Країна-виробник: Україна
Реєстраційний номер: UA/16126/01/01
Склад діючих речовин: 1 таблетка містить кремнію діоксиду колоїдного безводного 210 мг (у перерахунку на 100 % суху речовину)'),
	(4, 'Бронхипрет', 167, 'діючі речовини:1 таблетка, вкрита оболонкою, містить:
160 мг екстракту трави чебрецю сухого (4-8 : 1)(Herba Thymi vulgaris),
(екстрагент етанол 70 % (об/об));
60 мг екстракту коренів первоцвіту сухого (5,3-7,8 : 1)(Radix Primulae),
(екстрагент етанол 47,4 % (об/об));
Виробник/заявник.Біонорика СЕ/ Bionorica SE.'),
	(4, 'Гербіон', 120, 'Сироп по 150 мл у флаконі № 1
Країна-виробник: Словенія
Реєстраційний номер: UA/3751/01/01
Склад діючих речовин: 5 мл сиропу (1 мірна ложка) містять екстракт рідкий листя подорожника ланцетоподібного (Folium Plantaginis lanceolatae) (1:5) (екстрагент – вода) – 1,25 г; екстракт рідкий квіток мальви звичайної (Flo...'),
	(4, 'Гриппостад', 74, 'гранули для орального розчину, по 2,02 г у стік-пакетику; по 12 стік-пакетиків у картонній коробці
Країна-виробник: Німеччина
Реєстраційний номер: UA/17148/01/01
Склад діючих речовин: 1 стік-пакетик містить: парацетамолу 400 мг, аскорбінової кислоти 300 мг, кофеїну 50 мг, хлорфенаміну малеату 5 мг'),
	(4, 'Доктор Мом', 87, 'Сироп по 100 мл, 150 мл у флаконах № 1
Країна-виробник: Індія
Реєстраційний номер: UA/2408/02/01
Склад діючих речовин: 1сухий екстракт базиліку священного, сухий екстракт солодки голої, сухий екстракт куркуми довгої, сухий екстракт імбиру лікарського, сухий екстракт юстиції адатода, сухий екстракт пасльону індійського...'),
	(5, 'Анальгін', 9, 'Таблетки по 0,5 г № 10 у блістерах
Міжнародна непатентована назва (МНН): Metamizole sodium
Виробник: ТОВ "Тернофарм", Україна
Реєстраційний номер: UA/1410/01/01
Склад діючих речовин: 1 таблетка містить метамізолу натрію 0,5 г'),
	(6, 'Аспірин', 39, 'Таблетки по 500 мг № 10 (10х1), № 20 (10х2), № 100 (10х10) у блістерах
Міжнародна непатентована назва (МНН): Acetylsalicylic acid
Виробник: Байєр Біттерфельд ГмбХ, Німеччина
Реєстраційний номер: UA/4018/02/02
Склад діючих речовин: 1 таблетка містить 500 мг ацетилсаліцилової кислоти'),
	(6, 'Ацетилка', 12, 'таблетки шипучі по 500 мг; по 2 таблетки у стрипі; по 8 стрипів у коробці
Країна-виробник: Україна
Реєстраційний номер: UA/17131/01/01
Склад діючих речовин: 1 таблетка містить ацетилсаліцилової кислоти 500 мг'),
	(6, 'Упсарин Упса', 63, 'таблетки шипучі по 500 мг; по 4 таблетки у стрипі; по 4 стрипи у картонній коробці
Країна-виробник: Франція
Реєстраційний номер: UA/2308/01/01
Склад діючих речовин: 1 таблетка містить ацетилсаліцилової кислоти 500 мг'),
	(7, 'Димедрол', 185, 'Таблетки по 50 мг по 10 таблеток у контурній чарунковій упаковці; по1 контурній чарунковій упаковці в пачці; по 10 таблеток у контурних чарункових упаковках
Міжнародна непатентована назва (МНН): Diphenhydramine
Виробник: ПрАТ "Фармацевтична фірма "Дарниця", Україна
Реєстраційний номер: UA/4851/02/03
Склад діючих речовин: 1 таблетка містить: дифенгідраміну гідрохлориду – 50 мг'),
	(7, 'Драміна', 72, 'таблетки по 50 мг по 5 або по 10 таблеток у блістері; по 1 блістеру у картонній коробці
Країна-виробник: Хорватія
Реєстраційний номер: UA/8430/01/01
Склад діючих речовин: 1 таблетка містить дименгідринату 50 мг'),
	(8, 'Лоратадин', 14, 'Таблетки по 10 мг № 10 (10х1) у контурних чарункових упаковках
Міжнародна непатентована назва (МНН): Loratadine
Виробник: ПрАТ "Фармацевтична фірма "Дарниця", Україна
Реєстраційний номер: UA/2191/01/01
Склад діючих речовин: 1 таблетка містить лоратадину 10 мг'),
	(8, 'Кларитин', 94, 'таблетки по 10 мг по 7 або 10 таблеток у блістері; по 1 блістеру в картонній коробці
Країна-виробник: Бельгія
Реєстраційний номер: UA/10060/01/01
Склад діючих речовин: 1 таблетка містить лоратадину 10 мг'),
	(8, 'Лорфаст', 79, 'Таблетки по 10 мг, по 10 таблеток у блістері, по 1 блістеру в упаковці; по 50 таблеток у блістері, по 2 блістері в упаковці
Країна-виробник: Індія
Реєстраційний номер: UA/8107/01/01
Склад діючих речовин: 1 таблетка містить лоратадину 10 мг'),
	(9, 'Ізофра', 175, 'Спрей назальний, розчин 8000 МО/мл по 15 мл у флаконі з розпилювачем, по 1 флакону в картонній коробці
Міжнародна непатентована назва (МНН): Framycetin
Виробник: Софартекс, Франція
Реєстраційний номер: UA/2830/01/01
Склад діючих речовин: 1 мл розчину містить фраміцетину сульфату 12,5 мг (8000 МО)'),
	(9, 'Полідекса', 210, 'Спрей назальний, розчин по 15 мл у флаконі з розпилювачем, по 1 флакону в картонній коробці
Міжнародна непатентована назва (МНН): Dexamethasone, combinations
Виробник: Софартекс, Франція
Реєстраційний номер: UA/2831/01/01
Склад діючих речовин: 1 мл розчину містить неоміцину сульфату 6500 МО, поліміксину В сульфату 10000 МО, дексаметазону натрію метасульфобензоату 0,25 мг, фенілефрину гідрохлориду 2,5 мг')
;

# 25 medicine
INSERT INTO 
diagnosis(diagnosis_name, diagnosis_date, description, doctor_id, patient_id, feedback_id)
VALUES
	('Чума', '2019-07-12', "Остання 6 стадія чуми. Гострий біль в пятках та у носі.", 7, 9, 1),
	('Грип', '2019-07-12', "description description description", 2, 4, 2),
	('Застуда', '2019-07-12', "description description description", 3, 8, 3),
	('Розлад шлунку', '2019-07-12', "description description description", 4, 15, 4),
	('Гепатит', '2019-07-12', "description description description", 1, 20, 5),
	('Грип', '2019-07-12', "description description description", 1, 4, 6),
	('Застуда', '2019-07-12', "description description description", 4, 11, 7),
	('Закреп', '2019-07-12', "description description description", 4, 2, 8),
	('Туберкульоз', '2019-07-12', "description description description", 3, 8, 9),
	('Плоскостопість', '2019-07-12', "description description description", 3, 11, 10),

	('Застуда', '2019-07-12', "description description description", 4, 11, 11),
	('Бронхіт', '2019-07-12', "description description description", 6, 10, 12),
	('Гепатит', '2019-07-12', "description description description", 7, 13, 13),
	('Розлад шлунку', '2019-07-12', "description description description", 8, 15, 14),
	('Туберкульоз', '2019-07-12', "description description description", 4, 9, 15),
	('Грип', '2019-07-12', "description description description", 9, 6, 16),
	('Плоскостопість', '2019-07-12', "description description description", 8, 18, 17),
	('Бронхіт', '2019-07-12', "description description description", 5, 12, 18),
	('Закреп', '2019-07-12', "description description description", 9, 16, 19),
	('Застуда', '2019-07-12', "description description description", 5, 4, 20),

	('Чума', '2019-07-12', "Остання 6 стадія чуми. Гострий біль в пятках та у носі.", 4, 15, 21),
	('Грип', '2019-07-12', "description description description", 10, 10, 22),
	('Гепатит', '2019-07-12', "description description description", 11, 19, 23),
	('Вітрянка', '2019-07-12', "description description description", 4, 4, 24),
	('Серцева недостатність', '2019-07-12', "description description description", 2, 7, 25),
	('Плоскостопість', '2019-07-12', "description description description", 2, 14, 26),
	('Туберкульоз', '2019-07-12', "description description description", 1, 17, 27),
	('Закреп', '2019-07-12', "description description description", 2, 3, 28),
	('Чума', '2019-07-12', "Остання 6 стадія чуми. Гострий біль в пятках та у носі.", 10, 19, 29),
	('Гепатит', '2019-07-12', "description description description", 4, 17, 30),

	('Плоскостопість', '2019-07-12', "description description description", 4, 9, 31),
	('Застуда', '2019-07-12', "description description description", 9, 9, 32),
	('Розлад шлунку', '2019-07-12', "description description description", 7, 8, 33),
	('Бронхіт', '2019-07-12', "description description description", 7, 9, 34),
	('Грип', '2019-07-12', "description description description", 11, 20, 35),
	('Чума', '2019-07-12', "Остання 6 стадія чуми. Гострий біль в пятках та у носі.", 4, 20, 36),
	('Розлад шлунку', '2019-07-12', "description description description", 7, 14, 37),
	('Вітрянка', '2019-07-12', "description description description", 5, 4, 38),
	('Туберкульоз', '2019-07-12', "description description description", 9, 12, 39),
	('Бронхіт', '2019-07-12', "description description description", 9, 9, 40 ),

	('Плоскостопість', '2019-07-12', "description description description", 1, 5, 41),
	('Туберкульоз', '2019-07-12', "description description description", 7, 7, 42),
	('Туберкульоз', '2019-07-12', "description description description", 4, 8, 43),
	('Вітрянка', '2019-07-12', "description description description", 8, 16, 44),
	('Вітрянка', '2019-07-12', "description description description", 9, 9, 45),
	('Плоскостопість', '2019-07-12', "description description description", 7, 10, 46),
	('Чума', '2019-07-12', "Остання 6 стадія чуми. Гострий біль в пятках та у носі.", 5, 1, 47),
	('Чума', '2019-07-12', "Остання 6 стадія чуми. Гострий біль в пятках та у носі.", 6, 6, 48),
	('Вітрянка', '2019-07-12', "description description description", 7, 7, 49),
	('Розлад шлунку', '2019-07-12', "description description description", 6, 2, 50)
;

INSERT INTO
feedback(quality, feedback_comment, feedback_date)
VALUES
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-1'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-2'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-3'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-4'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-5'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-6'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-7'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-8'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-9'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-10'),

	('GREAT', "feedback comment feedback comment feedback comment ", '2017-06-11'),
	('GREAT', "feedback comment feedback comment feedback comment ", '2017-06-12'),
	('GREAT', "feedback comment feedback comment feedback comment ", '2017-06-13'),
	('GREAT', "feedback comment feedback comment feedback comment ", '2017-06-14'),
	('GREAT', "feedback comment feedback comment feedback comment ", '2017-06-15'),
	('GREAT', "feedback comment feedback comment feedback comment ", '2017-06-16'),
	('GREAT', "feedback comment feedback comment feedback comment ", '2017-06-17'),
	('GREAT', "feedback comment feedback comment feedback comment ", '2017-06-18'),
	('GREAT', "feedback comment feedback comment feedback comment ", '2017-06-19'),
	('GREAT', "feedback comment feedback comment feedback comment ", '2017-06-20'),

	('SATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-21'),
	('SATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-22'),
	('SATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-23'),
	('SATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-24'),
	('SATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-25'),
	('SATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-26'),
	('SATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-27'),
	('SATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-28'),
	('SATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-29'),
	('SATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-30'),

	('UNSATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-11'),
	('UNSATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-12'),
	('UNSATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-13'),
	('UNSATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-14'),
	('UNSATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-15'),
	('UNSATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-16'),
	('UNSATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-17'),
	('UNSATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-18'),
	('UNSATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-19'),
	('UNSATISFACTORILY', "feedback comment feedback comment feedback comment ", '2017-06-20'),

	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-21'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-22'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-23'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-24'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-25'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-26'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-27'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-28'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-29'),
	('GOOD', "feedback comment feedback comment feedback comment ", '2017-06-30')
;

# 13 doc 20 pat
INSERT INTO
doctor_patient(patient_id, doctor_id)
VALUES
(1, 3),
(1, 7),
(1, 2),
(2, 4),
(2, 2),
(2, 6),
(3, 12),
(3, 13),
(3, 5),
(4, 9),
(4, 8),
(4, 10),
(5, 10),
(5, 7),
(5, 5),
(6, 5),
(6, 6),
(6, 1),
(7, 4),
(7, 7),
(7, 8),
(8, 3),
(8, 4),
(8, 8),
(9, 1),
(9, 2),
(9, 6),
(10, 6),
(10, 5),
(10, 4),
(11, 3),
(12, 2),
(13, 1),
(14, 7),
(15, 8),
(16, 9),
(17, 10),
(18, 11),
(19, 12),
(20, 13)
;

INSERT INTO
medicine_diagnosis (diagnosis_id, medicine_id)
VALUES
(1, 2),
(1, 10),
(1, 5),
(2, 3),
(2, 8),
(2, 4),
(3, 7),
(3, 12),
(4, 14),
(4, 10),

(5, 7),
(5, 4),
(6, 6),
(6, 3),
(7, 5),
(7, 9),
(8, 11),
(8, 8),
(9, 1),
(9, 18),

(10, 14),
(10, 13),
(11, 8),
(11, 2),
(12, 1),
(12, 6),
(13, 9),
(13, 25),
(14, 21),
(14, 23),

(15, 3),
(15, 6),
(16, 9),
(16, 12),
(17, 15),
(17, 18),
(18, 2),
(18, 4),
(19, 8),
(19, 16),

(20, 5),
(20, 10),
(21, 15),
(21, 20),
(22, 6),
(22, 12),
(23, 18),
(23, 7),
(24, 14),
(24, 8),

(25, 16),
(25, 9),
(26, 10),
(26, 13),
(27, 11),
(27, 17),
(28, 19),
(28, 20),
(29, 1),
(29, 5),

(30, 9),
(30, 18),
(31, 9),
(31, 5),
(32, 1),
(32, 7),
(33, 6),
(33, 3),
(34, 21),
(34, 23),

(35, 25),
(35, 21),
(36, 14),
(36, 23),
(37, 24),
(37, 21),
(38, 11),
(38, 22),
(39, 23),
(39, 19),

(40, 2),
(40, 14),
(41, 6),
(41, 18),
(42, 10),
(42, 22),
(43, 14),
(43, 24),
(44, 18),
(44, 25),

(45, 1),
(45, 23),
(46, 5),
(46, 17),
(47, 3),
(47, 11),
(48, 9),
(48, 15),
(49, 7),
(49, 19),
(50, 21),
(50, 13)
;
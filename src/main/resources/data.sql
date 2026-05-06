-- =========================
-- TIPOS BÁSICOS
-- =========================

INSERT INTO vehicle_type (type) VALUES  
('CARRO'), ('MOTO'), ('BICICLETA'), ('VEHICULO_PESADO');

INSERT INTO parking_type (type) VALUES  
('CUBIERTO'), ('SEMICUBIERTO'), ('DESCUBIERTO');

INSERT INTO slot_status (status) VALUES  
('EMPTY'), ('FULL');

-- =========================
-- CIUDADES
-- =========================

INSERT INTO city (city) VALUES
('Bogotá D.C.'), ('Medellín'), ('Cali'), ('Barranquilla'), ('Cartagena'),
('Cúcuta'), ('Bucaramanga'), ('Pereira'), ('Santa Marta'), ('Ibagué'),
('Manizales'), ('Villavicencio'), ('Neiva'), ('Armenia'), ('Pasto'),
('Montería'), ('Sincelejo'), ('Valledupar'), ('Quibdó'), ('Riohacha'),
('Tunja'), ('Florencia'), ('Popayán'), ('San Andrés'), ('Mitú'),
('Mocoa'), ('Inírida'), ('Leticia'), ('Yopal');

-- =========================
-- ROLES Y PERMISOS
-- =========================

INSERT INTO role (role_name) VALUES  
('GERENTE'), ('ADMINISTRADOR'), ('USUARIO');

INSERT INTO permission (permission_name, description) VALUES
('MANAGE', 'CRUD de usuarios'),
('PARKING', 'Gestión de parqueaderos'),
('REPORTS', 'Reportes y estadísticas'),
('BOOKING', 'Gestión de reservas propias');

INSERT INTO role_permission (role_id, permission_id) VALUES
(1,1),(1,2),(1,3),(1,4),
(2,2),(2,3),(2,4),
(3,4);

-- =========================
-- USUARIOS
-- =========================

INSERT INTO users (email, password, first_name, second_name, first_lastname, second_lastname, account_active) VALUES
('colombiafourparks@gmail.com', '$2a$12$p/If5oGCgdEnstBg7V9SQe5Wyq34KGK9bcdDCZRTs/lCQZdfsFGqK', 'Elmer', '', 'Figueroa', 'Arce', true),
('chrodrigueza@gmail.com', '$2a$12$p/If5oGCgdEnstBg7V9SQe5Wyq34KGK9bcdDCZRTs/lCQZdfsFGqK', 'Claudia', 'Helena', 'Rodríguez', 'Ávila', true),
('lihernandezr@gmail.com', '$2a$12$p/If5oGCgdEnstBg7V9SQe5Wyq34KGK9bcdDCZRTs/lCQZdfsFGqK', 'Laura', 'Isabel', 'Hernández', 'Ramírez', true),
('lagarciaf@gmail.com', '$2a$12$p/If5oGCgdEnstBg7V9SQe5Wyq34KGK9bcdDCZRTs/lCQZdfsFGqK', 'Luis', 'Alberto', 'García', 'Fernández', true),
('asmartinezl@gmail.com', '$2a$12$p/If5oGCgdEnstBg7V9SQe5Wyq34KGK9bcdDCZRTs/lCQZdfsFGqK', 'Ana', 'Sofía', 'Martínez', 'López', true),
('jsrodriguezs@gmail.com', '$2a$12$p/If5oGCgdEnstBg7V9SQe5Wyq34KGK9bcdDCZRTs/lCQZdfsFGqK', 'Juan', 'Sebastián', 'Rodríguez', 'Sánchez', true),
('user@gmail.com', '$2a$12$p/If5oGCgdEnstBg7V9SQe5Wyq34KGK9bcdDCZRTs/lCQZdfsFGqK', 'Andrés', '', 'Jiménez', 'Mantilla', true);

-- =========================
-- USER ROLES
-- =========================

INSERT INTO user_role (user_id, role_id) VALUES
(1,1),
(2,2),(3,2),(4,2),(5,2),(6,2),
(7,3);

-- =========================
-- TARJETAS
-- =========================

INSERT INTO credit_card (user_id, card_number, expiration_date, cvv) VALUES
(1,'1111222233334444','12/25','123'),
(1,'5555666677778888','10/24','456'),
(2,'2222111133334444','05/26','789'),
(3,'9999888877776666','08/26','123'),
(4,'8888999977776666','07/26','321'),
(5,'4444888877776666','06/27','741'),
(6,'3333888877776666','04/26','963'),
(7,'3333444455556666','09/25','345');

-- =========================
-- HORARIOS Y UBICACIONES
-- =========================

INSERT INTO opening_hours (open_time, close_time) VALUES
('04:00','23:00'),
('06:00','23:59'),
('08:00','22:00'),
('10:00','18:00'),
('23:59','00:00');

INSERT INTO location (address, latitude, longitude, city_id) VALUES
('Cra. 8 #42-36',4.629744,-74.065706,1),
('Cll. 58 #35a-41',4.648625,-74.080508,1),
('Cll. 52 #70c-2',4.667980,-74.105721,1),
('Cll. 101 #13-41',4.684511,-74.045931,1),
('Cra. 29a Bis #22c-1',4.622206,-74.084291,1);

-- =========================
-- PARQUEADEROS
-- =========================

INSERT INTO parking(available_slots,car_slots,motorcycle_slots,bicycle_slots,heavy_vehicle_slots,loyalty,name,total_slots,admin_id,location_id,opening_hours_id,parking_type_id) VALUES
(10,2,2,2,2,true,'Cuatro Parques',10,2,1,1,1),
(20,10,2,2,6,false,'Park & Go',20,3,2,2,2),
(15,5,3,3,4,true,'AutoPARK',15,4,3,3,3),
(20,5,5,5,5,false,'Parqueadero Seguro',20,5,4,4,1),
(10,2,2,2,2,true,'ParkSmart',10,6,5,5,2);

-- =========================
-- SLOTS
-- =========================

INSERT INTO parking_slot(parking_id, slot_status_id, vehicle_type_id) VALUES
(1,1,1),(1,1,1),(1,1,2),(1,1,2),(1,1,3),(1,1,3),(1,1,4),(1,1,4),
(2,1,1),(2,1,1),(2,1,1),(2,1,1),(2,1,1),(2,1,1),(2,1,1),(2,1,1),(2,1,1),(2,1,1),
(2,1,2),(2,1,2),(2,1,3),(2,1,3),(2,1,4),(2,1,4),(2,1,4),(2,1,4),(2,1,4),(2,1,4),
(3,1,1),(3,1,1),(3,1,1),(3,1,1),
(3,1,2),(3,1,2),(3,1,3),(3,1,3),
(3,1,4),(3,1,4),(3,1,4),(3,1,4),
(4,1,1),(4,1,1),(4,1,1),(4,1,1),(4,1,1),
(4,1,2),(4,1,2),(4,1,2),(4,1,2),(4,1,2),
(4,1,3),(4,1,3),(4,1,3),(4,1,3),(4,1,3),
(4,1,4),(4,1,4),(4,1,4),(4,1,4),(4,1,4),
(5,1,1),(5,1,1),(5,1,2),(5,1,2),(5,1,3),(5,1,3),(5,1,4),(5,1,4);

-- =========================
-- TARIFAS
-- =========================

INSERT INTO parking_rate (rate, parking_id, vehicle_type_id) VALUES
(163,1,1),(114,1,2),(10,1,3),(300,1,4),
(120,2,1),(85,2,2),(10,2,3),(200,2,4),
(279,3,1),(195,3,2),(10,3,3),(250,3,4),
(130,4,1),(90,4,2),(10,4,3),(350,4,4),
(150,5,1),(100,5,2),(10,5,3),(280,5,4);

COMMIT;
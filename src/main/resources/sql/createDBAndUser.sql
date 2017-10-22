CREATE DATABASE cookbook;
CREATE USER cookbook IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON cookbook . * TO cookbook;
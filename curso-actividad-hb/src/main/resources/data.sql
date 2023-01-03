--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS employee;

CREATE TABLE student (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(45) DEFAULT NULL,
  last_name VARCHAR(45) DEFAULT NULL,
  company VARCHAR(45) DEFAULT NULL
);


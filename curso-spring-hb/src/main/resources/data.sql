--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS student;

CREATE TABLE student (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(45) DEFAULT NULL,
  last_name VARCHAR(45) DEFAULT NULL,
  email VARCHAR(45) DEFAULT NULL
);


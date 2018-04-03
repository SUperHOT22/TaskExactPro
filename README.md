# TaskExactPro
Таблица была создана в БД MySQL ниже представлен код:


CREATE TABLE user
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    text VARCHAR(300) NOT NULL
);

так же необходимо изменить значение полей  
        <property name="connection.url">jdbc:mysql://localhost:3306/ExactProtest</property>
        <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="connection.username">root</property>
        <property name="connection.password">komajavadev</property> 
        в файле hibernate.cfg.xml

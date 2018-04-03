# TaskExactPro
Таблица была создана в БД MySQL ниже представлен код:


CREATE TABLE user
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    text VARCHAR(300) NOT NULL
);

так же необходимо изменить значение внутри тегов 
  		<property name="connection.url"></property>
        <property name="connection.driver_class"></property>
        <property name="connection.username"></property>
        <property name="connection.password"></property>
		 в файле src/main/java/resources/hibernate.cfg.xml на актуальные для вашей базы данных

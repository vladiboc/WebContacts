# Проект WebContacts<br><font size='5em'>(вэб-приложение список контактов)</font>
## Описание проекта
Проект представляет собой вэб-приложение, использующее стартеры:
- Spring Boot Thymeleaf - для фронтенда
- Spring Boot Web - для бэкенда
- Spring Boot Jdbc - для соединения с СУБД PostgreSQL

Приложение позволяет:
- просмотривать в браузере список всех имеющихся контактов
- добавлять новый контакт используя специальную форму в браузере
- редактировать контакт используя специальную форму в браузере
- удалять контакт кнопкой в браузере

## Стек технологий
- Java 17
- SpringFramework Boot 3.2.2
- Gradle 8.5
- Docker 24.0.7
- Docker Compose 2.20.2
- PostgreSQL 12.3

## Инструкция по локальному запуску приложения

Приложение webcontacts запускается как JAR-файл и взаимодействует с предварительно запущенной БД PostgreSQL.
Последовательность шагов для запуска приложения:

**I Запуск СУБД PostgreSQL**  
1. Создайте на локальной машине директорию для запуска СУБД PostgreSQL. Скачайте туда следующие всё содержимое папки docker_db/ из корня репозитория проекта:
    - **docker-compose.yml** - файл докер-композиции запуска СУБД PostgreSQL
    - **init.sql/** - директория с SQL-скриптами инициализации БД приложения, в том числе:
    - **init.sql/00_role_db.sql** - создание пользователя, установка пароля и прав на БД
    - **init.sql/01_schema.sql** - создание в БД схемы и таблицы для приложения
    - **init.sql/02_insert_data.sql** - первоначальное заполнение БД, содержимое этого файла можно поменять или удалить
2. Убедитесь, чно на локальной машине установлены Docker и Docker Compose, перейдите в директорию запуска СУБД PostgreSQL, и запустите композицию СУБД PostgreSQL командой:  
```$ docker compose up -d```  
СУБД PostgreSQL запустится на локальной машине и будет слушать запросы на порту 5432, как указано в файле композиции.  

**II Запуск приложения**  
1. Убедитесь, что на локальной машине установлена Java 17.  
Создайте на локальной машине директорию запуска приложения, и скачайте в эту директорию следующие файлы из корня репозитория проекта:
    - **webcontacts-0.0.1.jar** - JAR-файл - Java-архив приложения
    - **application.yaml** - файл настроек приложения  
2. В той же директории запуска приложения выполните следующую команду:  
    ``` java -jar webcontacts-0.0.1.jar ```  
    Приложение запустится и будет доступно из браузера по URL http://localhost:8888/  

**III Настройки приложения**  

Настройки приложения задаются в файле **application.yaml**, скачанном и корня репозитория в директорию запуска приложения. Доступны для изменения следующие настройки:  
- порт запуска приложения - по умолчанию 8888  
- уровень логирования приложения - по умолчанию DEBUG  
- параметры подключения к СУБД  

## Описание работы приложения
Все команды, выполняемые приложением, доступны через кнопки в вэб-интерфейсе приложения.  
Это создание, редактирование и удаление записи в списке контактов.  
Пре создании или редактировании контакта выполняется проверка ввода в поля формы создания/редактирования.  
Приложение выводит информацию о правилах заполнения и возможных ошибках ввода.
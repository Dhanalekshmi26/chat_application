# Java Chat Application

A simple chat application built with:
- **Spring Boot** (Java backend)
- **MySQL** (database)
- **HTML/CSS/JavaScript** (frontend)

This project allows users to:
- Register users (via the database)
- Send messages to other users
- View conversations between users

---

## ✨ Features
✅ Send messages  
✅ View message history between any two users  
✅ Simple HTML frontend interfaces  
✅ Messages stored in MySQL with timestamps and seen status  

---

## 📂 Project Structure
├── src/main/java/com/example/chatapp/
│ ├── ChatAppApplication.java // Spring Boot main class
│ ├── controller/
│ │ └── MessageController.java // REST API controller
│ ├── model/
│ │ ├── Message.java // JPA entity for messages
│ │ └── User.java // JPA entity for users
│ ├── repository/
│ │ ├── MessageRepository.java // Repository for messages
│ │ └── UserRepository.java // Repository for users
│
├── src/main/resources/
│ └── application.properties // Database config
│
├── frontend/
│ ├── send-message.html // Page to send messages
│ └── view-messages.html // Page to view conversations

yaml

---

## ⚙️ Setup Instructions

### 1️⃣ Prerequisites
- Java 17+
- Maven
- MySQL

---

### 2️⃣ Database Setup

1. Create a database:
   ```sql
   CREATE DATABASE chatdb;

2.Tables are auto-created by JPA (User and Message).
spring.datasource.url=jdbc:mysql://localhost:3306/chatdb
spring.datasource.username=your_mysql_user
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update

3.Tables are auto-created by JPA (User and Message).

3️⃣ Build & Run Backend
From the project root:
mvn clean install
mvn spring-boot:run

The API runs on:
http://localhost:8080

4️⃣ Using the Frontend
You can open the HTML files directly with Live Server or any static server:

Send Message: send-message.html
View Messages: view-messages.html


## 🙌 Contributions

This is a personal learning repo, but if you’re also learning Java and want to suggest ideas, feel free to open an issue or PR!

---

**Made with 💻 by Dhanalekshmi Vipinkumar**  
🔗 [Visit My GitHub](https://github.com/Dhanalekshmi26)



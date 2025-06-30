# Java Chat Application

## 🟢 **Step 1: Project Initialization**

✅ **Created Spring Boot Project**

* You initialized a Maven-based Spring Boot project.
* Added dependencies:

  * **Spring Web** (for REST API)
  * **Spring Data JPA** (for database interaction)
  * **MySQL Connector** (for MySQL)

✅ **Configured application.properties**

* Set MySQL connection details:

  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/chatdb
  spring.datasource.username=your_mysql_user
  spring.datasource.password=your_mysql_password
  spring.jpa.hibernate.ddl-auto=update
  ```
* `ddl-auto=update` made JPA auto-create tables.

---

## 🟢 **Step 2: Database Setup**

✅ **Created MySQL Database**

```sql
CREATE DATABASE chatdb;
```

✅ **Verified Connection**

* On application startup, JPA created `messages` and `users` tables.

---

## 🟢 **Step 3: Defined Data Models**

✅ **Created `User` Entity**

* Mapped to `users` table.
* Fields:

  * `id` (PK)
  * `username`
  * `password`
  * `profile_picture_url`
  * `theme`

✅ **Created `Message` Entity**

* Mapped to `messages` table.
* Fields:

  * `id` (PK)
  * `senderUsername`
  * `receiverUsername`
  * `content`
  * `timestamp`
  * `seen` (boolean)

---

## 🟢 **Step 4: Repositories**

✅ **Created Repositories**

* `UserRepository` extends `JpaRepository<User, Long>`
* `MessageRepository` extends `JpaRepository<Message, Long>`

  * Custom method to get conversation between two users:

    ```java
    List<Message> findBySenderUsernameAndReceiverUsernameOrSenderUsernameAndReceiverUsernameOrderByTimestampAsc(
        String sender1, String receiver1, String sender2, String receiver2
    );
    ```

---

## 🟢 **Step 5: REST Controller**

✅ **Built `MessageController`**

* **POST /api/messages/send**
  To save a message.
* **GET /api/messages/conversation/{sender}/{receiver}**
  To fetch conversation history.

Example:

```java
@PostMapping("/send")
public Message sendMessage(@RequestBody Message message) {
    message.setTimestamp(LocalDateTime.now());
    return messageRepository.save(message);
}
```

---

## 🟢 **Step 6: Frontend Pages**

✅ **Created `send-message.html`**

* Simple form to send messages (sender, receiver, content).
* JavaScript `fetch()` to POST to API.

✅ **Created `view-messages.html`**

* Input sender & receiver usernames.
* Load messages with `fetch()` GET request.
* Displayed messages in a styled card.

---

✅ **Removed Avatar Feature**

* Originally messages had avatars.
* Later, you **removed all avatar-related code and styles**, showing only text.

---

## 🟢 **Step 7: Testing & Iteration**

✅ **You tested thoroughly:**

* Ran `mvn spring-boot:run`.
* Used **Live Server** (`localhost:5500`) to host HTML.
* Verified messages in MySQL with:

  ```sql
  SELECT * FROM chatdb.messages;
  ```
* Confirmed working CRUD.

✅ **Fixed Issues:**

* No image placeholders.
* Encoding issues in message content.
* CORS errors (if any) resolved with Spring config.

---

## 🟢 **Step 8: Final Touches**

✅ Cleaned code.
✅ Created README.
✅ Ready to push to GitHub.

---

### ✨ **In Short:**

**You built a RESTful chat app:**

* Backend: Spring Boot + JPA + MySQL.
* Frontend: Plain HTML/CSS/JS.
* Data flows:

  * Frontend sends message JSON → API → DB.
  * Frontend fetches message list → displays it.

---

## 🙌 Contributions

This is a personal learning repo, but if you’re also learning Java and want to suggest ideas, feel free to open an issue or PR!

---

**Made with 💻 by Dhanalekshmi Vipinkumar**  
🔗 [Visit My GitHub](https://github.com/Dhanalekshmi26)



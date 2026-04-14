# 🎓 CRUD Student System
A simple yet powerful **CRUD (Create, Read, Update, Delete)** application built using **Spring Boot** and **Hibernate (JPA)** to manage student records in a database.

---

## 🚀 Features

✨ This project allows you to:

- ➕ **Create** new students  
- 🔍 **Read** and display all students  
- ✏️ **Update** existing student information  
- ❌ **Delete** students from the database  

All operations are handled through a clean **Command Line Interface (CLI)**.

---

## 🛠️ Technologies Used

- ☕ Java  
- 🌱 Spring Boot  
- 🗄️ Hibernate (JPA)  
- 🧩 Maven  
- 💾 Relational Database (MySQL / H2)

---

## 📂 Project Structure

```
com.menna.cruddemo 
│── dao 
│     ├── StudentDAO.java 
│     ├── StudentDAOImp.java 
│ 
│── entity 
│     └── Student.java 
│ 
│── CruddemoApplication.java
```

---

## ▶️ How It Works

When you run the application, you will see a menu like this:

```
===== Welcome to Crud Demo Application =====
=== Menu ===
1. Create Student
2. Update Student
3. Delete Student
4. Print All Students
5. Exit
```

You can interact with the system by entering your choice.

---

## 🧪 Example Usage

### ➕ Create Student

```
Enter first name: Menna
Enter last name: AbdElGawad
Enter email: menna@gmail.com
```

### 📋 Display Students

```
ID: 1
Name: Menna AbdElGawad
Email: menna@gmail.com
```

---

## ⚙️ Setup & Run

### 1. Clone the repository

```bash
git clone https://github.com/Menna-AbdElGawad/CRUD-Student-System.git
```

### 2. Navigate to project folder

```bash
cd CRUD-Student-System
```

### 3. Run the application

```bash
./mvnw spring-boot:run
```

or run it directly from your IDE (IntelliJ / Eclipse)

---

## 💡 Key Concepts Applied

- DAO Pattern  
- Dependency Injection  
- Hibernate ORM  
- Spring Boot Auto Configuration  
- CommandLineRunner for CLI interaction  

---

## 📌 Future Improvements

🚧 Possible enhancements:

- Add REST API (instead of CLI)  
- Add validation for inputs  
- Build a frontend (React / Angular)  
- Pagination & search  

---

## 👩‍💻 Author

**Menna AbdElGawad**  
Computer Science Student 💻  

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!

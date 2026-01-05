# 📚 Library Management System (JDBC)

A r Java application for managing library operations, built using Core Java and JDBC with MySQL connectivity.

##  Features
- Add Books: Register new books into the system.
- Member Management: Add and update library members.
- Transaction Handling: Issue and return books with date tracking.
- Search: Find books by title or author.
- Secure Configuration: Database credentials are not hardcoded (security best practice).

##  Technologies Used
-  Java (JDK 17+)
-  MySQL 8.0+
-  JDBC (Java Database Connectivity)
-  Maven

##  Setup & Installation

### 1. Database Setup
This project includes a SQL script to set up the database structure automatically.

1. Open **MySQL Workbench**.
2. Go to **Server** > **Data Import**.
3. Select **Import from Self-Contained File** and choose the `library.sql` file located in this project folder.
4. Click **Start Import**.
  

### 2. Configure Credentials (Important!)
For security reasons, the database password is **not** included in this repository. You must configure it locally.

1. Navigate to `src/main/resources/`.
2. Create a new file named `db.properties`.
3. Paste the following configuration into the file and **replace** the password with your local MySQL password:

db.properties:
db.url=jdbc:mysql://localhost:3306/your_database_URL
db.username=YOUR_DATABSE-USERNAME
db.password=YOUR_ACTUAL_PASSWORD

# 🛒 SpringEcom — Full Stack E-Commerce Application

SpringEcom is a full-stack e-commerce web application built using **Spring Boot, React, MySQL, and Maven**.

The application provides product management, product search, shopping cart functionality, checkout/order placement, order management, and product image handling.

---

## 📌 Features

### 🛍️ Product Management

* View all products
* View product details
* Add new products
* Update existing products
* Delete products
* Upload product images
* Display product availability and stock
* Product categories

### 🔎 Product Search

* Search products by keyword
* Search by:

  * Product name
  * Description
  * Brand
  * Category
* Case-insensitive search

### 🛒 Shopping Cart

* Add products to cart
* Manage product quantities
* Calculate cart total
* Remove products from cart
* Persistent cart using browser local storage

### 💳 Checkout & Orders

* Customer name and email
* Place orders
* Generate unique order IDs
* Check product stock before placing an order
* Automatically reduce stock after successful order
* View all placed orders
* Calculate order subtotal and total

### 🎨 User Interface

* Responsive React UI
* Bootstrap-based components
* Light/Dark theme
* Product cards
* Search results page
* Loading indicators
* Toast notifications

---

# 🏗️ Project Architecture

```text
SpringEcom
│
├── Backend
│   ├── Spring Boot
│   ├── Spring MVC
│   ├── Spring Data JPA
│   ├── Hibernate
│   └── MySQL
│
└── Frontend
    ├── React
    ├── Vite
    ├── Axios
    └── Bootstrap
```

### Backend Flow

```text
React Frontend
      ↓
REST API
      ↓
Controller
      ↓
Service
      ↓
Repository
      ↓
Hibernate / JPA
      ↓
MySQL Database
```

---

# 🛠️ Technologies Used

## Backend

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate
* Maven
* MySQL
* REST API

## Frontend

* React
* Vite
* JavaScript
* Axios
* React Router
* React Bootstrap / Bootstrap
* React Toastify
* CSS

---

# 📋 Prerequisites

Before running the project, install the following:

### Backend

* Java JDK 21
* Maven
* MySQL

Check Java:

```bash
java -version
```

Check Maven:

```bash
mvn -version
```

Check MySQL:

```bash
mysql --version
```

### Frontend

* Node.js
* npm

Check:

```bash
node -v
npm -v
```

---

# 🗄️ MySQL Database Setup

Start your MySQL server.

Login to MySQL:

```bash
mysql -u root -p
```

Create the database:

```sql
CREATE DATABASE springecom;
```

Verify:

```sql
SHOW DATABASES;
```

Select the database:

```sql
USE springecom;
```

---

# ⚙️ Backend Configuration

Open the Spring Boot project's:

```text
src/main/resources/application.properties
```

Configure MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springecom
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true
```

Replace:

```text
YOUR_MYSQL_PASSWORD
```

with your actual MySQL password.

> If your MySQL username is not `root`, change it accordingly.

---

# 🚀 Running the Backend

Navigate to the Spring Boot project directory.

### Using Maven Wrapper

On Windows:

```bash
mvnw.cmd spring-boot:run
```

On Linux/macOS:

```bash
./mvnw spring-boot:run
```

### Using Maven

```bash
mvn spring-boot:run
```

The backend should start at:

```text
http://localhost:8080
```

---

# 🌐 Backend API

The backend exposes REST APIs under:

```text
/api
```

## Product APIs

### Get all products

```http
GET /api/products
```

### Get product by ID

```http
GET /api/product/{id}
```

### Add product

```http
POST /api/product
```

Uses `multipart/form-data` for product information and image upload.

### Update product

```http
PUT /api/product/{id}
```

### Delete product

```http
DELETE /api/product/{id}
```

### Search products

```http
GET /api/product/search?keyword=lenovo
```

The search checks:

```text
name
description
brand
category
```

Example:

```text
http://localhost:8080/api/product/search?keyword=lenovo
```

---

# 📦 Order APIs

### Place an order

```http
POST /api/place
```

Example request:

```json
{
  "customerName": "Ahana",
  "email": "example@gmail.com",
  "items": [
    {
      "productId": 1,
      "quantity": 2
    }
  ]
}
```

### Get all orders

```http
GET /api/orders
```

---

# 💻 Running the Frontend

Open a new terminal and navigate to the React project.

Install dependencies:

```bash
npm install
```

Create a `.env` file in the frontend project:

```env
VITE_BASE_URL=http://localhost:8080
```

Then start the development server:

```bash
npm run dev
```

Vite will display the local URL, usually:

```text
http://localhost:5173
```

Open it in your browser.

---

# 🔗 Frontend → Backend Connection

The React application uses Axios to communicate with the Spring Boot REST API.

The base URL is configured using:

```env
VITE_BASE_URL=http://localhost:8080
```

For example:

```javascript
const baseUrl = import.meta.env.VITE_BASE_URL;

axios.get(`${baseUrl}/api/products`);
```

Product search:

```javascript
axios.get(
    `${baseUrl}/api/product/search?keyword=${encodeURIComponent(keyword)}`
);
```

---

# 📁 Suggested Project Structure

```text
SpringEcom/
│
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── telusko/
│   │   │   │           └── SpringEcom/
│   │   │   │               ├── controller/
│   │   │   │               ├── model/
│   │   │   │               ├── repository/
│   │   │   │               └── service/
│   │   │   │
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   │
│   │   └── test/
│   │
│   └── pom.xml
│
└── frontend/
    ├── src/
    │   ├── assets/
    │   ├── components/
    │   ├── pages/
    │   ├── App.jsx
    │   └── main.jsx
    │
    ├── .env
    ├── package.json
    └── vite.config.js
```

> Folder names may differ depending on how the project is organized locally.

---

# 🔄 Complete Application Flow

### 1. Product Browsing

```text
User
 ↓
React
 ↓
GET /api/products
 ↓
ProductController
 ↓
ProductService
 ↓
ProductRepo
 ↓
MySQL
 ↓
Products displayed
```

### 2. Product Search

```text
User enters keyword
        ↓
React Search Bar
        ↓
GET /api/product/search?keyword=lenovo
        ↓
ProductController
        ↓
ProductService
        ↓
ProductRepo
        ↓
JPQL Query
        ↓
MySQL
        ↓
Matching products
        ↓
Search Results Page
```

### 3. Order Placement

```text
User
 ↓
Cart
 ↓
Checkout
 ↓
POST /api/place
 ↓
OrderController
 ↓
OrderService
 ↓
Check product
 ↓
Check stock
 ↓
Reduce stock
 ↓
Create Order
 ↓
Create OrderItems
 ↓
MySQL
 ↓
Order confirmation
```

---

# 🔐 Environment Variables

Do not commit passwords or sensitive configuration to GitHub.

For the frontend:

```env
VITE_BASE_URL=http://localhost:8080
```

For the backend, you can use environment variables instead of hardcoding your MySQL password:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springecom
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Then configure:

```text
DB_USERNAME=root
DB_PASSWORD=your_password
```

---

# 🧪 Testing the Backend

You can test the REST APIs using:

* Postman
* Browser
* Thunder Client
* Insomnia

For example:

```http
GET http://localhost:8080/api/products
```

Search:

```http
GET http://localhost:8080/api/product/search?keyword=laptop
```

Orders:

```http
GET http://localhost:8080/api/orders
```

---

# 🐛 Common Problems

## MySQL connection refused

If you see:

```text
Communications link failure
Connection refused
```

make sure the MySQL server is running.

Also verify:

```text
localhost:3306
```

and your username/password.

---

## 404 when searching products

Make sure the frontend uses:

```text
/api/product/search
```

not:

```text
/api/products/search
```

The backend endpoint is:

```java
@GetMapping("/product/search")
```

with:

```java
@RequestMapping("/api")
```

Therefore:

```text
/api/product/search
```

---

## CORS error

The Spring Boot controllers should allow requests from the React frontend.

For development, `@CrossOrigin` can be used on the controller.

For production, configure CORS properly for the deployed frontend domain.

---

## Frontend cannot connect to backend

Check that:

```text
Backend → http://localhost:8080
Frontend → http://localhost:5173
```

is running.

Also check:

```env
VITE_BASE_URL=http://localhost:8080
```

After changing `.env`, restart Vite.

---

# 📌 Future Improvements

Possible improvements for future versions:

* User authentication and authorization
* JWT-based login
* Admin dashboard
* Payment gateway integration
* Product reviews and ratings
* Wishlist
* Order tracking
* Pagination
* Advanced product filtering
* Better image storage using cloud storage
* Product recommendations
* Email order confirmation
* Docker support
* Deployment to cloud
* Unit and integration testing
* Spring Security
* Role-based access control

---

# 👩‍💻 Author

**Ahana Mohanta**

B.Tech — Computer Science & Engineering

---

# 📄 License

This project is created for learning and educational purposes.


# Crypto Portfolio Tracker 💰🚀

A full-stack web application to manage your cryptocurrency portfolio. Built using React + Spring Boot with JWT authentication.

---

## 🧰 Tech Stack

- **Frontend**: React, Axios
- **Backend**: Spring Boot, Spring Security, JWT
- **Database**: H2 (for development)
- **Authentication**: JWT

---

## 🚀 How to Run the Project

### 🔧 Backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run

Runs at: http://localhost:8080

💻 Frontend (React)
cd frontend
npm install
npm start
Runs at: http://localhost:3000



📬 API Endpoints

| Endpoint             | Method | Description            |
| -------------------- | ------ | ---------------------- |
| `/api/auth/register` | POST   | Register a new user    |
| `/api/auth/login`    | POST   | Login and get token    |
| `/api/portfolio`     | GET    | Get user portfolio     |
| `/api/insights`      | GET    | Get portfolio insights |


🛠️ Features
JWT-authenticated user login

Portfolio creation and retrieval

Secure REST APIs

CORS enabled for frontend/backend

📄 License
MIT License


👨‍💻 Author
Made by [Karunakar Reddy Kalla] 😊

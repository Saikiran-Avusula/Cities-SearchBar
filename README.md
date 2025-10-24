<!-- @format -->

# Cities-SearchBar-Demo

## Project Overview

This is a simple web app that lets users search for city names using a search bar. As you type, the app shows auto-suggestions based on city names stored in the backend. Clicking a suggested city fills the search box and shows a confirmation message below the bar.

The goal is to provide a fast, interactive search experience and show how a React frontend connects to a Spring Boot backend with a MySQL database.

---

## Features

- Auto-suggestions while typing.
- Click to select a suggestion and show a confirmation message.
- Live search: suggestions are fetched from the backend as you type.
- Backend-ready: Spring Boot REST APIs connected to MySQL.

---

## Technologies Used

- Frontend: React, Vite, JSX, HTML, CSS
- Backend: Spring Boot, Java
- Database: MySQL
- Other: Fetch API for frontend-backend calls, SLF4J for logging

---

## Project Structure

### Backend (Spring Boot)

- `model/` – entity classes for cities.
- `repository/` – JPA repositories to query the database.
- `service/` – business logic for fetching cities.
- `controller/` – REST API endpoints the frontend calls.

### Frontend (React)

- `src/components/` – `SearchBar.jsx` handles input and suggestions.
- `src/styles/` – theme and UI styles (`theme.css`).
- `src/App.jsx` – main app component rendering the search bar.

---

## Setup Instructions

### Backend

1. Make sure MySQL is running and create a database named `hotel_locations_db`.
2. Update `application.properties` (or `application.yml`) with your MySQL credentials.
3. Run the Spring Boot application.
4. Backend API endpoints (examples):
   - `GET /cities/getAllCities` – returns all cities.
   - `GET /cities/suggest?keyword=<term>` – returns cities that match the input term.

### Frontend

1. Open a terminal and go to the frontend folder:

```powershell
cd city-search
```

2. Install dependencies:

```powershell
npm install
```

3. Start the dev server:

```powershell
npm run dev
```

4. Open the app in your browser (default Vite URL):

http://localhost:5173

---

## How to Use

- Type a city name into the search bar.
- Auto-suggestions appear below the input.
- Click a suggestion to select it; a confirmation message appears below the search bar.
- Toggle light/dark theme using the theme button.

---

<!-- <img width="1269" height="531" alt="image" src="https://github.com/user-attachments/assets/34972425-9069-462b-8092-4657b52f62dc" />
<img width="1636" height="679" alt="image" src="https://github.com/user-attachments/assets/2be05619-4a41-4c4c-a05c-cf64dcc6e8b0" />
<img width="1163" height="659" alt="image" src="https://github.com/user-attachments/assets/dcf64ca7-9ebe-4387-8b35-83a5fbb20c43" />
<img width="1373" height="703" alt="image" src="https://github.com/user-attachments/assets/4b1a980e-a564-4e41-90d7-428e152ffa24" /> -->

---

## Future Improvements

- Highlight matching characters in suggestions.
- Keyboard navigation (arrow keys + Enter to select).
- Show a clear "No results found" message when there are no matches.
- Animate the suggestion dropdown for a smoother UI.
- Integrate external city APIs for live data.

---

# Cities-SearchBar-Demo

## Project Overview
This project is a simple web application that lets users search for city names in a search bar. As the user types, it shows **auto-suggestions** based on the city names stored in the backend database. When a user clicks on a city from the suggestions, a message appears below the search bar confirming that the city is found.  

The main goal of this project is to provide a **fast and interactive search experience** for users, while also demonstrating how to connect a React frontend with a Spring Boot backend and a MySQL database.

---

## Features
- **Auto-suggestions:** Cities from the database appear as the user types in the search bar.  
- **Click to select:** When a user clicks a suggested city, it fills the search box and shows a confirmation message.  
- **Live search:** Suggestions are fetched from the backend dynamically.  
- **Clean UI:** Simple, modern design with light/dark theme toggle.  
- **Backend ready:** Spring Boot application with REST APIs connected to MySQL.  

---

## Technologies Used
- **Frontend:** React.js, Vite, HTML, CSS, JSX  
- **Backend:** Spring Boot, Java  
- **Database:** MySQL  
- **Other:** Fetch API for connecting frontend to backend, Slf4j for logging  

---

## Project Structure

### Backend (Spring Boot)
- `model/` – contains the entity class for cities.  
- `repository/` – JPA repository to query the database.  
- `service/` – business logic for fetching cities.  
- `controller/` – REST API endpoints for the frontend to call.  

### Frontend (React)
- `components/` – `SearchBar.jsx` component handles input and suggestions.  
- `styles/` – CSS file with theme support and UI styling.  
- `App.jsx` – main app component rendering the search bar.  

---

## Setup Instructions

### Backend
1. Make sure MySQL is running and create a database `hotel_locations_db`.  
2. Update `application.properties` with your MySQL credentials.  
3. Run the Spring Boot application.  
4. The backend provides API endpoints:  
   - `GET /cities/getAllCities` – returns all cities  
   - `GET /cities/suggest?keyword=` – returns cities matching input  

### Frontend
1. Navigate to the frontend folder:  
   ```bash
   cd city-search-ui


   Install dependencies:

npm install


Start the app:

npm run dev


Open your browser at http://localhost:5173

How to Use

Type a city name in the search bar.

Auto-suggestions appear below the search bar.

Click on a suggestion to select it.

A message appears below the search bar confirming the selection.

Toggle between light and dark theme using the button at the top.

Screenshots


Example of city search with auto-suggestions and selection message.

Future Improvements

Highlight matching letters in suggestions.

Keyboard navigation (up/down arrows + enter to select).

Show “No results found” if nothing matches.

Animate suggestion dropdown for smoother UI.

Integrate external APIs for live city data.

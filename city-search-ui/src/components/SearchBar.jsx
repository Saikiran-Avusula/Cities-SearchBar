import React, { useState, useEffect } from "react";
import "../styles/theme.css";

const SearchBar = () => {
  const [query, setQuery] = useState("");
  const [suggestions, setSuggestions] = useState([]);
  const [selectedCity, setSelectedCity] = useState(null);

  useEffect(() => {
    if (query.trim() === "") {
      setSuggestions([]);
      return;
    }

    const fetchCities = async () => {
      try {
        const res = await fetch(`http://localhost:8080/cities/suggest?keyword=${query}`);
        const data = await res.json();
        setSuggestions(data);
      } catch (err) {
        console.error("Error fetching cities:", err);
      }
    };

    const delay = setTimeout(fetchCities, 300);
    return () => clearTimeout(delay);
  }, [query]);

  const handleSelect = (city) => {
    setSelectedCity(city.cityName);
    setQuery(city.cityName);
    setSuggestions([]);
  };

  return (
    <div className="container">

      <h2>🔍 Search City</h2>

      <input
        type="text"
        placeholder="Start typing a city name..."
        value={query}
        onChange={(e) => {
          setQuery(e.target.value);
          setSelectedCity(null); // reset message when user types again
        }}
      />

      {suggestions.length > 0 && (
        <ul className="suggestions">
          {suggestions.map((city) => (
            <li key={city.cityId} onClick={() => handleSelect(city)}>
              {city.cityName}
            </li>
          ))}
        </ul>
      )}

      {/* Displaying selected city message */}
      {selectedCity && (
        <div className="result-message">
          <strong>{selectedCity}</strong> is found.
        </div>
      )}
    </div>
  );
};

export default SearchBar;

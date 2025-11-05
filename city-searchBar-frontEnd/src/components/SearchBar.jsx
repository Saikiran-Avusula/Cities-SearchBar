import React, { useState, useEffect } from "react";
import "../styles/CardHotel.css";
import CardHotel from "./CardHotels";
import axios from "axios";


const SearchBar = () => {
  const [query, setQuery] = useState("");
  const [suggestions, setSuggestions] = useState([]);
  const [selectedCity, setSelectedCity] = useState(null);
  const [hotels, setHotels] = useState([]);
  const [loading, setLoading] = useState(false);
  const [showHotels, setShowHotels] = useState(false);

  useEffect(() => {
    if (query.trim() === "") {
      setSuggestions([]);
      setShowHotels(false);
      return;
    }

    const fetchCities = async () => {
      try {
        // const res = await fetch(`http://localhost:8080/cities/suggest?keyword=${query}`);
        // const data = await res.json();
        const response = await axios.get(`http://localhost:8080/cities/suggest?keyword=${query}`);
        setSuggestions(response.data);
      } catch (err) {
        console.error("Error fetching cities:", err);
      }
    };

    const delay = setTimeout(fetchCities, 300);
    return () => clearTimeout(delay);
  }, [query]);

  const handleSelect = (city) => {
    const cityData = typeof city === "string" ? { cityName: city, cityId: null } : city;
    setSelectedCity(cityData);
    setQuery(cityData.cityName || "");
    setSuggestions([]);
    setShowHotels(false); // Reset hotels view when selecting new city
  };

  const handleSearch = () => {
    if (selectedCity?.cityId) {
      setLoading(true);
      setShowHotels(true);
      fetch(`http://localhost:8080/hotels/by-city/${selectedCity.cityId}`)
        .then(res => res.json())
        .then(data => {
          console.log("Fetched hotels data:", data);
          setHotels(data);
          setLoading(false);
        })
        .catch(err => {
          console.error("Error fetching hotels:", err);
          setHotels([]);
          setLoading(false);
        });
    }
  };

  return (
    <div className="container">
      {/* <div className="toggle-theme">
        <button
          onClick={() => {
            document.body.dataset.theme =
              document.body.dataset.theme === "dark" ? "light" : "dark";
          }}
        >
          Toggle Theme
        </button>
      </div> */}

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

      <button onClick={handleSearch} disabled={!selectedCity}>
        Search
      </button>

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
           <strong>{selectedCity.cityName}</strong> is found.
        </div>
      )}

      {/* Display hotels only after search button is clicked */}
      {showHotels && selectedCity && (
        <div className="hotels-container">
          <h3>Hotels in {selectedCity.cityName}</h3>
          {loading ? (
            <div>Loading hotels...</div>
          ) : hotels.length > 0 ? (
            <div className="hotels-cards">
              {hotels.map(hotel => (
                <CardHotel 
                  key={hotel.hotelId} 
                  hotel={{
                    hotel_image_url: hotel.hotelImageUrl,
                    hotel_name: hotel.hotelName,
                    hotel_area: hotel.hotelArea,
                    hotel_price: hotel.hotelPrice
                  }} 
                />
              ))}
            </div>
          ) : (
            <div>No hotels found for this city</div>
          )}
        </div>
      )}
    </div>
  );
};

export default SearchBar;

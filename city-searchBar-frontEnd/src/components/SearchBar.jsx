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
  const[warning, setWarning] = useState("");

  // warning message auto hide after 1 second
  useEffect(() =>{
    if(!warning) return;
    const warningTImer = setTimeout(() => {
      setWarning("");
    }, 1000);
    return () => clearTimeout(warningTImer);
  }, [warning]);


  useEffect(() => {
    if (query.trim() === "") {
      setSuggestions([]);
      setShowHotels(false);
      return;
    }

  

    const fetchCities = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/cities/suggest?keyword=${query}`
        );
        setSuggestions(response.data);
      } catch (err) {
        console.error("Error fetching cities:", err);
      }
    };

    const delay = setTimeout(fetchCities, 300);
    return () => clearTimeout(delay);
  }, [query]);

  const handleSelect = (city) => {
    const cityData =
      typeof city === "string" ? { cityName: city, cityId: null } : city;
    setSelectedCity(cityData);
    setQuery(cityData.cityName || "");
    setSuggestions([]);
    setShowHotels(false);
    setWarning("");
  };

  const handleSearch = () => {
  if (query.trim() === "") {
      setWarning("⚠️ Please enter a city name before searching.");
      setShowHotels(false);
      return;
    }

    setWarning(""); // Clear any previous warnings
    if (selectedCity?.cityId) {
      setLoading(true);
      setShowHotels(true);
      fetch(`http://localhost:8080/hotels/by-city/${selectedCity.cityId}`)
        .then((res) => res.json())
        .then((data) => {
          console.log("Fetched hotels data:", data);
          setHotels(data);
          setLoading(false);
        })
        .catch((err) => {
          console.error("Error fetching hotels:", err);
          setHotels([]);
          setLoading(false);
        });
    }
  };

  return (
    <div className="container">
      <h2>🔍 Search City</h2>
      <p>Search for cities in Telangana to view available hotels</p>

      <input
        type="text"
        placeholder="Start typing a city name..."
        value={query}
        onChange={(e) => {
          setQuery(e.target.value);
          setSelectedCity(null);
        }}
      />

      <button onClick={handleSearch}>
        Search
      </button>

      {/* Warning message */}
      {warning && <div className="warning-message">{warning}</div>}

      {/* City suggestions list */}
      {suggestions.length < 0 && (<ul className="suggestions">
          {console.warn("No suggestions available")}
      </ul>)}
      {suggestions.length > 0 && (
        <ul className="suggestions">
          {suggestions.map((city) => (
            <li key={city.cityId} onClick={() => handleSelect(city)}>
              {city.cityName}
            </li>
          ))}
        </ul>
      )}

      {/* Selected city confirmation */}
      {selectedCity ? (
        <div className="result-message">
          ✅ <strong>{selectedCity.cityName}</strong> is found.
        </div>
      ) : (
        !selectedCity && query.trim() !== "" && suggestions.length === 0 && (
          <div className="result-message">
            ❌ No city found for "<strong>{query}</strong>"
          </div>
          )
      )}



      {/* Hotels display section */}
      {showHotels && selectedCity && (
        <div className="hotels-container">
          <h3>Hotels in {selectedCity.cityName}</h3>
          {loading ? (
            <div>Loading hotels...</div>
          ) : hotels.length > 0 ? (
            <div className="hotels-cards">
              {hotels.map((hotel) => (
                <CardHotel
                  key={hotel.hotelId}
                  hotel={{
                    hotel_image_url: hotel.hotelImageUrl,
                    hotel_name: hotel.hotelName,
                    hotel_area: hotel.hotelArea,
                    hotel_price: hotel.hotelPrice,
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

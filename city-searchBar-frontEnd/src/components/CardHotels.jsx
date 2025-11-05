import React from "react";
import "../styles/CardHotel.css";
const CardHotel = ({ hotel }) => {
  console.log("CardHotel received props:", hotel);
  
  if (!hotel) return null;

  return (
    <div className="hotel-card">
      <div className="hotel-details">
        <div className="image-container">
          <img 
            className="hotel-image" 
            src={hotel.hotel_image_url || 'https://via.placeholder.com/200x150?text=Hotel+Image'} 
            alt={hotel.hotel_name || "Hotel image"}
            onError={(e) => {
              e.target.onerror = null;
              e.target.src = 'https://via.placeholder.com/200x150?text=Hotel+Image';
            }}
          />
        </div>
        <div className="info-container">
          <h4 className="hotel-name">{hotel.hotel_name}</h4>
          <p className="hotel-place">{hotel.hotel_area}</p>
          <p className="hotel-price">₹{hotel.hotel_price} per night</p>
        </div>
      </div>
      <div className="hotel-action">
        <button
          className="booking-button"
          onClick={() => {
            /* temporary - no action */
          }}
        >
          Book
        </button>
      </div>
    </div>
  );
};

export default CardHotel;

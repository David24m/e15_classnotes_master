import React from 'react';

const CountrySelector = (props) => {
  return (
    <select defaultValue="default" name="country-selector" id="country-selector">
      <option disabled value="default">Choose a country...</option>
    </select>
  )
};

export default CountrySelector;
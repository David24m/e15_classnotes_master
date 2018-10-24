import React from 'react';

const CountryDetail = (props) => {

  if (!props.country) return null
  return <p>{props.country.name}</p>;
}

export default CountryDetail;
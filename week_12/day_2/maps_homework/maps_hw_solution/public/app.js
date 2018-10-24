var initialize = function(){
  var mapDiv = document.getElementById('main-map');
  var center = {lat: 51.5074, lng: -0.1278};
  var mainMap = new MapWrapper(mapDiv, center, 10);
  mainMap.addMarker(center, "London is the capital city of the UK");
  mainMap.addClickEvent();
  var bounceButton = document.querySelector('#button-bounce-markers');
  bounceButton.addEventListener('click', mainMap.bounceMarkers);
  
  var goToChicago = function(){ 
    var chicago = { lat: 41.878114, lng: -87.629798 };
    mainMap.googleMap.setCenter(chicago);
  }

  var chicagoButton = document.getElementById('chicago');
  chicagoButton.addEventListener('click', goToChicago);

  var geolocateButton = document.getElementById('geolocate');
  geolocateButton.addEventListener('click', mainMap.geolocate);
  
}


window.addEventListener('load', initialize);
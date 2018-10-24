var PieChart = function(title, data) {

  console.log(data)

  var container = document.getElementById("pieChart");

  var chart = new Highcharts.Chart({
    chart: {
      type: 'pie',
      renderTo: container
    },
    title: {
      text: title
    },
    series: [
      {
        data: data
      }
    ]
  });

};

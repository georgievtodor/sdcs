var temperature = $('#temperature');
var humidity = $('#humidity');

app.requester.get('http://localhost:8080/channel/6').then(function(resp) {
    humidity.html(resp)
})

app.requester.get('http://localhost:8080/channel/7').then(function(resp) {
    temperature.html(resp);
})

$('#btn-temperature').on('click', function(ev) {
    ev.preventDefault();
    var newTemperature = $('#change-temperature').val();
    const body = {
        command: newTemperature,
        channelType: 'TemperatureChannel'
    }

    app.requester.put('http://localhost:8080/channel/7', JSON.stringify(body)).then(function(r) {
        console.log(r);
    })
})

$('#btn-humidity').on('click', function(ev) {
    ev.preventDefault();
    var newHumidity = $('#change-humidity').val();

    const body = {
        command: newHumidity,
        channelType: 'HumidityChannel'
    }

    app.requester.put('http://localhost:8080/channel/6', JSON.stringify(body)).then(function(r) {
        console.log(r);
    })
})
const weatherService = require('../services');

exports.getWeather = async (req, res) => {
    if (req.method === 'GET') {
        const latitude = req.query.lat;
        const longitude  = req.query.long;

        const response = await weatherService.getWeatherData(latitude, longitude);

        res.send(response);
    }
};
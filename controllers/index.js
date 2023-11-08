const weatherService = require('../services');

exports.getWeather = async (req, res) => {
    if (req.method === 'POST') {
        const { latitude, longitude } = req.body;

        const response = await weatherService.getWeatherData(latitude, longitude);

        res.send(response);
    }
};
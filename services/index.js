const config = require('../config');

exports.getWeatherData = async (latitude, longitude) => {
    const apiUrl = config.API_URL;
    const apiKey = config.API_KEY;

    try {
        const response = await fetch(`${apiUrl}?lat=${latitude}&lon=${longitude}&appid=${apiKey}&units=metric`);
        const data = await response.json();

        if (response.ok) {

            return data;
        } else {
            throw new Error('Error fetching weather data');
        }
    } catch (error) {
        throw new Error('Error fetching weather data: ' + error.message);
    }
}

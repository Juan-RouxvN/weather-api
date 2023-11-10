const weatherService = require('./services')

module.exports = async function (context, req) {
    context.log('JavaScript HTTP trigger function processed a request.');

    const latitude = req.query.lat;
    const longitude = req.query.long;

    const response = await weatherService.getWeatherData(latitude, longitude);


    context.res = {
        body: response
    };
}
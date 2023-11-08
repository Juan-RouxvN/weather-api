const functions = require('@google-cloud/functions-framework');
const weatherController = require('./controllers');

functions.http('apiWeather', weatherController.getWeather);
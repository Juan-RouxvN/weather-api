/**
 * @swagger
 * /api/weather:
 *   post:
 *     summary: Get weather information.
 *     description: Retrieve weather information based on coordinates.
 *     parameters:
 *       - in: body
 *         name: body
 *         description: Coordinates (latitude and longitude) for weather information.
 *         required: true
 *         schema:
 *           type: object
 *           properties:
 *             latitude:
 *               type: number
 *             longitude:
 *               type: number
 *     responses:
 *       200:
 *         description: Weather information successfully retrieved.
 *       400:
 *         description: Bad request. Invalid input parameters.
 *       500:
 *         description: Internal server error. Unable to fetch weather data.
 */

const express = require('express');
const weatherController = require('../controllers');

const router = express.Router();

router.get('/api/weather', weatherController.getWeather);

module.exports =  router
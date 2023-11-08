const express = require('express');
const weatherRouter = require('./routes');
const swaggerUi = require('swagger-ui-express');
const swaggerSpec = require('./swagger');

const app = express();

app.use(express.json());
app.use(weatherRouter);
app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerSpec));

module.exports = app;

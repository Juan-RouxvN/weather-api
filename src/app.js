const express = require('express');
const weatherRouter = require('./routes');

const app = express();

app.use(express.json());
app.use(weatherRouter);

module.exports = app;

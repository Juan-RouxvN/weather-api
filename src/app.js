const express = require('express');
const weatherRouter = require('./routes');
const swaggerUi = require('swagger-ui-express');
const swaggerSpec = require('./swagger');
const config = require('./config');

const app = express();
const port = config.PORT;

app.use(express.json());

app.use(weatherRouter);

app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerSpec));

app.listen(port, () => {
    console.log(`Weather API server listening at http://localhost:${port}`);
});

const express = require('express');
const weatherRouter = require('./routes');
const swaggerUi = require('swagger-ui-express');
const swaggerSpec = require('./swagger');

const app = express();
const port = 3000;

app.use(express.json());

app.use(weatherRouter);

app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerSpec));

app.listen(port, () => {
    console.log(`Weather API server listening at http://localhost:${port}`);
});

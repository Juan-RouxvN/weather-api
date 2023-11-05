const swaggerJSDoc = require('swagger-jsdoc');

const options = {
  definition: {
    openapi: '3.0.0',
    info: {
        title: 'Weather API Documentation',
        version: '1.0.0',
        description: 'API documentation for the Weather API',
    },
  },
  
  apis: ['./routes/index.js'],
};

const swaggerSpec = swaggerJSDoc(options);

module.exports = swaggerSpec;
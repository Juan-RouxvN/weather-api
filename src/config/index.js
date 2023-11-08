const dotenv = require('dotenv');

dotenv.config();

module.exports = config = {
    PORT: process.env.PORT || 3000,
    API_URL: process.env.API_URL || '',
    API_KEY: process.env.API_KEY || '',
}


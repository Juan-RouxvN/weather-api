const config = require('./config');
const app = require('./app');

const port = config.PORT;

app.listen(port, () => {
    console.log(`Server started, listening on http://localhost:${port}`);
});
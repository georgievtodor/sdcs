'use strict';

const app = require('./src/config'),
    controllers = require('./src/controllers')({ io: app.io });

require('./src/routers')({ app, controllers });

console.log('Server is running on port 3002');
'use strict';

module.exports = ({ app, controllers }) => {
    const controller = controllers.devices;

    app.get('/', controller.getHome);
    app.post('/', controller.loadToastrMessage);
}
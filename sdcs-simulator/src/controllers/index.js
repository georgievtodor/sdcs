'use strict';

const path = require('path'),
    fs = require('fs');

module.exports = ({ io }) => {
    let controllers = [];

    fs.readdirSync(__dirname)
    .filter(file => file.includes('-controller'))
    .forEach(controller => {
        let currentController  = require(path.join(__dirname, controller))({ io });

        let controllerName = controller.substring(0, controller.indexOf('-controller'));

        controllers[controllerName] = currentController;
    });

    return controllers;
}
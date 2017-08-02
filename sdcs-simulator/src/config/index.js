'use strict';

const express = require('express'),
    session = require('express-session'),
    bodyParser = require('body-parser'),
    cookieParser = require('cookie-parser'),
    path = require('path'),
    cors = require('cors'),
    flash = require('connect-flash'),
    toastr = require('express-toastr'),
    app = express(),
    server = require('http').Server(app),
    io = require('socket.io')(server);
    server.listen(3002);

app.use('/static', express.static(path.resolve(__dirname + '/../../public')));
app.use(cookieParser());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(session({ secret: 'Bond. James Bond!', resave: true, saveUninitialized: true }));
app.use(flash());
app.use(toastr());

app.set('views', __dirname + '/../views');
app.engine('html', require('ejs').renderFile);

app.use((req, res, next) => {
    res.locals.toasts = req.toastr.render();
    next();
});

app.use((req, res, next) => {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    res.setHeader("Access-Control-Allow-Methods", "PUT, GET, POST, OPTIONS, PATCH, DELETE");
    res.setHeader("Access-Control-Allow-Credentials", true);
    next();
});
app.options("*", cors());

app.io = io;

module.exports = app;
const fs = require('fs'),
    path = require('path');
    
module.exports = ({ app, controllers }) => {
    fs.readdirSync('./src/routers')
        .filter(router => router.includes('-router'))
        .forEach(router => {
            require(path.join(__dirname, router))({ app, controllers });
        });

    app.get('*', (req, res) => {
        res.status(404).redirect('/');
    })
}
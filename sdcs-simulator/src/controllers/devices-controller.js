module.exports = ({ io }) => {
    return {
        getHome(req, res) {
            io.on('connection', (socket) => {
            });

            return res.render('index.html');
        },

        loadToastrMessage(req, res) {
            const body = req.body;
            
            let message;
            if (body.type == 'update channel') {
                message = `Channel with id ${body.id} of type ${body.channelType} has been updated. New value is ${body.command}`;
            } else if (body.type == 'update channel label') {
                message = `Channel with id ${body.id} of type ${body.channelType} has been updated. New label is ${body.label}`;
            } else if (body.type == 'update device') {
                message = `Device with id ${body.id} has been updated. Label is ${body.label}, hardware version is ${body.hardwareVersion} and firmware version is ${body.firmwareVersion} `;
            }

            io.emit('message', { message });

            return res.sendStatus(200);
        }
    }
}
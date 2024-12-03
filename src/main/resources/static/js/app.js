const express = require('express');
const app = express();

// Serve static files from the public folder
app.use(express.static('public'));

// Serve the user agreement document
app.get('/user-agreement-document', (req, res) => {
    res.sendFile(__dirname + '/user-agreement.pdf');
});

// Start the server
const port = 3000;
app.listen(port, () => {
    console.log(`Server started on port ${port}`);
});
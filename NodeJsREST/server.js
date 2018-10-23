var express = require('express')
var app = express();
/*
If process.env.PORT have some defined port then use this PORT,
instead use port 3000
*/
var port = process.env.PORT || 3000;

var mongoose = require('mongoose');
var Task = require('./api/models/todoListModel');
var bodyParser = require('body-parser');

//mongoose instance connection url connection
mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost/Tododb');

app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());

var routes = require('./api/routes/todoListRoutes');
routes(app);//register routes

app.listen(port);

console.log("This tutorial REST API server started on " + port);

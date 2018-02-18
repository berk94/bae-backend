"use strict";

const express = require('express');
const bodyParser = require('body-parser'); // for handling json

const app = express();
const DEFAULT_PORT=3000;
const mongo = require('./config/mongo');

// Use bodyParser to parse requests in different formats
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

const mongoose = require('mongoose');
mongoose.connect(mongo.url);

// To solve the "Can't set headers after they are sent problem"
app.use(function(req,res,next){
    var _send = res.send;
    var sent = false;
    res.send = function(data){
        if(sent) return;
        _send.bind(res)(data);
        sent = true;
    };
    next();
});

const db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function() {
  //connected
  // Populate DB with sample data
  // if(mongo.seedDB){
  //   require('./config/populate_db');
  // }

  require('./app/index')(app, db);

  let PORT = process.env.PORT || DEFAULT_PORT
  app.listen(PORT, () => {
    console.log("Listening to port " + PORT + "...");
  });

});

'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var placeSchema = new Schema({
 name: String,
 latitude: Number,
 longitude: Number
});

module.exports = mongoose.model('Place', placeSchema);

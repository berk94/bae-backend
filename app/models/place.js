'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var placeSchema = new Schema({
 name: {type: String, required: [true, 'name is required.']},
 latitude: {type: Number, required: [true, 'latitude is required.']},
 longitude: {type: Number, required: [true, 'longitude is required.']}
});

placeSchema.index({ latitude: 1, longitude: 1}, { unique: true });
module.exports = mongoose.model('Place', placeSchema);

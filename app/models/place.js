'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var Deliverer = require('./deliverer');

var placeSchema = new Schema({
 googlePlacesID: {type: String, required: [true, 'googlePlacesID is required.'], index: { unique: true }},
 name: {type: String, required: [true, 'name is required.'], index: { unique: true }},
 latitude: {type: Number, required: [true, 'latitude is required.']},
 longitude: {type: Number, required: [true, 'longitude is required.']}
});

placeSchema.index({ latitude: 1, longitude: 1}, { unique: true });

module.exports = mongoose.model('Place', placeSchema);

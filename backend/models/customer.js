'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var Location = require('./location');

var customerSchema = new Schema({
 _id: Schema.Types.ObjectId,
 firstName: String,
 lastName: String,
 location: Location
});

module.exports = mongoose.model('Customer', customerSchema);

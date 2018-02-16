'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var Location = require('./location');

var delivererSchema = new Schema({
 _id: Schema.Types.ObjectId,
 firstName: String,
 lastName: String,
 weightCapacity: Number,
 volumeCapacity: Number,
 route: [
   {
     location: Location,
     date: Date
   }
 ]
});

module.exports = mongoose.model('Deliverer', delivererSchema);

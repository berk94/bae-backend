'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var Location = require('./location');

var delivererSchema = new Schema({
 _id: Schema.Types.ObjectId,
 weightCapacity: Number,
 volumeCapacity: Number,
 route: [
   {
     location: Location,
     date: Date
   }
 ]
});

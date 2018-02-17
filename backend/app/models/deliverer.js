'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var Place = require('./place');

var delivererSchema = new Schema({
 firstName: String,
 lastName: String,
 weightCapacity: Number,
 volumeCapacity: Number,
 route: [
   {
     place: {type: Schema.Types.ObjectId, ref: "Place"},
     date: Date
   }
 ]
});

delivererSchema.statics.all = function(cb) {
    return this.find({}, cb);
  };

module.exports = mongoose.model('Deliverer', delivererSchema);

'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var Place = require('./place');

var delivererSchema = new Schema({
  firstName: {type: String, required: [true, 'firstName is required.']},
  lastName: {type: String, required: [true, 'lastName is required.']},
  weightCapacity:{type: Number, required: [true, 'weightCapacity is required.']},
  volumeCapacity: {type: Number, required: [true, 'volumeCapacity is required.']},
  route: {
    type: [
      {
        place: {type: Schema.Types.ObjectId, ref: "Place", required:[true, 'place is required.'] },
        date: {type: Number, required: [true, 'volumeCapacity is required.']}
      }
    ],
    required: [true, 'route is required.']
  }
}
);

delivererSchema.statics.all = function(cb) {
  return this.find({}, cb);
};

module.exports = mongoose.model('Deliverer', delivererSchema);

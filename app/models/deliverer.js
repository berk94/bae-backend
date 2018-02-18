'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var Place = require('./place');

var delivererSchema = new Schema({
  firstName: {type: String, required: [true, 'firstName is required.']},
  lastName: {type: String, required: [true, 'lastName is required.']},
  imageURL: {type: String},
  weightCapacity:{type: Number, required: [true, 'weightCapacity is required.']},
  volumeCapacity: {type: Number, required: [true, 'volumeCapacity is required.']},
  route: [
    {
      place: {type: Object, ref: "Place", required:[true, 'place is required.'] },
      date: {type: Date, required: [true, 'date is required.']}
    }
  ]
}
);

delivererSchema.virtual('fullName').get(function () {
  return this.firstName + ' ' + this.lastName;
});


delivererSchema.statics.all = function(cb) {
  return this.find({}, cb);
};

delivererSchema.index({ firstName: 1, lastName: 1}, { unique: true });
module.exports = mongoose.model('Deliverer', delivererSchema);

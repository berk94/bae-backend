'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var Place = require('./place');

var customerSchema = new Schema({
 firstName: {type: String, required: [true, 'firstName is required.']},
 lastName: {type: String, required: [true, 'lastName is required.']},
});

customerSchema.statics.all = function(cb) {
    return this.find({}, cb);
  };

customerSchema.virtual('fullName').get(function () {
  return this.firstName + ' ' + this.lastName;
});

module.exports = mongoose.model('Customer', customerSchema);

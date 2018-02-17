'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var Place = require('./place');

var customerSchema = new Schema({
 firstName: String,
 lastName: String,
});

customerSchema.statics.all = function(cb) {
    return this.find({}, cb);
  };

customerSchema.virtual('fullName').get(function () {
  return this.firstName + ' ' + this.lastName;
});

module.exports = mongoose.model('Customer', customerSchema);

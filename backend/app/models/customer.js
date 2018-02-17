'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var Place = require('./place');

var customerSchema = new Schema({
 firstName: String,
 lastName: String,
 place: {type: Schema.Types.ObjectId, ref: "Place"}
});

customerSchema.statics.all = function(cb) {
    return this.find({}, cb);
  };

module.exports = mongoose.model('Customer', customerSchema);

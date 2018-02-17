'use strict';

const mongoose = require('mongoose');
var Schema = mongoose.Schema;

var itemSchema = new Schema({
 name: String,
 weight: Number,
 volume: Number,
 price: Number
});

itemSchema.statics.all = function(cb) {
    return this.find({}, cb);
  };

module.exports = mongoose.model('Item', itemSchema);

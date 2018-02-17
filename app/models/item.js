'use strict';

const mongoose = require('mongoose');
var Schema = mongoose.Schema;

var itemSchema = new Schema({
 name: {type: String, required: [true, 'name is required.'], index: { unique: true }},
 weight: {type: Number, required: [true, 'weight is required.']},
 volume: {type: Number, required: [true, 'volume is required.']},
 price: {type: Number, required: [true, 'price is required.']},
 imageURL: {type: String, index: { unique: true }},
});

itemSchema.statics.all = function(cb) {
    return this.find({}, cb);
  };

module.exports = mongoose.model('Item', itemSchema);

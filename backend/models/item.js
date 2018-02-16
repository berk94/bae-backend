'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var itemSchema = new Schema({
 _id: Schema.Types.ObjectId,
 name: String,
 weight: Number,
 volume: Number,
 price: Number
});

module.exports = mongoose.model('Item', itemSchema);

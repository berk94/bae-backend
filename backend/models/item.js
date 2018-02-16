'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var itemSchema = new Schema({
 _id: Schema.Types.ObjectId,
 orderID: Schema.Types.ObjectId,
 weight: Number,
 volume: Number,
 price: Number
});

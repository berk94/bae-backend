'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var locationSchema = new Schema({
 _id: Schema.Types.ObjectId,
 name: String,
 latitude: Number,
 longitude: Number
});

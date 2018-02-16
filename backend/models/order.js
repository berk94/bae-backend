'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var orderSchema = new Schema({
 _id: Schema.Types.ObjectId,
 delivererID: Schema.Types.ObjectId,
 customerID: Schema.Types.ObjectId,
 startDate: Date,
 endDate: Date,
 createdAt: { type: Date, default: Date.now }
});

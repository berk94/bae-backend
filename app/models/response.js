'use strict';

var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var responseSchema = new Schema({});

responseSchema.methods.sendResponse = function(res, err, data) {
    if (err) {
      res.send({'code':500, 'msg':err});
    }
    else {
      res.send({'code':200, 'data':data});
    }
  };

module.exports = mongoose.model('Response', responseSchema);

'use strict';

var Deliverer = require('../models/deliverer')
const Response = require('../models/response');

// Display list of all deliverers.
exports.deliverer_list = function(req, res) {
    Deliverer.all(function(err,deliverers) {
      var response = new Response();
      response.sendResponse(res, err, deliverers);
    });
};

// Display detail page for a specific deliverer.
exports.deliverer_detail = function(req, res) {
    res.send('NOT IMPLEMENTED: deliverer detail: ' + req.params.id);
};

// Create deliverer
exports.deliverer_create = function(req, res) {
  const deliverer = new Deliverer(req.body);
  deliverer.save(function(err, data) {
    var response = new Response;
    response.sendResponse(res, err, data);
  });
};

// Delete all deliverers
exports.delete_all = function(req, res) {
  Deliverer.remove({}, function(err, data){
    var response = new Response;
    response.sendResponse(res, err, data);
  })
};

// Delete a specific deliverer
exports.delete = function(req, res) {
    res.send('NOT IMPLEMENTED: Delete a specific deliverer');
};

// Update a specific deliverer
exports.deliverer_update = function(req, res) {
    res.send('NOT IMPLEMENTED: Update a specific deliverer');
};

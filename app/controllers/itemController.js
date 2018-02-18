'use strict';

const Item = require('../models/item');
const Response = require('../models/response');

// Display list of all items.
exports.item_list = function(req, res) {
  Item.all(function(err,items) {
    var response = new Response();
    response.sendResponse(res, err, items);
  });
};

// Display detail page for a specific item.
exports.item_detail = function(req, res) {
  console.log("Getting item...")
  Item.findById(req.params.itemID, function(err,data){
    var response = new Response;
    response.sendResponse(res, err, data);
  });
};

// Create item
exports.item_create = function(req, res) {
  const item = new Item(req.body);
  item.save(function(err, data) {
    var response = new Response;
    response.sendResponse(res, err, data);
  });
};

// Delete all items
exports.delete_all = function(req, res) {
  res.send('Ups you almost deleted all items!');
  // Item.remove({}, function(err, data){
  //   var response = new Response;
  //   response.sendResponse(res, err, data);
  // })
};

// Delete a specific item
exports.delete = function(req, res) {
  Item.findByIdAndRemove (req.params.id, function(err,data){
    var response = new Response;
    response.sendResponse(res, err, data);
  });
};

// Update a specific item
exports.item_update = function(req, res) {
  res.send('NOT IMPLEMENTED: Update a specific item');
};

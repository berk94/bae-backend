'use strict';

const Order = require('../models/order');
const Response = require('../models/response');

// Display list of all orders.
exports.order_list = function(req, res) {
  Order.all(function(err,orders) {
    var response = new Response();
    response.sendResponse(res, err, orders);
  });
};

// Display detail page for a specific order.
exports.order_detail = function(req, res) {
  Order.findById(req.params.orderID, function(err,data){
    var response = new Response;
    response.sendResponse(res, err, data);
  });
};

// Create order
exports.order_create = function(req, res) {
  const order = new Order(req.body);
  order.save(function(err, data) {
    if (!err) {
      // decrease deliverer's remaining weight and volume capacities
    }
    var response = new Response;
    response.sendResponse(res, err, data);
  });
};

// Delete all orders
exports.delete_all = function(req, res) {
  res.send('Ups you almost deleted all orders!');
  // Order.remove({}, function(err, data){
  //   var response = new Response;
  //   response.sendResponse(res, err, data);
  // })
};

// Delete a specific order
exports.delete = function(req, res) {
  // get item from order
  // get deliverer from order
  // increase deliverer's remaining weight and volume capacities

  Order.findByIdAndRemove (req.params.id, function(err,data){
    var response = new Response;
    response.sendResponse(res, err, data);
  });
};

// Update a specific order
exports.order_update = function(req, res) {
  res.send('NOT IMPLEMENTED: Update a specific order');
};

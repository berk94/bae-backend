'use strict';

const Order = require('../models/order');
const Item = require('../models/item');
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

// Display all orders of a specific customer
exports.order_list_by_customer = function(req, res) {
  Order.find({customerID:req.params.customerID}, function(err,data){
    var response = new Response();
    response.sendResponse(res, err, data);
  });

  // var newdata = []
  // Order.find({customerID:req.params.customerID}, function(err,data){
  //   for (var i = 0, len = data.length; i < len; i++) {
  //     var order = data[i];
  //     var itemID = order.itemID;
  //     Item.findById(itemID, function(error,item) {
  //       console.log(item);
  //       var orderData = order;
  //       orderData.item = "abc";
  //       console.log(orderData);
  //       newdata.push(orderData);
  //     });
  //   }
  //   var response = new Response();
  //   response.sendResponse(res, err, newdata);
  // });
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

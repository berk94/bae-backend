'use strict';

var Customer = require('../models/customer');
const Response = require('../models/response');

// Display list of all Customers.
exports.customer_list = function(req, res) {
  Customer.all(function(err,customers) {
    var response = new Response();
    response.sendResponse(res, err, customers);
  });
};

// Display detail page for a specific customer.
exports.customer_detail = function(req, res) {
  Customer.findById(req.params.customerID, function(err,data){
    var response = new Response;
    response.sendResponse(res, err, data);
  });
};

// Create customer
exports.customer_create = function(req, res) {
  const customer = new Customer(req.body);
  customer.save(function(err, data) {
    var response = new Response;
    response.sendResponse(res, err, data);
  });
};

// Delete all customers
exports.delete_all = function(req, res) {
  res.send('Ups you almost deleted all customers!');
  // Customer.remove({}, function(err, data){
  //   var response = new Response;
  //   response.sendResponse(res, err, data);
  // })
};

// Delete a specific customer
exports.delete = function(req, res) {
  Customer.findByIdAndRemove (req.params.id, function(err,data){
    var response = new Response;
    response.sendResponse(res, err, data);
  });
};

// Update a specific customer
exports.customer_update = function(req, res) {
  res.send('NOT IMPLEMENTED: Update a specific customer');
};

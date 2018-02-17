"use strict";
// index file to store all other routes

const DelivererRoutes = require('./routes/deliverer_routes');
const OrderRoutes = require('./routes/order_routes');
const ItemRoutes = require('./routes/item_routes');
const CustomerRoutes = require('./routes/customer_routes');

module.exports = function(app, db) {
  DelivererRoutes(app, db);
  OrderRoutes(app,db);
  ItemRoutes(app,db);
  CustomerRoutes(app,db);
};

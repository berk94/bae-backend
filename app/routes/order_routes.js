"use strict";

const orderController = require('../controllers/orderController');

module.exports = function(app,database){
  app.get('/orders', orderController.order_list );
  app.get('/order/:orderID', orderController.order_detail);
  app.get('/orders/:customerID', orderController.order_list_by_customer);
  app.post('/order', orderController.order_create);
  app.delete('/orders', orderController.delete_all);
  app.delete('/order/:orderID', orderController.delete);
};

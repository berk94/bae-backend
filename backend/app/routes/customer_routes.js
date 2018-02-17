"use strict";
const customerController = require('../controllers/customerController');

module.exports = function(app,database){
  app.get('/customers', customerController.customer_list );
  app.get('/customer/:customerID', customerController.customer_detail);
  app.post('/customer', customerController.customer_create);
  app.delete('/customers', customerController.delete_all);
  app.delete('/customer/:customerID', customerController.delete);
};

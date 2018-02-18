"use strict";
const delivererController = require('../controllers/delivererController');

module.exports = function(app,database){
  app.get('/deliverers', delivererController.deliverer_list );
  app.get('/deliverer/:delivererID', delivererController.deliverer_detail);
  app.post('/deliverer', delivererController.deliverer_create);
  app.delete('/deliverers', delivererController.delete_all);
  app.delete('/deliverer/:delivererID', delivererController.delete);
  app.post('/searchDeliverers', delivererController.search_deliverers);
};

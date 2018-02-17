"use strict";
const itemController = require('../controllers/itemController');

module.exports = function(app,database){
  app.get('/items', itemController.item_list );
  app.get('/item/:itemID', itemController.item_detail);
  app.post('/item', itemController.item_create);
  app.delete('/items', itemController.delete_all);
  app.delete('/item/:itemID', itemController.delete);
};

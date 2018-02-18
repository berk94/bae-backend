'use strict';

var Deliverer = require('../models/deliverer');
var Place = require('../models/place');
var Item = require('../models/item');
var async = require('async');

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
  Deliverer.findById(req.params.delivererID, function(err,data){
    var response = new Response;
    response.sendResponse(res, err, data);
  })
};

// Create deliverer
exports.deliverer_create = async function(req, res) {
  const route = req.body.route;

  for (var i = 0, len = route.length; i < len; i++) {
    var place_data = route[i].place;

    let result = await Place.findOne({googlePlacesID:place_data.googlePlacesID, name:place_data.name}, function(err, placeFound) {
      if (err) console.log(err);
      if (placeFound == undefined) {
        var place = new Place({
        googlePlacesID:place_data.googlePlacesID,
        name: place_data.name,
        latitude: place_data.latitude,
        longitude:place_data.longitude
        });

        place.save(function(error, data) {
          if (error) { // duplicate place error. cannot create
            console.log(error)
            var response = new Response();
            response.sendResponse(res,error,data);
          }
          else {
            console.log("Added new place to db:" + data);
          }
        });
      }
      else {
        // the place is already in the db
        console.log(placeFound.name + " was already in the db.");
      }
    });
  }

  var deliverer = new Deliverer(req.body);

  let result = await deliverer.save(function(err, data) {
    var response = new Response;
    response.sendResponse(res, err, data);
  });
};

// Delete all deliverers
exports.delete_all = function(req, res) {
  res.send('Ups you almost deleted all deliverers!');
  // Deliverer.remove({}, function(err, data){
  //   var response = new Response;
  //   response.sendResponse(res, err, data);
  // })
};

// Delete a specific deliverer
exports.delete = function(req, res) {
  Deliverer.findByIdAndRemove (req.params.id, function(err,data){
    var response = new Response;
    response.sendResponse(res, err, data);
  });
};

// Update a specific deliverer
exports.deliverer_update = function(req, res) {
  res.send('NOT IMPLEMENTED: Update a specific deliverer');
};

/**
 * @param {Date} startDate
 * @param {Date} endDate
 * @param {Place} fromLocationID
 * @param {Place} toLocationID
 * @param {Item} itemID
 * @returns {Array}
 */
 // item weight and volume should be less than or equal to capacity
 // from location before to location in route
 // to location date should be between start date and end date
exports.search_deliverers = function(req, res) {
  if (req.body.startDate ==undefined ||
    req.body.endDate ==undefined ||
    req.body.fromLocationID ==undefined ||
    req.body.toLocationID ==undefined ||
    req.body.itemID ==undefined) {
    res.send({"err": "please provide valid input."})
    return
  }

  var match_capacity = {};
  Item.findById(req.body.itemID, function(err,item){
    if (err) {
      var response = new Response;
      response.sendResponse(res, err, data);
    }
    match_capacity['weightCapacity']={$gte:item.weight};
    match_capacity['volumeCapacity']={$gte:item.volume};

    const startDate = req.body.startDate;
    const endDate = req.body.endDate;
    const fromLocationID = req.body.fromLocationID;
    const toLocationID = req.body.toLocationID;

    Deliverer.aggregate([
          { // first, filter by capacity to reduce the result set
            $match: match_capacity
          }//,
          // { // define some vars to use in the next match
          //   $project:{
          //     fromLocationIndex: { matchedIndex: { $indexOfArray: [ "$route", {place: {googlePlacesID: fromLocationID}} ] } },
          //     toLocationIndex: { matchedIndex: { $indexOfArray: [ "$route", {place: {googlePlacesID: toLocationID}} ] } }
          //     //toLocationDate: { $arrayElemAt: [ "$route", toLocationIndex ] }['date'],
          //   }
          // }
          // { // finally, filter by location and date
          //   $match: {
          //     fromLocationIndex: {$lt: toLocationIndex},
          //     // toLocationDate: {$gte: startDate},
          //     // toLocationDate: {$lte: endDate}
          //   }
          // },
          // { // then, get the fields to be shown
          //   $project:{
          //     firstName: "$firstName",
          //     lastName: "$lastName",
          //     _id:0
          //   }
          // }
          // optionally, set a limit for the records to be fetched.
          // uncomment the part below to activate
          // ,
          // {
          //   $limit: 5
          // }
        ], function(err,data) {
            var response = new Response;
            response.sendResponse(res, err, data);
          });
  });



}

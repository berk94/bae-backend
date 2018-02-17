// look at env-example and fill env.js
const env = require('./env');
var dbuser = process.env.MONGOUSER || env.MONGO.dbuser;
var dbpassword = process.env.MONGOPASSWORD || env.MONGO.dbpassword;

module.exports = {
  url : "mongodb://" + dbuser + ":" + dbpassword + "@" + env.MONGO.mlab_url,
  seedDB: true
};

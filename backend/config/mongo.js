// look at env-example and fill env.js
const env = require('./env');

module.exports = {
  url : "mongodb://" + env.MONGO.dbuser + ":" + env.MONGO.dbpassword + "@" + env.MONGO.mlab_url,
  seedDB: true
};

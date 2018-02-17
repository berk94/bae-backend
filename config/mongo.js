// look at env-example and fill env.js
try {
    const env = require('./env');
} catch (ex) {
    console.log("Could not find env file. Should be on server.");
}
var dbuser = process.env.MONGOUSER || env.MONGO.dbuser;
var dbpassword = process.env.MONGOPASSWORD || env.MONGO.dbpassword;
module.exports = {
  url : "mongodb://" + dbuser + ":" + dbpassword + "@" + env.MONGO.mlab_url,
  seedDB: true
};

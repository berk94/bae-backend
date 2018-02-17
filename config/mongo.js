// look at env-example and fill env.js

var dbuser;
var dbpassword;
var mlaburl;

try {
  console.log('Custom env');
  env = require('./env');
  dbuser = env.MONGO.dbuser;
  dbpassword = env.MONGO.dbpassword;
  mlaburl = env.MONGO.mlab_url;

} catch (ex) {
  console.log('Process env');
  dbuser = process.env.MONGOUSER;
  dbpassword = process.env.MONGOPASSWORD;
  mlaburl = process.env.MLABURL;
}

module.exports = {
  url : "mongodb://" + dbuser + ":" + dbpassword + "@" + mlaburl,
  seedDB: true
};

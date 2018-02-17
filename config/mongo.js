// look at env-example and fill env.js

var dbuser;
var dbpassword;
var mlaburl;

try {
  env = require('./env');
  console.log('Custom env');
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

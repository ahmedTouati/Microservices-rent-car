const mongoose = require("mongoose");

const userSchema = new mongoose.Schema({
  f_name: { type: String, default: null },
  l_name: { type: String, default: null },
  email: { type: String, unique: true },
  pwd: { type: String },
  token: { type: String },
});

module.exports = mongoose.model("user", userSchema);
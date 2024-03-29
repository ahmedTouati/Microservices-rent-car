require("dotenv").config();
require("./config/database").connect();
const express = require("express");
const bcrypt = require('bcryptjs');
const jwt = require("jsonwebtoken");
const app = express();

app.use(express.json());

// Logic goes here
// importing user context
const User = require("./model/user");

// Register
app.post("/register", async (req, res) => {

    // Our register logic starts here
    try {
      // Get user input
      const { f_name, l_name, email, pwd } = req.body;
  
      // Validate user input
      if (!(email && pwd && f_name && l_name)) {
        res.status(400).send("All input is required");
      }
  
      // check if user already exist
      // Validate if user exist in our database
      const oldUser = await User.findOne({ email });
  
      if (oldUser) {
        return res.status(409).send("User Already Exist. Please Login");
      }
  
      //Encrypt user password
      encryptedPassword = await bcrypt.hash(pwd, 10);
  
      // Create user in our database
      const user = await User.create({
        f_name,
        l_name,
        email: email.toLowerCase(), // sanitize: convert email to lowercase
        pwd: encryptedPassword,
      });
  
      // Create token
      const token = jwt.sign(
        { user_id: user._id, email },
        process.env.TOKEN_KEY,
        {
          expiresIn: "2h",
        }
      );
      // save user token
      user.token = token;
  
      // return new user
      res.status(201).json(user);
      return;
    } catch (err) {
      console.log(err);
    }
    // Our register logic ends here
  });

// Login
app.post("/login", async (req, res) => {

    // Our login logic starts here
    try {
      // Get user input
      const { email, pwd } = req.body;
  
      // Validate user input
      if (!(email && pwd)) {
        res.status(400).send("All input is required");
        return;
      }
      // Validate if user exist in our database
      const user = await User.findOne({ email });
  
      if (user && (await bcrypt.compare(pwd, user.pwd))) {
        // Create token
        const token = jwt.sign(
          { user_id: user._id, email },
          process.env.TOKEN_KEY,
          {
            expiresIn: "2h",
          }
        );
  
        // save user token
        user.token = token;
  
        // user
        res.status(200).json(user);
        return;
      }
      res.status(400).send("Invalid Credentials");
      return;
    } catch (err) {
      console.log(err);
    }
    // Our register logic ends here
  });
  
module.exports = app;
const auth = require("./middleware/auth");

app.post("/home", auth, (req, res) => {
  res.status(200).send("Welcome to home page");
  return;
});
#!/bin/bash

mvn clean  -f ./Voiture ;
echo "voiture jar is ready" ;
mvn clean  -f ./Client ;
echo "client jar is ready" ;
mvn clean  -f ./eureuka
echo " eureka jar is ready" ;
mvn clean  -f ./rent;
echo " rent jar is ready";
mvn clean  -f ./Zuul-Gateway;
echo " zuul jar is ready";

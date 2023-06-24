#!/bin/bash

mvn  install -f ./Voiture  -Dmaven.test.skip=true ;
echo "voiture jar is ready" ;
mvn  install -f ./Client  -Dmaven.test.skip=true;
echo "client jar is ready" ;
mvn  install -f ./eureuka -Dmaven.test.skip=true ;
echo " eureka jar is ready" ;
mvn  install -f ./rent -Dmaven.test.skip=true ;
echo " rent jar is ready";
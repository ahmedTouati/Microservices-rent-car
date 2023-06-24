
curl --user "user:user" http://localhost:8762/rent-service/rents
curl --user "user:user" http://localhost:8087/api/rents/add --header 'Content-Type: application/json' --request POST --data-binary '{"customerId":"4","nbrOfDays": 20}'

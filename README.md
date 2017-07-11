# Egen_L2_Challenge

Personal Weight Tracker API

A Iot type application whcih reads the data(Weight) from sensors (a simulator which gives new weights as a POST through HTTP). 
This API consumes the sensor data and predicts weather the person has gone over weight or underweight based on the base value. 

Module 1: API

Collections:
  - metrics collection - stores the data that comes from the
  - alerts collection - stores the alerts created by the rules
    
    create: creates the database using morphia(mongo) and stores the sensor data

METRIC API
  POST reuqest: metrics/create/ : gets the data from sensors and stores in the database
  GET request: metrics/read : reads all data from the metrics table
  GET request: metrics/readByTimeRange: reads all metrics between two timestamps

ALERT API
  POST reuqest: alerts/create/ : when the rule is executed , an alert is stored
  GET request: alerts/read : reads all data from the metrics table
  GET request: alerts/readByTimeRange: reads all alerts between two timestamps
  
 Design:
 
 base package: Run methods - springboot
 controller package
 dao package
 model package
 services package
 ruleFactory package
 test package
 
 Running the application
 1. clone the repo from github
 2. open terminal and make sure the mongodb is installed and server is runnning.
    - use "mongod" to start the server
    - test mongo connection using command "mongo"
 3. Run the sensor simulator ava -jar -Dbase.value=200 -Dapi.url=http:/ocalhost:8080/metrics/create sensor-emulator-0.0.1-SNAPSHOT.jar
 4. Build the mvn package using the command mvn clean install
 5. Run the Maven build from the project folder
      java -jar target/Personal_Weight_Tracker-0.0.1-SNAPSHOT.jar 
  6. The data is consumed from the sensor and all unit tests will run


 
 

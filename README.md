# YS Sample Application

The following application is a sample application provided by YS as a take home exam.






## Run Locally - IntelliJ

* Clone the project

```bash
  git clone https://github.com/cmgabriel/ys-sample-app-akhileshsharma.git
```

* Open Project in IntelliJ

* Install dependencies

```bash
  mvn clean build
```

* Run application.

* Open up a POSTMAN Client

* Import the collection provided along with the sample code - ```YieldStreerSampleApplication.postman_collection.json```


```bash
  localhost:9090/api/user/accreditation
```
You can change the port of the application from ```application.yml``` file.


## Run Locally - Jar File

* Clone the project

```bash
  git clone https://github.com/cmgabriel/ys-sample-app-akhileshsharma.git
```

* Open Project in IntelliJ

* Install dependencies

```bash
  mvn clean build
  //Once build has been completed.
  mvn clean package
```

* Run application -
``` bash
java -jar <application-home/target/location-of-jar-file>
```

* Open up a POSTMAN Client

* Import the collection provided along with the sample code -
``` bash 
YieldStreerSampleApplication.postman_collection.json
```

```bash
  localhost:9090/api/user/accreditation
```
You can change the port of the application from ```application.yml``` file.
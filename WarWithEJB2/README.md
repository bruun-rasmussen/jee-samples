To build and test, first download, unpack, and start JBoss AS 7.1 with the standalone-full configuration. Then build and deploy war with Maven.

## Download and unpack

```bash
AS7_DIST=https://download.jboss.org/jbossas/7.1/jboss-as-7.1.1.Final/jboss-as-7.1.1.Final.tar.gz
curl $AS7_DIST | tar xvz
```

## Start server

```bash
cd jboss-as-7.1.1.Final
./bin/standalone.sh -c standalone-full-ha.xml -b 0.0.0.0
```
(see https://stackoverflow.com/questions/22899497 if the server hangs on startup)

## Build and deploy

In another terminal window:

```bash
# Build war and deploy HyperSQL data source: (server log should say:
#    ...JBAS010400: Bound data source [java:jboss/datasources/hsqldbDS])
mvn clean install

# Deploy war: (server log should say:
#   ...JBAS018559: Deployed "WarWithEJB2.war")
mvn jboss-as:deploy
```

## Exercise

```bash
# 1st hit should succeed:
curl http://localhost:8080/WarWithEJB2/Ejb2Servlet

# 2nd hit should trigger a DuplicateKeyException and fail:
curl http://localhost:8080/WarWithEJB2/Ejb2Servlet
```

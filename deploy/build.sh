#!/bin/sh
cd ../dev
mvn clean install -Ptest
cd ../bin
cp ../dev/Web/target/Web-1.0-SNAPSHOT.war .

# deployment
# af login
# af update thebattlegame --path Web...jar

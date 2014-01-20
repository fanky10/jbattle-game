#!/bin/sh
cd ../dev
mvn clean install -Pprod
cd ../bin
cp ../dev/Web/target/Web-1.0-SNAPSHOT.war .


#!/bin/sh

rm -r /var/lib/tomcat7/webapps/tbg*
sudo cp src-dev/Web/target/Web-1.0-SNAPSHOT.war /var/lib/tomcat7/webapps/tbg.war




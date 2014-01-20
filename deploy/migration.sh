#!/bin/sh

# mySQL migration tool for appfog
mysqldump -uroot thebattlegame_web > thebattlegameweb.sql.bak
af tunnel
# select corresponding mysql tunnel
# load dump via mysql
# mysql --protocol=TCP --host=localhost --port=10000 --user=uaLDy9EhhvMLq --password=p5Odjf6E5O7uW dc1aaa897343f4eb1aed047ec7c86f19f < /tmp/mydata.sql


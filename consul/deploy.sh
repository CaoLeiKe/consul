#!/bin/bash
cd /var/www/consul/
git pull origin master

cd /var/www/consul/src/main/resources
./toolkit-linux-amd64  consul-batch --config production.ini

#!/bin/bash
set -eu
trap 'kill $(jobs -pr)' SIGINT SIGTERM EXIT
mvn exec:java -Dexec.mainClass=fi.solita.cd.Hello &
mvn test

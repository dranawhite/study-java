#!/usr/bin/env bash
mvn clean package
JMETER_HOME=D:\\apache-jmeter
cp ./target/study-dubbo.jar F:\\jmeter_classpath
sh $JMETER_HOME/bin/jmeter.sh


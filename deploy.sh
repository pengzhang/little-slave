#!/bin/bash

PROJECT=little_slave
SRC_HOME=/alidata1/project_src
TOMCAT_HOME=/alidata1/service/$PROJECT

function op(){
	cd $SRC_HOME
	if [ -d $PROJECT ]
	then
	  echo "project exist!"
	  cd $PROJECT
	  git_pull()
	  package_deploy()
	else
	   echo "porject not exist!"
	   git_clone()
	   package_deploy()
	fi

}

function git_pull(){
	git pull origin master
	#检测冲突
}

function git_clone(){
	git clone https://github.com/pengzhang/little-slave.git
}

function package_deploy(){
	mvn package
	$TOMCAT_HOME/bin/shutdown.sh
	rm -rf $TOMCAT_HOME/webapps/$PROJECT
	rm -rf $TOMCAT_HOME/webapps/*.war
	cp $SRC_HOME/$PROJECT/target/*.war $TOMCAT_HOME/webapps
	$TOMCAT_HOME/bin/startup.sh
}
#!/bin/bash

PROJECT=little-slave
SRC_HOME=/alidata1/project_src
TOMCAT_HOME=/alidata1/service/$PROJECT


function git_pull(){
        git pull origin master
        #妫娴..绐
}

function git_clone(){
        git clone https://github.com/pengzhang/little-slave.git
}

function package_deploy(){
        mvn package
		echo "maven package finish"
        $TOMCAT_HOME/bin/shutdown.sh
		echo "tomcat shutdown"
        rm -rf $TOMCAT_HOME/webapps/$PROJECT
        rm -rf $TOMCAT_HOME/webapps/*.war
        cp $SRC_HOME/$PROJECT/target/*.war $TOMCAT_HOME/webapps
		echo "deploy finish"
        $TOMCAT_HOME/bin/startup.sh
		echo "tomcat startup"
}

function op(){
        cd $SRC_HOME
        if [ -d $PROJECT ]
        then
          echo "project exist!"
          cd $PROJECT
          git_pull
		  echo "git pull finish"
          package_deploy
        else
           echo "porject not exist!"
           git_clone
           package_deploy
        fi

}
op
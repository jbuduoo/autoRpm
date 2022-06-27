#!/bin/bash

java=/root/temp/java
web=/root/temp/web
webapps=/root/temp/web/webapps

if [ "$(ls -A $java)" ]; then  #檢查一個目錄是否為空目錄
	echo "copy Java"
	cd /root/asmanager/java
	#清空所有資料
	rm -rf *
	cp -r /root/temp/java/ /root/asmanager/
else
	echo "$java is Empty"
fi

if [ "$(ls -A $web)" ]; then
	echo "copy web"
	cd /root/asmanager/web
	#清空所有資料
	rm -rf *
	cp -r /root/temp/web/ /root/asmanager/
	# 產生setenv檔，設定環境變數
	cat > /root/asmanager/web/bin/setenv.sh <<EOF
	export JRE_HOME=/opt/asmanager/java
	export CATALINA_PID=/var/run/asmanagerweb.pid
	#export JAVA_OPTS="-Xms2048M -Xmx2048M"
EOF
	chmod +x /root/asmanager/web/bin/setenv.sh
else
	echo "$web is Empty"
fi


if [ "$(ls -A $webapps)" ]; then
	echo "copy webapps"
	cd /root/asmanager/web/webapps
	#清空所有資料
	rm -rf *
	cp -r /root/temp/web/webapps/ROOT /root/asmanager/web/webapps/
	echo "copy sql"
	cp -r /root/temp/sql/asmanager.sql /root/asmanager/web/webapps/asmanager.sql

else
	echo "$webapps is Empty"
fi


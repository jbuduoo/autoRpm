#!/bin/bash
#變數
newName=wdm
newBigName=WDM
newVersion=1.2.0
password=W0m@WSX


############################################################################################################################
#  請修改大小寫變數名稱，版本號及新的資料庫密碼
# 請將該系統的tomcat放入root/temp/web 中
# 請將該系統的sql檔 放入 root/temp/sql 中
# 請將該系統的java 檔放入 /root/temp/java 中
############################################################################################################################

#請勿更動
oldName=asmanager
oldBigName=ASManager
oldVersion=1.1.0
oldPassword=M8r@WSX


#------------------------------------------------------------------------------------------------------------------------------------	
	cat > /root/rpmbuild.sh <<_EOF_
#!/bin/bash

# 自動執行打包rpm
# 此腳本要給x權限
# chmod +x rpmbuild2.sh

# 複製webapps的資料-手動去複製
# cp -rf /opt/${newName}/web/webapps/*/ /root/${newName}/web/webapps
# 複製db的資料-手動去複製


# 產製資料
cd /root/
mkdir -p /root/${newName}-${newVersion}
cp -rf /root/${newName}-${oldVersion}/* /root/${newName}-${newVersion}

# 複製root
cd /root/${newName}
tar zcvf /root/${newName}-${newVersion}/${newName}.tar.gz **

# 打包
cd /root
tar zcvf /root/rpmbuild/SOURCES/${newName}-${newVersion}.tar.gz ${newName}-${newVersion}
yum -y install rpm-build
rpmbuild -ba /root/rpmbuild/SPECS/${newName}.spec


# 刪除產製中的資料
mv -f /root/rpmbuild/RPMS/x86_64/${newName}-${newVersion}-1.x86_64.rpm /root/${newName}-${newVersion}-1.x86_64.rpm		
rm -rf /root/${newName}-${newVersion}	
rm -rf /root/rpmbuild/SRPMS/${newName}-${newVersion}-1.src.rpm	
rm -rf /root/rpmbuild/SOURCES/${newName}-${newVersion}.tar.gz
rm -rf /root/rpmbuild/BUILD/${newName}-${newVersion}
_EOF_
	chmod +x /root/rpmbuild.sh
#------------------------------------------------------------------------------------------------------------------------------------	
	
	cat > /root/db.sh <<_EOF_
#!/bin/bash

echo /opt/${newName}/db/bin/mysql -u root -pM8r@WSX --socket=/tmp/${newName}db.sock
/opt/${newName}/db/bin/mysql -u root -pM8r@WSX --socket=/tmp/${newName}db.sock <<EOF

#執行sql
DROP DATABASE IF EXISTS asmanager;
# 暫停表空間
SET GLOBAL innodb_file_per_table = OFF;
# 執行sql
source /root/${newName}/db/${newName}.sql;
# 更改密碼
SET password for 'root'@'localhost'=password('${password}');  
exit;
EOF

#暫停資料庫: 
service ${newName}db stop
#壓縮db
echo "zip db"
cd /opt/${newName}/
tar zcvf ${newName}_db.tar.gz db
#移動位置
echo "move"
mv /opt/${newName}/${newName}_db.tar.gz /root/${newName}/
#刪除舊db
echo "delete old db"
cd /root/${newName}/
rm -rf db
#解壓新的db
echo "tar -zxvf ${newName}_db.tar.gz"
tar zxvf ${newName}_db.tar.gz
#刪除db的tar檔
echo "delete db.tar"
rm -rf ${newName}_db.tar.gz
# 結束
echo "RPM Please repackage "
echo end


_EOF_
	chmod +x /root/db.sh
#------------------------------------------------------------------------------------------------------------------------------------		
	
#改名，拷貝檔案等


java=/root/temp/java
web=/root/temp/web
webapps=/root/temp/web/webapps

###壓縮多個檔案  tar zcvf rpmbuildAll.tar.gz rpmbuild asmanager-1.1.0 asmanager rpmbuild.sh

if [ "${oldName}" != "${newName}" ];then
	# 1.解壓縮
	#tar zxvf rpmbuildAll.tar.gz
	#rm -rf rpmbuildAll.tar.gz

	# 2.改資料夾
		## 修改資料夾名稱/root/${oldName}-1.1.0
		###先複製一份新的
		mv /root/${oldName}-1.1.0 /root/${newName}-1.1.0
		###刪除舊檔案夾
		rm -rf /root/${oldName}-1.1.0

		## 修改資料夾名稱/root/${oldName}
		###先複製一份新的
		mv /root/${oldName} /root/${newName}
		###刪除舊檔案夾
		rm -rf /root/${oldName}

		## 修改資料夾名稱/root/${newName}/db/data/${oldName}
		###先複製一份新的
		mv /root/${newName}/db/data/${oldName} /root/${newName}/db/data/${newName}
		###刪除舊檔案夾
		rm -rf /root/${newName}/db/data/${oldName}


	#3.改檔案名並改內容

		## 修改build.sh檔案
		mv /root/rpmbuild/build.sh /root/rpmbuild/build2.sh
		sed -e "s/${oldName}/${newName}/g" /root/rpmbuild/build2.sh > /root/rpmbuild/build.sh
		chmod +x /root/rpmbuild/build.sh
		rm -rf /root/rpmbuild/build2.sh

		### 修改資料夾名稱/root/rpmbuild/SPECS/asmanager.spec
		#sed -e "s/${oldName}/${newName}/g" -e "s/${oldBigName}/${newVersion}/g" /root/rpmbuild/SPECS/${oldName}.spec > /root/rpmbuild/SPECS/${newName}.spec
		#chmod +x /root/rpmbuild/SPECS/${newName}.spec
		#rm -rf /root/rpmbuild/SPECS/${oldName}.spec
		
		## 更改檔案名稱/asmanager-1.1.0/asmanagerdb.service
		sed -e "s/${oldBigName}/${newVersion}/g" -e "s/${oldName}/${newName}/g" /root/${newName}-1.1.0/${oldName}db.service > /root/${newName}-1.1.0/${newName}db.service
		chmod +x /root/${newName}-1.1.0/${newName}db.service
		rm -rf /root/${newName}-1.1.0/${oldName}db.service
		
		## 更改檔案名稱/asmanager-1.1.0/asmanagerweb.service
		sed -e "s/${oldBigName}/${newVersion}/g" -e "s/${oldName}/${newName}/g" /root/${newName}-1.1.0/${oldName}web.service > /root/${newName}-1.1.0/${newName}web.service
		chmod +x /root/${newName}-1.1.0/${newName}web.service
		rm -rf /root/${newName}-1.1.0/${oldName}web.service
		
		## 更改內容/root/${newName}-1.1.0/install.sh
		mv /root/${newName}-1.1.0/install.sh /root/${newName}-1.1.0/install2.sh
		sed -e "s/${oldName}/${newName}/g" /root/${newName}-1.1.0/install2.sh > /root/${newName}-1.1.0/install.sh
		chmod +x /root/${newName}-1.1.0/install.sh
		rm -rf /root/${newName}-1.1.0/install2.sh
		
		## 修改/root/${newName}/update.sh
		#先複製一份新的
		mv /root/${newName}/update.sh /root/${newName}/update2.sh
		sed -e "s/${oldName}/${newName}/g" /root/${newName}/update2.sh > /root/${newName}/update.sh
		chmod +x /root/${newName}/update.sh
		rm -rf /root/${newName}/update2.sh
	#4.刪除檔案
		rm -rf /root/${newName}/db/date/${oldName}.pid
		rm -rf /root/${newName}/db/${oldName}.sql

fi

if [ "\$(ls -A \$java)" ]; then  #檢查一個目錄是否為空目錄
	echo "copy Java"
	cd /root/${newName}/java
	#清空所有資料
	rm -rf *
	cp -r /root/temp/java/ /root/${newName}/
else
	echo "$java is Empty"
fi

if [ "\$(ls -A \$web)" ]; then
	echo "copy web"
	cd /root/${newName}/web
	#清空所有資料
	rm -rf *
	cp -r /root/temp/web/ /root/${newName}/
	# 產生setenv檔，設定環境變數
	cat > /root/${newName}/web/bin/setenv.sh <<EOF
	export JRE_HOME=/opt/${newName}/java
	export CATALINA_PID=/var/run/${newName}web.pid
	#export JAVA_OPTS="-Xms2048M -Xmx2048M"
EOF
	chmod +x /root/${newName}/web/bin/setenv.sh
else
	echo "$web is Empty"
fi


if [ "\$(ls -A \$webapps)" ]; then
	echo "copy webapps"
	cd /root/${newName}/web/webapps
	#清空所有資料
	rm -rf *
	cp -r /root/temp/web/webapps/ROOT /root/${newName}/web/webapps/
else
	echo "$webapps is Empty"
fi

	## 修改/root/temp/config/my.cnf
	sed -e "s/${oldName}/${newName}/g" /root/temp/config/my.cnf > /root/${newName}/db/my.cnf

if [ "\$(ls -A \$sql)" ]; then
	echo "copy sql"
	cp -r /root/temp/sql/${newName}.sql /root/${newName}/db
	chmod +x /root/${newName}/db/${newName}.sql
else
	echo "sql is Empty"
fi

#------------------------------------------------------------------------------------------------------------------------------------
	rm -rf /root/rpmbuild/SPECS/${oldName}.spec
	cat > /root/rpmbuild/SPECS/${newName}.spec <<_EOF_

%define SOURCE_DIR ${newName}-${newVersion}
%define SOURCE_NAME %{SOURCE_DIR}.tar.gz
Name:       ${newName}
Version:    ${newVersion}
Release:    1
Vendor:     ascentac
Summary:    ${newBigName} X86_64
License:    ascentac
Source0:    ${newName}-${newVersion}.tar.gz
%description
${newBigName} package


%prep
%setup -q

%install
rm -rf %{buildroot}
mkdir -p %buildroot/tmp
cp %{SOURCE0} %buildroot/tmp


%clean
rm -rf %{buildroot}
%post
cd /tmp
tar zxvf %{SOURCE_NAME} > /dev/null
cd %{SOURCE_DIR}
./install.sh > /dev/null
cd ..
rm -rf %{SOURCE_DIR}
> /tmp/%{SOURCE_NAME}
%files
/tmp/%{SOURCE_NAME}
%defattr (-,root,root)
%postun
service ${newName}db stop
service ${newName}web stop
rm -rf /opt/${newName}
/sbin/chkconfig --del ${newName}web
/sbin/chkconfig --del ${newName}db
rm -f /etc/init.d/${newName}web
rm -f /etc/init.d/${newName}db


_EOF_
	chmod +x /root/rpmbuild/SPECS/${newName}.spec
			

#!/bin/bash
#�ܼ�
newName=wdm
newBigName=WDM
newVersion=1.2.0
password=W0m@WSX


############################################################################################################################
#  �Эק�j�p�g�ܼƦW�١A�������ηs����Ʈw�K�X
# �бN�Өt�Ϊ�tomcat��Jroot/temp/web ��
# �бN�Өt�Ϊ�sql�� ��J root/temp/sql ��
# �бN�Өt�Ϊ�java �ɩ�J /root/temp/java ��
############################################################################################################################

#�Фŧ��
oldName=asmanager
oldBigName=ASManager
oldVersion=1.1.0
oldPassword=M8r@WSX


#------------------------------------------------------------------------------------------------------------------------------------	
	cat > /root/rpmbuild.sh <<_EOF_
#!/bin/bash

# �۰ʰ��楴�]rpm
# ���}���n��x�v��
# chmod +x rpmbuild2.sh

# �ƻswebapps�����-��ʥh�ƻs
# cp -rf /opt/${newName}/web/webapps/*/ /root/${newName}/web/webapps
# �ƻsdb�����-��ʥh�ƻs


# ���s���
cd /root/
mkdir -p /root/${newName}-${newVersion}
cp -rf /root/${newName}-${oldVersion}/* /root/${newName}-${newVersion}

# �ƻsroot
cd /root/${newName}
tar zcvf /root/${newName}-${newVersion}/${newName}.tar.gz **

# ���]
cd /root
tar zcvf /root/rpmbuild/SOURCES/${newName}-${newVersion}.tar.gz ${newName}-${newVersion}
yum -y install rpm-build
rpmbuild -ba /root/rpmbuild/SPECS/${newName}.spec


# �R�����s�������
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

#����sql
DROP DATABASE IF EXISTS asmanager;
# �Ȱ���Ŷ�
SET GLOBAL innodb_file_per_table = OFF;
# ����sql
source /root/${newName}/db/${newName}.sql;
# ���K�X
SET password for 'root'@'localhost'=password('${password}');  
exit;
EOF

#�Ȱ���Ʈw: 
service ${newName}db stop
#���Ydb
echo "zip db"
cd /opt/${newName}/
tar zcvf ${newName}_db.tar.gz db
#���ʦ�m
echo "move"
mv /opt/${newName}/${newName}_db.tar.gz /root/${newName}/
#�R����db
echo "delete old db"
cd /root/${newName}/
rm -rf db
#�����s��db
echo "tar -zxvf ${newName}_db.tar.gz"
tar zxvf ${newName}_db.tar.gz
#�R��db��tar��
echo "delete db.tar"
rm -rf ${newName}_db.tar.gz
# ����
echo "RPM Please repackage "
echo end


_EOF_
	chmod +x /root/db.sh
#------------------------------------------------------------------------------------------------------------------------------------		
	
#��W�A�����ɮ׵�


java=/root/temp/java
web=/root/temp/web
webapps=/root/temp/web/webapps

###���Y�h���ɮ�  tar zcvf rpmbuildAll.tar.gz rpmbuild asmanager-1.1.0 asmanager rpmbuild.sh

if [ "${oldName}" != "${newName}" ];then
	# 1.�����Y
	#tar zxvf rpmbuildAll.tar.gz
	#rm -rf rpmbuildAll.tar.gz

	# 2.���Ƨ�
		## �ק��Ƨ��W��/root/${oldName}-1.1.0
		###���ƻs�@���s��
		mv /root/${oldName}-1.1.0 /root/${newName}-1.1.0
		###�R�����ɮק�
		rm -rf /root/${oldName}-1.1.0

		## �ק��Ƨ��W��/root/${oldName}
		###���ƻs�@���s��
		mv /root/${oldName} /root/${newName}
		###�R�����ɮק�
		rm -rf /root/${oldName}

		## �ק��Ƨ��W��/root/${newName}/db/data/${oldName}
		###���ƻs�@���s��
		mv /root/${newName}/db/data/${oldName} /root/${newName}/db/data/${newName}
		###�R�����ɮק�
		rm -rf /root/${newName}/db/data/${oldName}


	#3.���ɮצW�ç鷺�e

		## �ק�build.sh�ɮ�
		mv /root/rpmbuild/build.sh /root/rpmbuild/build2.sh
		sed -e "s/${oldName}/${newName}/g" /root/rpmbuild/build2.sh > /root/rpmbuild/build.sh
		chmod +x /root/rpmbuild/build.sh
		rm -rf /root/rpmbuild/build2.sh

		### �ק��Ƨ��W��/root/rpmbuild/SPECS/asmanager.spec
		#sed -e "s/${oldName}/${newName}/g" -e "s/${oldBigName}/${newVersion}/g" /root/rpmbuild/SPECS/${oldName}.spec > /root/rpmbuild/SPECS/${newName}.spec
		#chmod +x /root/rpmbuild/SPECS/${newName}.spec
		#rm -rf /root/rpmbuild/SPECS/${oldName}.spec
		
		## ����ɮצW��/asmanager-1.1.0/asmanagerdb.service
		sed -e "s/${oldBigName}/${newVersion}/g" -e "s/${oldName}/${newName}/g" /root/${newName}-1.1.0/${oldName}db.service > /root/${newName}-1.1.0/${newName}db.service
		chmod +x /root/${newName}-1.1.0/${newName}db.service
		rm -rf /root/${newName}-1.1.0/${oldName}db.service
		
		## ����ɮצW��/asmanager-1.1.0/asmanagerweb.service
		sed -e "s/${oldBigName}/${newVersion}/g" -e "s/${oldName}/${newName}/g" /root/${newName}-1.1.0/${oldName}web.service > /root/${newName}-1.1.0/${newName}web.service
		chmod +x /root/${newName}-1.1.0/${newName}web.service
		rm -rf /root/${newName}-1.1.0/${oldName}web.service
		
		## ��鷺�e/root/${newName}-1.1.0/install.sh
		mv /root/${newName}-1.1.0/install.sh /root/${newName}-1.1.0/install2.sh
		sed -e "s/${oldName}/${newName}/g" /root/${newName}-1.1.0/install2.sh > /root/${newName}-1.1.0/install.sh
		chmod +x /root/${newName}-1.1.0/install.sh
		rm -rf /root/${newName}-1.1.0/install2.sh
		
		## �ק�/root/${newName}/update.sh
		#���ƻs�@���s��
		mv /root/${newName}/update.sh /root/${newName}/update2.sh
		sed -e "s/${oldName}/${newName}/g" /root/${newName}/update2.sh > /root/${newName}/update.sh
		chmod +x /root/${newName}/update.sh
		rm -rf /root/${newName}/update2.sh
	#4.�R���ɮ�
		rm -rf /root/${newName}/db/date/${oldName}.pid
		rm -rf /root/${newName}/db/${oldName}.sql

fi

if [ "\$(ls -A \$java)" ]; then  #�ˬd�@�ӥؿ��O�_���ťؿ�
	echo "copy Java"
	cd /root/${newName}/java
	#�M�ũҦ����
	rm -rf *
	cp -r /root/temp/java/ /root/${newName}/
else
	echo "$java is Empty"
fi

if [ "\$(ls -A \$web)" ]; then
	echo "copy web"
	cd /root/${newName}/web
	#�M�ũҦ����
	rm -rf *
	cp -r /root/temp/web/ /root/${newName}/
	# ����setenv�ɡA�]�w�����ܼ�
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
	#�M�ũҦ����
	rm -rf *
	cp -r /root/temp/web/webapps/ROOT /root/${newName}/web/webapps/
else
	echo "$webapps is Empty"
fi

	## �ק�/root/temp/config/my.cnf
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
			

#!/bin/bash

# 自動執行打包rpm
# 此腳本要給x權限
# chmod +x rpmbuild2.sh

# 複製webapps的資料-手動去複製
# cp -rf /opt/wdm/web/webapps/*/ /root/wdm/web/webapps
# 複製db的資料-手動去複製


# 產製資料
cd /root/
mkdir -p /root/wdm-1.2.0
cp -rf /root/wdm-1.1.0/* /root/wdm-1.2.0

# 複製root
cd /root/wdm
tar zcvf /root/wdm-1.2.0/wdm.tar.gz **

# 打包
cd /root
tar zcvf /root/rpmbuild/SOURCES/wdm-1.2.0.tar.gz wdm-1.2.0
yum -y install rpm-build
rpmbuild -ba /root/rpmbuild/SPECS/wdm.spec


# 刪除產製中的資料
mv -f /root/rpmbuild/RPMS/x86_64/wdm-1.2.0-1.x86_64.rpm /root/wdm-1.2.0-1.x86_64.rpm		
rm -rf /root/wdm-1.2.0	
rm -rf /root/rpmbuild/SRPMS/wdm-1.2.0-1.src.rpm	
rm -rf /root/rpmbuild/SOURCES/wdm-1.2.0.tar.gz
rm -rf /root/rpmbuild/BUILD/wdm-1.2.0

#!/bin/bash

# �۰ʰ��楴�]rpm
# ���}���n��x�v��
# chmod +x rpmbuild2.sh

# �ƻswebapps�����-��ʥh�ƻs
# cp -rf /opt/wdm/web/webapps/*/ /root/wdm/web/webapps
# �ƻsdb�����-��ʥh�ƻs


# ���s���
cd /root/
mkdir -p /root/wdm-1.2.0
cp -rf /root/wdm-1.1.0/* /root/wdm-1.2.0

# �ƻsroot
cd /root/wdm
tar zcvf /root/wdm-1.2.0/wdm.tar.gz **

# ���]
cd /root
tar zcvf /root/rpmbuild/SOURCES/wdm-1.2.0.tar.gz wdm-1.2.0
yum -y install rpm-build
rpmbuild -ba /root/rpmbuild/SPECS/wdm.spec


# �R�����s�������
mv -f /root/rpmbuild/RPMS/x86_64/wdm-1.2.0-1.x86_64.rpm /root/wdm-1.2.0-1.x86_64.rpm		
rm -rf /root/wdm-1.2.0	
rm -rf /root/rpmbuild/SRPMS/wdm-1.2.0-1.src.rpm	
rm -rf /root/rpmbuild/SOURCES/wdm-1.2.0.tar.gz
rm -rf /root/rpmbuild/BUILD/wdm-1.2.0

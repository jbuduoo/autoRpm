#!/bin/bash

echo /opt/wdm/db/bin/mysql -u root -pM8r@WSX --socket=/tmp/wdmdb.sock
/opt/wdm/db/bin/mysql -u root -pM8r@WSX --socket=/tmp/wdmdb.sock <<EOF

#����sql
DROP DATABASE IF EXISTS asmanager;
# �Ȱ���Ŷ�
SET GLOBAL innodb_file_per_table = OFF;
# ����sql
source /root/wdm/db/wdm.sql;
# ���K�X
SET password for 'root'@'localhost'=password('W0m@WSX');  
exit;
EOF

#�Ȱ���Ʈw: 
service wdmdb stop
#���Ydb
echo "zip db"
cd /opt/wdm/
tar zcvf wdm_db.tar.gz db
#���ʦ�m
echo "move"
mv /opt/wdm/wdm_db.tar.gz /root/wdm/
#�R����db
echo "delete old db"
cd /root/wdm/
rm -rf db
#�����s��db
echo "tar -zxvf wdm_db.tar.gz"
tar zxvf wdm_db.tar.gz
#�R��db��tar��
echo "delete db.tar"
rm -rf wdm_db.tar.gz
# ����
echo "RPM Please repackage "
echo end



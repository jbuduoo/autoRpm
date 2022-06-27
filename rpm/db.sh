#!/bin/bash

echo /opt/wdm/db/bin/mysql -u root -pM8r@WSX --socket=/tmp/wdmdb.sock
/opt/wdm/db/bin/mysql -u root -pM8r@WSX --socket=/tmp/wdmdb.sock <<EOF

#執行sql
DROP DATABASE IF EXISTS asmanager;
# 暫停表空間
SET GLOBAL innodb_file_per_table = OFF;
# 執行sql
source /root/wdm/db/wdm.sql;
# 更改密碼
SET password for 'root'@'localhost'=password('W0m@WSX');  
exit;
EOF

#暫停資料庫: 
service wdmdb stop
#壓縮db
echo "zip db"
cd /opt/wdm/
tar zcvf wdm_db.tar.gz db
#移動位置
echo "move"
mv /opt/wdm/wdm_db.tar.gz /root/wdm/
#刪除舊db
echo "delete old db"
cd /root/wdm/
rm -rf db
#解壓新的db
echo "tar -zxvf wdm_db.tar.gz"
tar zxvf wdm_db.tar.gz
#刪除db的tar檔
echo "delete db.tar"
rm -rf wdm_db.tar.gz
# 結束
echo "RPM Please repackage "
echo end



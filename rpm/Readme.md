


# 自動化打包工具

# 快速打包
1.解壓縮rpmbuildAllR2.tar.gz
  tar -zxvf rpmbuildAllR2.tar.gz
產生asmanager、asmanager-1.1.0、rpmbuild、temp、start.sh
2.修改start.sh的內容
  #修改變數
  newName=wdm
  newBigName=WDM
  newVersion=1.2.0
  password=W0m@WSX

  # 修改temp裡的資料夾(java,sql,web,webapps)
  1)請修改大小寫變數名稱，版本號及新的資料庫密碼
  2)請將該系統的tomcat放入root/temp/web 中
  3)請將該系統的sql檔 放入 root/temp/sql 中
  4)請將該系統的java 檔放入 /root/temp/java 中
  5)請將該系統的 root 檔放入 /root/temp/webapps 中
3.執行start.sh
  資料夾成該專案的名稱
  產生rpmbuild.sh及db.sh的檔案
4.執行rpmbuild打包
  產生xxx-1.1.1-1.x86_64.rpm
5.製造新的資料庫:db.sh
6.執行rpmbuild打包
  產生新的xxx-1.1.1-1.x86_64.rpm
  

####centos中安装docker

------

#####查看防火墙的状态
```
firewall-cmd --state或者systemctl status firewalld
```
#####开启防火墙
```
systemctl start firewalld.service
```
#####停止
```
systemctl disable firewalld
```
#####重新加载防火墙
```
firewall-cmd –-reload
```
#####禁用防火墙
```
systemctl stop firewalld
```
#####设置开机自启防火墙
```
systemctl enable firewalld
```
#####打开一个端口（如22）
```
firewall-cmd --zone=public --add-port=22/tcp --permanent
```
#####查看防火墙打开的所有端口
```
firewall-cmd --zone=public --list-ports
```
#####关闭防火墙开启的端口（如22）
```
firewall-cmd --zone=public --remove-port=22/tcp --permanent
```
#####重启docker服务
```
systemctl restart docker
```
#####docker中进入容器(如mysql,如下命令中的mysql为docker中的容器名)
```
docker exec -it mysql bash
```
#####mysql 修改root用户密码
```
alter user'root'@'%' IDENTIFIED BY 'root';    
flush privileges;(刷新权限)
```
#####docker中关闭一个容器
```
docker container stop CONTAINER_ID
```
#####docker中删除一个容器
```
docker container rm CONTAINER_ID
```
#####docker中redis和mysql设置为自启动
```
docker update redis --restart=always
docker update mysql --restart=always
```
#####docker中运行nacos
```
docker  run --name nacos -d -p 8848:8848 --privileged=true --restart=always -e MODE=standalone -v /usr/local/nacos/logs:/home/nacos/logs -v /usr/local/nacos/init.d/custom.properties:/home/nacos/init.d/custom.properties nacos/nacos-server
```
#####docker中查询mysqlIP地址
```
docker inspect mysql | grep IPAddress
```
#####文件复制到docker中的容器中去
```
docker cp /usr/local/mysql-connector-java-5.1.46.jar nacos:/home/nacos/plugins/mysql
```
#####nacos 源码打包命令
```
mvn -Prelease-nacos -DskipTests -Drat.skip=true clean install -U
```
#####解决docker中mysql中文显示为???乱码问题
```
	1.进入mysql容器
	2.查看外部连接层编码:SHOW VARIABLES LIKE 'collation_%';
	3.查看数据库字符集：SHOW VARIABLES LIKE 'character_set_%';
	4.解决外部访问乱码问题:SET NAMES 'utf8';（等于SET character_set_client = utf8;SET character_set_results = utf8;SET character_set_connection = utf8;）
	5.重新进入容器内部 ,但不登陆数据库,也就是到这一步:docker exec -it mysql bash
	6.我们cd到etc/mysql/mysql.conf.d下
	7.执行apt-get update			apt-get install vim					vim mysqld.cnf

	[mysqld]
	pid-file        = /var/run/mysqld/mysqld.pid
	socket          = /var/run/mysqld/mysqld.sock
	datadir         = /var/lib/mysql
	default-character-set = utf8

	[mysql.server]
	default-character-set = utf8
	[mysqld_safe]
	default-character-set = utf8
	[client]
	default-character-set = utf8
```
#####修改docker中mysql的时区
```
	1.进入容器 ：docker exec -it mysql bash
	2.到目标目录 ：cd /etc/mysql
	3.追加到文件末尾:echo "default-time-zone = '+08:00'">>my.cnf
	4.退出mysql容器然后重启容器
```
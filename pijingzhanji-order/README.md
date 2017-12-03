# -对接华海乐盈商城数据-服务工程

以ActiveMQ进行通信


# 服务管理
http://blog.didispace.com/spring-boot-run-backend/
## 以脚本管理
+ start.sh 
启动服务
+ stop.sh
关闭服务 
+ restart.sh
重启服务

## 以系统服务进行管理


sudo ln -s /xxx/xxx/order-server.jar /etc/init.d/order-server
	
/etc/init.d/order-server start|stop|restart

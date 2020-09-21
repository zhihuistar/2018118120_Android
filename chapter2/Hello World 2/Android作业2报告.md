直接运行程序说明singleTask、standard、singleTop和singleInstance四种启动模式的返回栈管理模式

一、singleTask（Hello1活动为singleTask启动模式）

1、运行程序，显示Hello1活动

![img](Android作业2报告.assets/wps1.jpg) 

2、点击TOHELLO2，显示Hello2活动

![img](Android作业2报告.assets/wps2.jpg) 

3、点击TOHELLO1，显示Hello1

![img](Android作业2报告.assets/wps3.jpg) 

4、点击返回键，程序退出，回到桌面

![img](Android作业2报告.assets/wps4.jpg) 

二、standard（Hello2活动为standard启动模式）

1、运行程序，显示Hello1活动

![img](Android作业2报告.assets/wps5.jpg) 

2、点击TOHELLO2，显示Hello2活动

![img](Android作业2报告.assets/wps6.jpg) 

3、再点击TOHELLO2，显示Hello2活动

![img](Android作业2报告.assets/wps7.jpg) 

4、点击返回键，回到Hello2活动

![img](Android作业2报告.assets/wps8.jpg) 

5、点击返回键，回到Hello1活动

![img](Android作业2报告.assets/wps9.jpg) 

6、点击返回键，程序退出，回到桌面

![img](Android作业2报告.assets/wps10.jpg) 

三、singleTop（Hello3活动为singleTop启动模式）

1、运行程序，显示Hello1活动

![img](Android作业2报告.assets/wps11.jpg) 

2、点击TOHELLO3，显示Hello3活动

![img](Android作业2报告.assets/wps12.jpg) 

3、再点击TOHELLO3，显示Hello3活动

![img](Android作业2报告.assets/wps13.jpg) 

4、点击TOHELLO2，显示Hello2活动

![img](Android作业2报告.assets/wps14.jpg) 

5、点击TOHELLO3，显示Hello3活动

![img](Android作业2报告.assets/wps15.jpg) 

6、点击返回键，回到Hello2活动

![img](Android作业2报告.assets/wps16.jpg) 

7、点击返回键，回到Hello3活动

![img](Android作业2报告.assets/wps17.jpg) 

8、点击返回键，回到Hello1活动

![img](Android作业2报告.assets/wps18.jpg) 

9、点击返回键，程序退出，回到桌面

![img](Android作业2报告.assets/wps19.jpg) 

四、singleInstance（Hello4活动为singleInstance启动模式）

1、运行程序，显示Hello1活动

![img](Android作业2报告.assets/wps20.jpg) 

2、点击TOHELLO4，显示Hello4活动

![img](Android作业2报告.assets/wps21-1600675072788.jpg) 

3、点击TOHELLO2，显示Hello2活动

![img](Android作业2报告.assets/wps22-1600675072789.jpg) 

4、点击返回键，回到Hello1活动

![img](Android作业2报告.assets/wps23-1600675072789.jpg) 

5、点击返回键，回到Hello4活动

![img](Android作业2报告.assets/wps24-1600675072789.jpg) 

6、点击返回键，程序退出，回到桌面

![img](Android作业2报告.assets/wps25-1600675072789.jpg) 
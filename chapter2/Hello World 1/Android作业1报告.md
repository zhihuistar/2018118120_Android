### ***\*实验目的：掌握并深入理解活动的生命周期\****

### ***\*实验要求：展示生命周期的回调函数在不同条件下的触发条件和运行机制\****

### ***\*实验内容：\****

通过调试一步步显示各步骤的函数调用

一、打开Hello1

1、运行程序，首先执行Hello1的onCreate()函数

![img](Android作业1报告.assets/wps21.jpg) 

2、执行Hello1的onStart()函数

![img](Android作业1报告.assets/wps22.jpg) 

3、执行Hello的onResume()函数

![img](Android作业1报告.assets/wps23.jpg) 

4、执行Hello1的onPostResume()函数

![img](Android作业1报告.assets/wps24.jpg) 

5、显示Hello1活动

![img](Android作业1报告.assets/wps25.jpg) 

二、打开Hello2

1、点击TOHELLO2，首先执行Hello1的onPause()函数

![img](Android作业1报告.assets/wps26.jpg) 

2、执行Hello2的onCreate()函数

![img](Android作业1报告.assets/wps27.jpg) 

3、执行Hello2的onStart()函数

![img](Android作业1报告.assets/wps28.jpg) 

4、执行Hello2的onResume()函数

![img](Android作业1报告.assets/wps29.jpg) 

5、执行Hello2的onPostResume()函数

![img](Android作业1报告.assets/wps30.jpg) 

6、执行Hello1的onStop()函数，显示Hello2活动

![img](Android作业1报告.assets/wps31.jpg) 

三、返回

1、点击返回键，首先执行Hello2的onPause()函数

![img](Android作业1报告.assets/wps32.jpg) 

2、执行Hello1的onStart()函数

![img](Android作业1报告.assets/wps33.jpg) 

3、执行Hello1的onResume()函数

![img](Android作业1报告.assets/wps34.jpg) 

4、执行Hello1的onPostResume()函数

![img](Android作业1报告.assets/wps35.jpg) 

5、执行Hello2的onStop()函数，返回到Hello1活动

![img](Android作业1报告.assets/wps36.jpg) 

6、执行Hello2的onDestroy()函数

![img](Android作业1报告.assets/wps37.jpg) 

四、再返回

1、点击返回键，首先执行Hello1的onPause()函数，回到桌面

![img](Android作业1报告.assets/wps38.jpg) 

2、执行Hello1的onStop()函数

![img](Android作业1报告.assets/wps39.jpg) 

3、执行Hello1的onDestroy()函数

![img](Android作业1报告.assets/wps40.jpg) 

### ***\*实验总结：\****

#### ***\*心得收获：通过debug调试，使我对安卓活动的生命周期有了更深刻的理解。掌握活动的生命周期可以更好的管理应用资源，\*******\*知晓程序运行过程中的步骤顺序，对未来的学习起很大的作用\*******\*。\****

#### ***\*评价：\****
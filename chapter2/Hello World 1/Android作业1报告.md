通过调试一步步显示各步骤的函数调用

一、打开Hello1

1、运行程序，首先执行Hello1的onCreate()函数

![img](D:\repo\chapter2\image\wps21.jpg) 

2、执行Hello1的onStart()函数

![img](D:\repo\chapter2\image\wps22.jpg) 

3、执行Hello的onResume()函数

![img](D:\repo\chapter2\image\wps23.jpg) 

4、执行Hello1的onPostResume()函数

![img](D:\repo\chapter2\image\wps24.jpg) 

5、显示Hello1活动

![img](D:\repo\chapter2\image\wps25.jpg) 

二、打开Hello2

1、点击TOHELLO2，首先执行Hello1的onPause()函数

![img](D:\repo\chapter2\image\wps26.jpg) 

2、执行Hello2的onCreate()函数

![img](D:\repo\chapter2\image\wps27.jpg) 

3、执行Hello2的onStart()函数

![img](D:\repo\chapter2\image\wps28.jpg) 

4、执行Hello2的onResume()函数

![img](D:\repo\chapter2\image\wps29.jpg) 

5、执行Hello2的onPostResume()函数

![img](D:\repo\chapter2\image\wps30.jpg) 

6、执行Hello1的onStop()函数，显示Hello2活动

![img](D:\repo\chapter2\image\wps31.jpg) 

三、返回

1、点击返回键，首先执行Hello2的onPause()函数

![img](D:\repo\chapter2\image\wps32.jpg) 

2、执行Hello1的onStart()函数

![img](D:\repo\chapter2\image\wps33.jpg) 

3、执行Hello1的onResume()函数

![img](D:\repo\chapter2\image\wps34.jpg) 

4、执行Hello1的onPostResume()函数

![img](D:\repo\chapter2\image\wps35.jpg) 

5、执行Hello2的onStop()函数，返回到Hello1活动

![img](D:\repo\chapter2\image\wps36.jpg) 

6、执行Hello2的onDestroy()函数

![img](D:\repo\chapter2\image\wps37.jpg) 

四、再返回

1、点击返回键，首先执行Hello1的onPause()函数，回到桌面

![img](D:\repo\chapter2\image\wps38.jpg) 

2、执行Hello1的onStop()函数

![img](D:\repo\chapter2\image\wps39.jpg) 

3、执行Hello1的onDestroy()函数

![img](D:\repo\chapter2\image\wps40.jpg) 
# SSMExam
# - 1 打开Exam7\src\main\resources\SpringConfig目录的applicationContext.xml文件修改数据库链接配置。    
配置位于id为"dataSource"的Bean中。其中：    
    username的value填写数据库用户名（如root）    
    password的value填写数据库密码（如123456）

#- 2 退回至SpringMybatisExam目录下，按住Shift+鼠标右键，选择在此处打开命令窗口（控制台）。

#- 3 输入 mvn compile指令，下载依赖，编译工程。

#- 4 输入 mvn jetty:run指令 运行项目，项目主页在http://localhost:9999/Exam7/821/login.html

#- 5 按照题目要求输入数据，观察结果。   
# 

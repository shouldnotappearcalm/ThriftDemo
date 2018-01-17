# ThriftDemo
开源rpc框架Thrift学习使用  

<b>注意事项</b>

1.xx.thrift 使用thrift --gen java xx.thrift用于执行生成service的java文件
idea中新建maven-webapp项目,不用自己在moudle setting新建source folder,执行thrift那个命令会自己生成

2.maven中编译执行环境均设置1.8

3.使用thrift -version查看版本号,maven中最好设置相同版本  我最初maven中0.11.0,thrift版本0.9.2一直报错,不是静态方法和xx什么,反正就是不能运行成功

4.windows中下载thrift-0.11.1.exe,改名为thrift.exe,将所在文件夹目录下加入windows的path的环境变量下
我debian类linux apt-get install thrift-compiler直接安装

5.idea中存在console,可以直接输命令,所在直接在这里面执行thrift命令就好

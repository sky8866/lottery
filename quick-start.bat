@echo off
echo [INFO] 确保默认JDK版本为JDK6.0及以上版本,已配置java_home.

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m

if exist "Program Files\maven\apache-maven-3.0.3\" set MVN="%cd%\Program Files\maven\apache-maven-3.0.3\bin\mvn.bat"
 
echo Maven命令为%MVN%
echo Ant命令为%ANT%

echo [Step 1] 安装所有modules到本地Maven仓库.
call %MVN% clean install -Pmodules -Dmaven.test.skip=true
if errorlevel 1 goto error


echo [Step 2] 为xiyuda-web启动Jetty.
cd webapps\xiyuda-web
start "xiyuda-web" %MVN% jetty:run -Djetty.port=8082
cd ..\..\


echo [INFO] fsns-web 快速启动完毕.
echo [INFO] 可访问以下演示网址:
echo [INFO] http://localhost:8082/xiyuda-web

goto end
:error
echo "有错误发生"
:end
pause
@echo off
echo [INFO] ȷ��Ĭ��JDK�汾ΪJDK6.0�����ϰ汾,������java_home.

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m

if exist "Program Files\maven\apache-maven-3.0.3\" set MVN="%cd%\Program Files\maven\apache-maven-3.0.3\bin\mvn.bat"
 
echo Maven����Ϊ%MVN%
echo Ant����Ϊ%ANT%

echo [Step 1] ��װ����modules������Maven�ֿ�.
call %MVN% clean install -Pmodules -Dmaven.test.skip=true
if errorlevel 1 goto error


echo [Step 2] Ϊxiyuda-web����Jetty.
cd webapps\xiyuda-web
start "xiyuda-web" %MVN% jetty:run -Djetty.port=8082
cd ..\..\


echo [INFO] fsns-web �����������.
echo [INFO] �ɷ���������ʾ��ַ:
echo [INFO] http://localhost:8082/xiyuda-web

goto end
:error
echo "�д�����"
:end
pause
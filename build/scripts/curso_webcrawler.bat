@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  curso_webcrawler startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and CURSO_WEBCRAWLER_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\curso_webcrawler-1.0-SNAPSHOT.jar;%APP_HOME%\lib\http-builder-ng-apache-1.0.4.jar;%APP_HOME%\lib\commons-io-2.11.0.jar;%APP_HOME%\lib\http-builder-ng-core-1.0.4.jar;%APP_HOME%\lib\slf4j-api-1.8.0-alpha0.jar;%APP_HOME%\lib\jsoup-1.14.3.jar;%APP_HOME%\lib\groovy-ant-2.5.4.jar;%APP_HOME%\lib\groovy-cli-commons-2.5.4.jar;%APP_HOME%\lib\groovy-groovysh-2.5.4.jar;%APP_HOME%\lib\groovy-console-2.5.4.jar;%APP_HOME%\lib\groovy-groovydoc-2.5.4.jar;%APP_HOME%\lib\groovy-docgenerator-2.5.4.jar;%APP_HOME%\lib\groovy-cli-picocli-2.5.4.jar;%APP_HOME%\lib\groovy-datetime-2.5.4.jar;%APP_HOME%\lib\groovy-jmx-2.5.4.jar;%APP_HOME%\lib\groovy-json-2.5.4.jar;%APP_HOME%\lib\groovy-jsr223-2.5.4.jar;%APP_HOME%\lib\groovy-macro-2.5.4.jar;%APP_HOME%\lib\groovy-nio-2.5.4.jar;%APP_HOME%\lib\groovy-servlet-2.5.4.jar;%APP_HOME%\lib\groovy-sql-2.5.4.jar;%APP_HOME%\lib\groovy-swing-2.5.4.jar;%APP_HOME%\lib\groovy-templates-2.5.4.jar;%APP_HOME%\lib\groovy-test-2.5.4.jar;%APP_HOME%\lib\groovy-test-junit5-2.5.4.jar;%APP_HOME%\lib\groovy-testng-2.5.4.jar;%APP_HOME%\lib\groovy-xml-2.5.4.jar;%APP_HOME%\lib\groovy-2.5.4.jar;%APP_HOME%\lib\httpmime-4.5.2.jar;%APP_HOME%\lib\httpclient-4.5.2.jar;%APP_HOME%\lib\ant-junit-1.9.13.jar;%APP_HOME%\lib\ant-1.9.13.jar;%APP_HOME%\lib\ant-launcher-1.9.13.jar;%APP_HOME%\lib\ant-antlr-1.9.13.jar;%APP_HOME%\lib\commons-cli-1.4.jar;%APP_HOME%\lib\picocli-3.7.0.jar;%APP_HOME%\lib\qdox-1.12.1.jar;%APP_HOME%\lib\jline-2.14.6.jar;%APP_HOME%\lib\junit-4.12.jar;%APP_HOME%\lib\junit-platform-launcher-1.3.1.jar;%APP_HOME%\lib\junit-jupiter-engine-5.3.1.jar;%APP_HOME%\lib\testng-6.13.1.jar;%APP_HOME%\lib\xml-resolver-1.2.jar;%APP_HOME%\lib\httpcore-4.4.4.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\commons-codec-1.9.jar;%APP_HOME%\lib\hamcrest-core-1.3.jar;%APP_HOME%\lib\junit-platform-engine-1.3.1.jar;%APP_HOME%\lib\junit-jupiter-api-5.3.1.jar;%APP_HOME%\lib\junit-platform-commons-1.3.1.jar;%APP_HOME%\lib\apiguardian-api-1.0.0.jar;%APP_HOME%\lib\jcommander-1.72.jar;%APP_HOME%\lib\opentest4j-1.1.1.jar


@rem Execute curso_webcrawler
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %CURSO_WEBCRAWLER_OPTS%  -classpath "%CLASSPATH%" crawler_scraping.App %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable CURSO_WEBCRAWLER_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%CURSO_WEBCRAWLER_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega

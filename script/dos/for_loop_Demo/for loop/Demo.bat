:: for /f "delims=" %%a in (UsbEnum.log) do set line[%%a]=1
:: for /f "delims=" %%i in (UsbEnum1st.log) do set line[%%i]=
:: for /f "token=1,* delims=[" %%a in ('set line[') do echo %%b >> config.log

rem for 命令可以带参数或不带参数，带参数时支持/d /l /r /f

goto no_parameter
:no_parameter
@echo off
cd /d d:\working
for %%i in (*.txt) do (
echo %%i 
if "%%i" == "activate.txt" (notepad %%i) 
)
pause

:no_parameter2
@echo off
cd /d d:\working
for %%i in (*.txt) do (
echo %%i 
if "%%i" == "activate.txt" (
echo bear >> %%i
notepad %%i) 
)
pause









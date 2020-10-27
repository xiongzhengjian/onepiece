@echo on

rem Default is "false", if you set DEBUG to "true" batch will show the value and pause script
set DEBUG=false
rem set DEBUG=true

rem !!FOR TEST ONLY!!
set TestUsbEnumLog=.\UsbEnum.log
set TestUSBTestINI=.\USBTest.ini
set TestUSBTestINI_IEC=.\USBTest_iec.ini

rem set environment
set UsbEnumLog1st=D:\VISION\DL\usb-diags\UsbEnum1st.log
set UsbEnumLog=D:\VISION\DL\usb-diags\UsbEnum.log
set UsbEnumlogconfig=D:\VISION\DL\usb-diags\UsbEnumConfig.log
set USBTestINI=D:\VISION\Scenarios\USB\USBTest.ini
set USBTestINI_IEC=D:\VISION\Scenarios\USB\USBTest_iec.ini
set DockingTestINI=D:\VISION\Scenarios\DockingStation\DockingStation.ini
set DockingTestINI_IEC=D:\VISION\Scenarios\DockingStation\DockingStation_iec.ini

rem set section and search strings
rem set TestSection="USB20L"
set USBStorageFixture="Mass Storage Device"
set USB20HubFixture="Generic USB Hub"
set USB30HubFixture="Generic SuperSpeed USB Hub"

rem set variables for port number and retry prompt id 
rem result=0 means pass, greater than 1 means retry times or fail.
if exist \VISION\DL\usb-diags\HubPass.flg (
set result=0
goto End
)

set /a result=1


if exist %USBTestINI% del %USBTestINI%
if exist %DockingTestINI% del %DockingTestINI%  
if exist %UsbEnumlogconfig% del /q %UsbEnumlogconfig%

setlocal enabledelayedexpansion

rem set variables for port number and retry prompt id 
set parameter=""
set port=""
set retryPrompt=""
if exist \IECUSB.flg set port=110 & set retryPrompt=110 & goto Ready
if exist \flags\leftusb20.fpc set port=210 & set retryPrompt=211 & goto Ready
if exist \flags\leftusb30.fpc set port=213 & set retryPrompt=214 & goto Ready
if exist \flags\rightusb20.fpc set port=216 & set retryPrompt=217 & goto Ready
if exist \flags\rightusb30.fpc set port=219 & set retryPrompt=220 & goto Ready
if exist \flags\typec20R.fpc set port=301 & set retryPrompt=311 & goto Ready
if exist \flags\typec30R.fpc set port=303 & set retryPrompt=313 & goto Ready

:Ready

if not exist \IECUSB.flg (
call \VISION\DL\spawn-diags\spawn-diags.exe -subtest=DialogBoxTest -ButtonStyle=OK -integratormsgfile=\VISION\Scenarios\USB\AllUSBTests.msg -prompt=%port%
call D:\wtools\wait.exe 3
)
goto START



:FAIL
set /a result+=1
echo THIS IS %result%
if %result%==4 goto END
if not exist \IECUSB.flg (
call \VISION\DL\spawn-diags\spawn-diags.exe -subtest=DialogBoxTest -ButtonStyle=OK -integratormsgfile=\VISION\Scenarios\USB\AllUSBTests.msg -prompt=%retryPrompt%
call D:\wtools\wait.exe 3
goto START
)

call \VISION\DL\spawn-diags\spawn-diags.exe -subtest=DialogBoxTest -ButtonStyle=OK -integratormsgfile=\VISION\Scenarios\USB\AllUSBTests.msg -prompt=502
call D:\wtools\wait.exe 3
goto START


:START
set hub=fail

    
  rem generate UsbEnum.log by -subtest=USBDeviceTest
  pushd D:\VISION\DL\usb-diags\
  usb-diags.exe -subtest=USBPortTest -Retries=0
  popd
  if %DEBUG%==true pause
  

rem to get usb Device of test hub
for /f "delims=" %%a in (%UsbEnumlog%) do set line[%%a]=1
for /f "delims=" %%i in (%UsbEnumLog1st%) do set line[%%i]=
for /f "tokens=1,* delims=[" %%a in ('set line[') do echo %%b >> %UsbEnumlogconfig%
rem FC %UsbEnumlog% %UsbEnumLog1st% /C /L /W > %UsbEnumlogconfig%



 find /i %USBStorageFixture% %UsbEnumlogconfig%
 if not errorlevel 1 (
 for /f "tokens=2 delims=[:" %%i in ('findstr /c:"Device " %UsbEnumlogconfig%') do set hub=%%i
 set result=0
 goto OverCheck
 )
 
 find /i %USB20HubFixture% %UsbEnumlogconfig%
 if not errorlevel 1 (
 for /f "tokens=2 delims=[:" %%i in ('findstr /c:"Hub " %UsbEnumlogconfig%') do set hub=%%i
 set result=0
 goto OverCheck
 )

 
 find /i %USB30HubFixture% %UsbEnumlogconfig%
 if not errorlevel 1 (
 for /f "tokens=2 delims=[:" %%i in ('findstr /c:"Hub " %UsbEnumlogconfig%') do set hub=%%i
 set result=0
 goto OverCheck
 )


:OverCheck
if "%hub%"=="fail" goto FAIL
if %result% neq 0 goto FAIL


:WRITE

for /f "delims=" %%i in (%USBTestINI_IEC%) do (
set parameter=%%i
set parameter=!parameter:@hub=%hub%!
echo !parameter! >> %USBTestINI%
)

for /f "delims=" %%i in (%DockingTestINI_IEC%) do (
set parameter=%%i
set parameter=!parameter:@hub=%hub%!
echo !parameter! >> %DockingTestINI%
)
echo USB Hub is %hub% > \VISION\DL\usb-diags\HubPass.flg

:END
if %DEBUG%==true echo result:%result%
if %DEBUG%==true pause

setlocal disabledelayedexpansion
exit /b %result%
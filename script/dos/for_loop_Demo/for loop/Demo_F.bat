

rem for 命令可以带参数或不带参数，带参数时支持/d /l /r /f

goto Demo2
:Demo1
echo off
for /f "usebackq tokens=1* delims==" %%i in (`set`) do (
 @echo[%%i----%%j]
)
pause

:demo2
echo off
setlocal enabledelayedexpansion
rem parse the diskpart infomation
echo list disk > liskdisk.txt
for /f "skip=8 tokens=1,2,3,4,*" %%a in ('diskpart.exe /s listdisk.txt') do (
 set checkdisk=%%b
 echo select disk !checkdisk! > detaildisk.log
 echo detail disk >> detaildisk.log
 diskpart /s "detaildisk.log"  
 diskpart /s "detaildisk.log" > emmcCheckdisk!checkdisk!.log
 
)
echo ======demo2 end=========
pause











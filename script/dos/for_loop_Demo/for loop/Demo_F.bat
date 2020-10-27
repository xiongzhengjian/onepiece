

rem for 命令可以带参数或不带参数，带参数时支持/d /l /r /f

goto Demo1
:Demo1
echo off
for /f "usebackq tokens=1* delims==" %%i in (`set`) do (
 @echo[%%i----%%j]
)
pause











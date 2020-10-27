goto demo6

:demo1
set a=4
set a=5 & echo %a%
pause


:demo2
setlocal enabledelayedexpansion
set a=4
set a=5&echo !a!
pause

:demo3
@echo off
for /l %%i in (1,1,5) do (set a=%%i
 echo %a%)
pause

:demo4
@echo off
setlocal enabledelayedexpansion
for /l %%i in (1,1,5) do (set a=%%i 
echo !a!)
pause

:demo5
@echo off
for /l %%i in (1,1,3) do (
set k=%%i :: evalue for k
echo %k% %%i
)
pause

:demo6
@echo off
setlocal enabledelayedexpansion
set k=3
for /l %%i in (1,1,3) do (
set k=%%i
echo %k% %%i
)
pause

:demo7
@echo off
setlocal enabledelayedexpansion
set k=3
for /l %%i in (1,1,3) do (
set k=%%i
echo !k! %%i
)

pause
rem === 2019 Feb.  Add TR firmware checking mechanism via Memory Address, read below memory address:
rem === 2019 Apr.  Read TR firmware/ SSID via ThunderboltUpdaterHost.CMD.exe has risk to get BSOD
rem -------------  Now use Inventec's ITC tool: memory_rw.exe (v1.6) to read TR firmware/ SSID
rem === 2019 May.  Read TR firmware/ SSID in EFI mode via IEC's tool IECTBTChecker.efi
rem -------------  the output log format is unicode, do not add ANSI log to same file under Windows
rem === 2020 Feb   BCU can get Thunderbolt FW from 2020 project, but no FW SSID output

rem === for Oleander
rem === TRFW SSID = 0x87258086 (Hex)
rem === FW 55.0.0.2.1 (Dec) = 0x00150055 (Hex)

rem === Memory address for TRFW / SSID
rem ===    0xF0100524  --> non WWAN SKU FW
rem ===    0xF01000B2  --> non WWAN SKU SSID
rem ===    0xF0300524  --> WWAN SKU FW
rem ===    0xF03000B2  --> WWAN SKU SSID
	if not defined BCU set BCU=\tools64\BiosConfigUtility64.exe

@echo off
	set CTRFW_VER=00790056
	set CTRFW_VER_Dec=56.0.1.2.1
        set TTRFW_VER=00790059
	set TTRFW_VER_Dec=59.0.1.2.1
	set TR_SSID=8725
        set CBIOS=Ver. 01.01.06
        set TBIOS=Ver. 01.01.07

:For_Fail_Retry
::	if exist \working\TRFW_Version_Error.log  del /q \working\TRFW_Version.log

        if not exist \working\TRFW_updateonce.flg goto Read_TRFW_in_EFI
        call \wtools\TRFW\ThunderboltUpdaterHost.CMD.exe -d > \working\TRFW_UpVision.log
        timeout /t 2
        find /i "%TTRFW_VER_Dec%" \working\TRFW_UpVision.log
        if "%errorlevel%" EQU "0" goto END  


:Read_TRFW_in_EFI
	rem === need to call IECTBTChecker.efi in efi mode and save log in advance
	if not exist \efi\tools64\IECTBTChecker.efi  goto Read_TRFW
	if not exist \working\TRFW_Version.log       goto Read_TRFW

	goto Check_TRFW


:Read_TRFW
    rem === 2020/02/21. below mechanism and address were came from Brighton
    rem === it may not work on 2020 project Oleander, need to check and modify, skip it now
   	goto Check_TRFW  
	if exist \working\TRFW_Version.log  del \working\TRFW_Version.log
	if not defined DEVCON set DEVCON=\Tools64\devcon.exe

::	set RW=\wtools\RW_Utility_x64\Rw.exe
	set MemoryRW=\wtools\TRFW\memory_rw.exe

	set FW_Adr_WWAN=0xF0200524
	set FW_Adr_NonWWAN=0xF0100524
	set SSID_Adr_WWAN=0xF02000B0
	set SSID_Adr_NonWWAN=0xF01000B0

	%DEVCON% rescan
	timeout /t 1
::	%RW% /Nologo /Command=\process\ReadTRFW.rw /LogFile=\working\TRFW_Version.log
	%MemoryRW% -r %FW_Adr_WWAN% 0x0 dword      >>\working\TRFW_Version.log
	%MemoryRW% -r %FW_Adr_NonWWAN% 0x0 dword   >>\working\TRFW_Version.log
	%MemoryRW% -r %SSID_Adr_WWAN% 0x0 dword    >>\working\TRFW_Version.log
	%MemoryRW% -r %SSID_Adr_NonWWAN% 0x0 dword >>\working\TRFW_Version.log


:Check_TRFW
        if exist d:\working\BCU_TRFW.log del d:\working\BCU_TRFW.log
        %BCU% /get:\working\BCU_TRFW.log
	find /i "%TR_SSID%" \working\TRFW_Version.log
	if "%errorlevel%" NEQ "0" set TRCHK=FW_SSID & goto TRFW_Fail

        FIND /i "AY108AV" D:\CTOHW.txt
        IF %errorlevel%==0 GOTO TTRFW
        FIND /i "AY116AV" D:\CTOHW.txt
        IF %errorlevel%==0 GOTO TTRFW		
	
        FIND /i "%CBIOS%" D:\working\BCU_TRFW.log
        IF %errorlevel%==0 GOTO CTRFW

        FIND /i "%TBIOS%" D:\working\BCU_TRFW.log
        IF %errorlevel%==0 GOTO TTRFW
	goto BIOS_Fail

:CTRFW
        echo CTRFW
	find /i "%CTRFW_VER%" \working\TRFW_Version.log
        if "%errorlevel%" EQU "0"  goto END
        set TRCHK=FW_Version & goto TRFW_Fail

:TTRFW
        echo TTRFW
        find /i "%TTRFW_VER%" \working\TRFW_Version.log
	if "%errorlevel%" NEQ "0"  if not exist \flags\TRFW_Update.fpc  set TRCHK=FW_Version & goto TRFW_Fail
	if "%errorlevel%" NEQ "0"  if exist \flags\TRFW_Update.fpc      goto Update_FW
	goto END


rem === applied FW update mechanism on PRB Reflow, remark it after that ========
:Update_FW
	color 0f

rem    ===================EMMC TRFW UPDATE ==============================================

if not defined BCU set BCU=\tools64\BiosConfigUtility64.exe
if defined fat32drv goto START

rem set up fat32drv environment variable
set fat32drv=%~d0
echo list volume > listvol.txt
for /f "skip=7 tokens=1,2,3,4,5,*" %%a in ('diskpart.exe /s listvol.txt') do if "%%d"=="DIAGPART1" if "%%e"=="FAT32" set fat32drv=%%c:
echo %fat32drv%


:START

%fat32drv%
setlocal enabledelayedexpansion
set Checkdisk=0
if exist %fat32drv%\working\eMMcSKU.log del /q %fat32drv%\working\eMMcSKU.log
if exist %fat32drv%\working\EmmcCheckDisk*.log del /q %fat32drv%\working\EmmcCheckDisk*.log
echo list disk > listdisk.txt 

for /f "skip=8 tokens=1,2,3,4,*" %%k in ('diskpart.exe /s listdisk.txt') do (
    set Checkdisk=%%l
    echo select disk !Checkdisk! > Detaildisk.log
    echo detail disk >> Detaildisk.log
    diskpart /s "Detaildisk.log" > %fat32drv%\working\EmmcCheckDisk!Checkdisk!.log
    find /i ": SD" %fat32drv%\working\EmmcCheckDisk!Checkdisk!.log
    if not errorlevel 1 echo Disk !Checkdisk! is an eMMC > %fat32drv%\working\eMMcSKU.log

    )

if not defined DEV set DEV=\tools64\devcon.exe
find /i "is an eMMC" \working\eMMcSKU.log
if "%errorlevel%" EQU "0" ( %DEV% disable "GenDisk" )
timeout -t 5

CALL D:\tools64\devcon.exe status * > D:\working\TG_NONTG.log
D:
findstr "VEN_NVME" D:\working\TG_NONTG.log > D:\working\TG_NONTG_NVME.log
set count=0
for /f "delims=" %%i in (D:\working\TG_NONTG_NVME.log) do (
    set /a count += 1
)
echo %count% 
if %count%==2 %DEV% disable "GenDisk"
echo TRFWEMMC update > \working\trfwemmc.log
timeout -t 5

rem    ===================EMMC TRFW UPDATE ==============================================
	pushd \wtools\TRFW\  
        IF EXIST D:\working\TRFW_updateonce.flg GOTO Update_FW_Fail
	ThunderboltUpdaterHost.CMD.exe -u > \working\TRFW_Update.log
        timeout /t 20
        echo reboot once update TRFW > \working\TRFW_updateonce.flg
        find /i "is an eMMC" \working\eMMcSKU.log
        if "%errorlevel%" EQU "0" ( %DEV% enable "GenDisk" )
        timeout /t 3
        if %count%==2 %DEV% enable "GenDisk"
        echo TRFWEMMC update > \working\trfwemmc.log
        timeout /t 3
        shutdown -r -t 3
        pause

:Update_FW_END
	
:Update_FW_Fail
	if exist \IECCloselid.flg call \process\errorout3.bat TRFW_UP_NG

	color cf
	@echo.========================================================
	@echo.
	@echo                TR FW Update Fail !!!!!
	@echo                TR FW Update Fail !!!!!
	@echo                TR FW Update Fail !!!!!
	@echo.
	@echo.========================================================
	echo.
	pause > nul

	goto Update_FW_Fail

rem === applied FW update mechanism on PRB Reflow, remark it after that ========

:BIOS_Fail
	cls
	color cf
	@echo.================================================
	@echo.
	@echo                BIOS Fail !!!!!
	@echo                BIOS Fail !!!!!
	@echo                BIOS Fail !!!!!
	@echo.
	@echo.================================================
	echo.
	copy \working\TRFW_Version.log \working\TRFW_Version_Error.log
	pause > nul
	goto BIOS_Fail

:TRFW_Fail
	if exist \IECCloselid.flg call \process\errorout3.bat TRFW_NG

	cls
	color cf
	@echo.================================================
	@echo.
	@echo             TR %TRCHK% Fail !!!!!
	@echo             TR %TRCHK% Fail !!!!!
	@echo             TR %TRCHK% Fail !!!!!
	@echo.
	@echo.================================================
	echo.
	copy \working\TRFW_Version.log \working\TRFW_Version_Error.log
	pause > nul
	goto TRFW_Fail




:END
	echo %Date% %Time% @@@ TR Firmware Check Pass > \flags\TRFW_Done.flg       
	del /q \working\TRFW_Version_Error.log
	popd

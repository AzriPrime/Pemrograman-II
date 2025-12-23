@echo off
echo Setting up Game Environment...

:: Set JAVA_HOME (Found by Agent)
set "JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17.0.17.10-hotspot"
set "PATH=%JAVA_HOME%\bin;%PATH%"

echo Java Home: %JAVA_HOME%

echo.
echo ========================================
echo Starting IndoWordle Roulette...
echo ========================================
echo.

:: Run the Executable JAR
if exist "build\libs\IndoWordleRoulette-1.0-SNAPSHOT-all.jar" (
    java -jar build\libs\IndoWordleRoulette-1.0-SNAPSHOT-all.jar
) else (
    echo [ERROR] JAR file not found at build\libs\IndoWordleRoulette-1.0-SNAPSHOT-all.jar
    echo Please build the project using Gradle first (Task: shadowJar).
)

echo.
if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] The game crashed or failed to start.
    echo Please check the error messages above.
)
pause

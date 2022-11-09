call ./runcrud
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo runcrud.bat has errors - breaking work
goto fail

:browser
Start http://localhost:8080/crud/v1/task/tasks
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work in finished
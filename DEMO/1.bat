if 1==0 (
注释：
    使用方式：
        在根目录创建一个叫1.bat的文件，然后将代码拷贝到文件里面。
        保存后，双击执行bat文件。等到cmd窗口出现请按任意键继续. . .的时候，就完事了。

原文链接 https://my.oschina.net/u/133911/blog/904621
)

@echo 处理中......
@echo off
for /d /r %1 %%A in (.) do (
  dir /a /b "%%~fA" 2>nul | findstr "^" >nul || echo >%%~fA\.gitignore
)
@echo 处理完毕。
pause
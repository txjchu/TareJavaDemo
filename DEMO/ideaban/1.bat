if 1==0 (
ע�ͣ�
    ʹ�÷�ʽ��
        �ڸ�Ŀ¼����һ����1.bat���ļ���Ȼ�󽫴��뿽�����ļ����档
        �����˫��ִ��bat�ļ����ȵ�cmd���ڳ����밴���������. . .��ʱ�򣬾������ˡ�

ԭ������ https://my.oschina.net/u/133911/blog/904621
)

@echo ������......
@echo off
for /d /r %1 %%A in (.) do (
  dir /a /b "%%~fA" 2>nul | findstr "^" >nul || echo >%%~fA\.gitignore
)
@echo ������ϡ�
pause
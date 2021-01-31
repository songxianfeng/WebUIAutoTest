# WebUIAutoTest
WebUI自动化测试代码

### 项目说明
本项目是通过Webdriver+java+TestNG+maven实现的WebUI自动化测试项目。

### 业务逻辑的封装
1，CommonFunctions package

(1) CommonFunctions类，Web页面的基本操作函数类；

(2) DataProvideOper类，TestNG DataProvider类；

(3) DataReader类，java读取xml文件操作，以返回供DataProvider类可使用的数据类型；

(4) TaoBaoOperation类，淘宝业务操作函数类；

2，TestCases packaage

具体的测试用例包

3，TestData文件夹

与测试用例一一对应的测试数据，格式为xml文件，数据文件名和测试用例文件名一致；

4，TestSuites文件夹

根据测试需求，组织不同的测试用例集，以供特定需求的验证测试，核心功能的回归测试，线上监控等！

### 使用说明
将项目下载下来，使用eclipse或是idea导入maven项目，待pom.xml更新完成后，就可以运行项目。

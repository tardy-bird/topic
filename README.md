本仓库为`Oomall`系统中的**专题微服务**。

`Oomall`系统，重构自[litemall](https://github.com/linlinjava/litemall)商城，使用面向对象软件设计的方式，借助微服务，使其成为可支持高并发、大负载需求的电商系统。

数据库设计、`Domain`层，`Controller`层设计以及一些`VO`，请参考

- [Domain, Controller and VO](https://github.com/hiijar/oomall)。

系统的所有外部接口遵循`REST`原则，分为微信小程序接口以及管理员控制台接口，具体请参考

- [Admin API](http://47.98.252.133:6185/)
- [Wx API](http://47.98.252.133:6195/)

使用严格的测试用例，保证系统的可用性。测试用例请参考

- [Standard Test Cases](https://github.com/Tllokn/OOMall-Test-Standard)



**已经实现的功能。**

- 管理员获取专题列表。
- 管理员获取专题详情。
- 用户获取专题列表。
- 用户获取专题详情。
- 管理员添加专题。
- 管理员编辑专题。 
- 管理员删除专题。
# 缓存模块

## 如何配置?

``` yml
# spring-cache redis 配置
pijingzhanji:
  spring:
    cache:
      redis-manager:
        # 全局默认过期时间
        default-expiration: 1800
        # 是否使用前缀
        use-prefix: true
        # 指定命名空间下的过期时间
        expires:
          users: 900
# redis 配置
pijingzhanji:
  redis:
    host: 192.168.70.179
    port: 6379
    timeout: 60
        
```

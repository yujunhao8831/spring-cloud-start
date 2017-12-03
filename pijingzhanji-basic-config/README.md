# 问题
因为该工程是jar形式,其他工程导入,主运行工程的Application必须在同一个包下,不然com.pijingzhanji.config的配置读取不了
后续需要解决该问题,

``` java
# 配置 scanBasePackages 即可
@SpringBootApplication(scanBasePackages = "com.pijingzhanji")
 ```

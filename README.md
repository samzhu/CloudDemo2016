## 這是一個 Spring Cloud 練習範例

### 請切換到 Branch Step1

請依照順序啟動下列服務

| 專案名稱 | 說明 |
| :-----------: | :-----------: |
| ConfigService |  設定檔服務 |
| DiscoveryService |  自動發現服務 |
| BookService |  後端資料服務 |
| WebService |  前端用戶介面 |
| ZuulService |  Proxy 服務 |

啟動完成後

1.檢視 ConfigService 有的設定檔

```
curl -X GET "http://localhost:8888/web-service/master"
```

2.檢視自動發現服務是否有服務註冊

[](http://localhost:8761/)

3.試驗後端服務是否可用

```
curl -X POST -H "Content-Type: application/json" -d '{"author": "作者","name": "書名"}' "http://localhost:8000/book"
```

4.檢視 WebService API 介面

開啟 [](http://localhost:5566/swagger-ui.html)
裡面會有三種版本 API
- v1 是原本 RestTemplate 呼叫後端的方法
- v2 是透過注入一個 LoadBalanced RestTemplate 來完成 LoadBalanced
- v3 是使用 聲明式註解 FeignClient 來定義後端服務

5.透過 ZuulService 轉發請求

```
curl -X GET "http://localhost:5978/book-service/book/3"
```

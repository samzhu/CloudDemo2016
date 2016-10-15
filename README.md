## 這是一個 Spring Cloud 練習範例

### 必要

需要一個 Mysql 如果沒有可利用 vagrant 來啟動一個 Mysql,並使用 create.sql 建立資料庫跟塞一些模擬資料

### 啟動

請依照順序啟動下列服務

| 專案名稱 | 說明 |
| :-----------: | :-----------: |
| ConfigService |  設定檔服務 |
| DiscoveryService |  自動發現服務 |
| HystrixDashboard |  程序守護監控 |
| ZipkinService |  分散式紀錄追蹤 |
| BookService |  後端資料服務 |
| WebService |  前端用戶介面 |
| ZuulService |  Proxy 服務 |

### 觀察

#### ConfigService
觀察你的APP會取得到怎樣的設定組態
http://localhost:8888/book-service/default

#### DiscoveryService
開啟 UI 觀察服務是否都註冊
http://localhost:8761/

#### BookService
使用了 spring-boot-starter-data-jpa 跟 spring-boot-starter-data-rest 基本上不用寫程式有有豐富的 RestAPI 可以使用

#### WebService
使用了 swagger 讓大家方便測試
http://localhost:5566/swagger-ui.html

#### ZuulService
Proxy 功能可以透過 http://localhost:5978/book-service/book/1 取得資料

#### ZipkinService
都開始呼叫後端API後,可以開啟 Zipkin UI http://localhost:9411 看看紀錄了什麼

#### HystrixDashboard
開啟 http://localhost:8010/hystrix 比如說我只要監控 WebService 的服務情況,輸入 http://localhost:5566/hystrix.stream 就可以監控,
或是透過 turbine 來收集同一個服務發現中心的服務整理狀況,在監控的網址列輸入 http://localhost:8010/turbine.stream 就可以了,
再試著將 BookService 服務關閉,來觀察無誤失敗時的警示狀況

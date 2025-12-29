# ZeroLatency Backend

Backend API cho hệ thống Chat Forum - ZeroLatency.

## 📋 Mô tả

Đây là backend service được xây dựng bằng **Spring Boot 4.0.1** với Java 21, cung cấp REST API cho ứng dụng Chat Forum.

## 🛠️ Công nghệ sử dụng

- **Java**: 21
- **Spring Boot**: 4.0.1
- **Spring Web MVC**: REST API
- **Maven**: Build tool

## 📁 Cấu trúc dự án

```
backend/
├── src/
│   ├── main/
│   │   ├── java/com/zerolatency/backend/
│   │   │   ├── BackendApplication.java    # Main application
│   │   │   ├── config/                    # Cấu hình ứng dụng
│   │   │   ├── controller/                # REST Controllers
│   │   │   ├── dto/                       # Data Transfer Objects
│   │   │   ├── model/                     # Entity models
│   │   │   ├── repo/                      # Repository layer
│   │   │   └── service/                   # Business logic
│   │   └── resources/
│   │       └── application.properties     # Cấu hình ứng dụng
│   └── test/                              # Unit tests
├── pom.xml                                # Maven dependencies
└── README.md
```

## 🚀 Cài đặt và Chạy

### Yêu cầu

- **JDK 21** hoặc cao hơn
- **Maven 3.6+**

### Các bước chạy

1. **Clone repository**

   ```bash
   git clone https://github.com/NDPhon/ZeroLatency.git
   cd ZeroLatency/backend
   ```

2. **Build project**

   ```bash
   ./mvnw clean install
   ```

3. **Chạy ứng dụng**

   ```bash
   ./mvnw spring-boot:run
   ```

4. **Truy cập ứng dụng**
   - URL: http://localhost:8081

## ⚙️ Cấu hình

Cấu hình ứng dụng trong file `src/main/resources/application.properties`:

```properties
spring.application.name=backend
server.port=8081
```

## 📡 API Endpoints

| Method | Endpoint | Mô tả                         |
| ------ | -------- | ----------------------------- |
| GET    | `/`      | Health check - trả về "hello" |

## 🧪 Chạy Tests

```bash
./mvnw test
```

## 📦 Build JAR

```bash
./mvnw clean package
```

File JAR sẽ được tạo tại `target/backend-0.0.1-SNAPSHOT.jar`

## 🔧 Chạy JAR

```bash
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

## 📚 Tài liệu tham khảo

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Spring Web MVC](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html)
- [Maven Documentation](https://maven.apache.org/guides/index.html)

## 👥 Đóng góp

1. Fork repository
2. Tạo branch mới (`git checkout -b feature/AmazingFeature`)
3. Commit thay đổi (`git commit -m 'Add some AmazingFeature'`)
4. Push lên branch (`git push origin feature/AmazingFeature`)
5. Tạo Pull Request

## 📄 License

Dự án này được phát triển cho mục đích học tập.

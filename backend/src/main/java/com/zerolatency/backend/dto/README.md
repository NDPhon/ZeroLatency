# 📤 DTO Layer (Data Transfer Object)

## Mô tả

Thư mục này chứa các **DTO classes** dùng để truyền dữ liệu giữa các layer và với client.

## Chức năng

- Định nghĩa cấu trúc dữ liệu cho API request/response
- Tách biệt entity với dữ liệu được expose ra ngoài
- Validation dữ liệu đầu vào
- Tùy chỉnh dữ liệu trả về cho client

## Quy tắc đặt tên

- Request DTO: `<Action><Entity>Request.java`
- Response DTO: `<Entity>Response.java`
- Ví dụ: `CreateUserRequest.java`, `UserResponse.java`, `LoginRequest.java`

## Ví dụ

### Request DTO

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
}
```

### Response DTO

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
}
```

## Annotation thường dùng

- `@Data`, `@Builder` - Lombok annotations
- `@NotBlank`, `@NotNull` - Validation không được trống
- `@Size` - Giới hạn độ dài
- `@Email` - Validate email format
- `@Pattern` - Validate theo regex
- `@Min`, `@Max` - Giới hạn giá trị số

# 🎮 Controller Layer

## Mô tả

Thư mục này chứa các **REST Controller** xử lý HTTP requests từ client.

## Chức năng

- Định nghĩa các API endpoints
- Xử lý HTTP requests (GET, POST, PUT, DELETE)
- Validate dữ liệu đầu vào
- Trả về HTTP responses phù hợp

## Quy tắc đặt tên

- Tên file: `<Entity>Controller.java`
- Ví dụ: `UserController.java`, `MessageController.java`, `AuthController.java`

## Ví dụ

```java
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody CreateUserRequest request) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userService.createUser(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
```

## Annotation thường dùng

- `@RestController` - Đánh dấu class là REST controller
- `@RequestMapping` - Base URL path
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` - HTTP methods
- `@PathVariable` - Lấy giá trị từ URL path
- `@RequestBody` - Lấy dữ liệu từ request body
- `@RequestParam` - Lấy query parameters
- `@Valid` - Trigger validation
- `@RequiredArgsConstructor` - Constructor injection với Lombok

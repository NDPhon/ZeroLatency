# 🗃️ Model Layer (Entity)

## Mô tả

Thư mục này chứa các **Entity classes** đại diện cho các bảng trong cơ sở dữ liệu.

## Chức năng

- Định nghĩa cấu trúc dữ liệu của các bảng trong database
- Ánh xạ (mapping) giữa Java objects và database tables
- Định nghĩa các quan hệ giữa các entity (One-to-One, One-to-Many, Many-to-Many)

## Quy tắc đặt tên

- Tên file: `<EntityName>.java`
- Ví dụ: `User.java`, `Message.java`, `ChatRoom.java`

## Ví dụ

```java
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
```

## Annotation thường dùng

- `@Entity` - Đánh dấu class là JPA entity
- `@Table` - Chỉ định tên bảng trong database
- `@Id` - Primary key
- `@GeneratedValue` - Auto-generate ID
- `@Column` - Cấu hình column
- `@OneToMany`, `@ManyToOne`, `@ManyToMany` - Quan hệ giữa các entity
- `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor` - Lombok annotations

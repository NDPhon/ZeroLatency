# 📦 Repository Layer

## Mô tả

Thư mục này chứa các **Repository Interface** của ứng dụng, đảm nhiệm việc tương tác với cơ sở dữ liệu.

## Chức năng

- Định nghĩa các interface kế thừa từ `JpaRepository` hoặc `CrudRepository`
- Cung cấp các phương thức CRUD cơ bản (Create, Read, Update, Delete)
- Định nghĩa các custom query methods
- Sử dụng Spring Data JPA để tự động implement các phương thức truy vấn

## Quy tắc đặt tên

- Tên file: `<EntityName>Repository.java`
- Ví dụ: `UserRepository.java`, `MessageRepository.java`

## Ví dụ

```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.status = :status")
    List<User> findByStatus(@Param("status") String status);
}
```

## Annotation thường dùng

- `@Repository` - Đánh dấu class là Repository component
- `@Query` - Custom JPQL/SQL query
- `@Param` - Bind parameter cho query
- `@Modifying` - Cho các query UPDATE/DELETE

# ⚙️ Configuration Layer

## Mô tả

Thư mục này chứa các **Configuration classes** để cấu hình các thành phần của ứng dụng.

## Chức năng

- Cấu hình Spring Security (authentication, authorization)
- Cấu hình CORS (Cross-Origin Resource Sharing)
- Cấu hình WebSocket cho real-time communication
- Cấu hình Swagger/OpenAPI documentation
- Định nghĩa các Bean cho dependency injection

## Quy tắc đặt tên

- Tên file: `<Feature>Config.java`
- Ví dụ: `SecurityConfig.java`, `WebSocketConfig.java`, `CorsConfig.java`

## Ví dụ

### Security Configuration

```java
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated()
            )
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

### WebSocket Configuration

```java
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic", "/queue");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
            .setAllowedOrigins("*")
            .withSockJS();
    }
}
```

### CORS Configuration

```java
@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
```

## Annotation thường dùng

- `@Configuration` - Đánh dấu class là configuration
- `@EnableWebSecurity` - Kích hoạt Spring Security
- `@EnableWebSocketMessageBroker` - Kích hoạt WebSocket
- `@Bean` - Định nghĩa Spring Bean
- `@Value` - Inject giá trị từ properties file

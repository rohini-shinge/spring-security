# spring-security

### LDAP Implementation

Required Dependencies for LDAP Implementation
```
<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
		<groupId>org.springframework.ldap</groupId>
		<artifactId>spring-ldap-core</artifactId>
</dependency>
<dependency>
		<groupId>org.springframework.security</groupId>
		<artifactId>spring-security-ldap</artifactId>
</dependency>
<dependency>
		<groupId>com.unboundid</groupId>
		<artifactId>unboundid-ldapsdk</artifactId>
</dependency>

```

Application.properties 

```
spring.ldap.embedded.base-dn=dc=springframework,dc=org 
spring.ldap.embedded.ldif=classpath:test-server.ldif 
spring.ldap.embedded.port=8389 
spring.ldap.embedded.url=ldap://localhost:8389/
```


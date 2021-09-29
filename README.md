#패스트레인 사전과제 ( 소요시간 35분 )

- 회원 테이블을 생성합니다. id와 password 컬럼만 가지고 있습니다  
- 회원 가입 기능을 구현해주세요.  
- 회원의 password 변경 기능을 구현해 주세요.  
- 회원 삭제 기능을 구현해주세요.  

# 조건
- Spring boot를 활용하며 JAVA JDK8 이상 버전을 꼭 사용해주세요.  
- password 보안에 대해서는 고민하지 않으셔도 됩니다. 단순한 CRUD를 구현해주세요.  
- 프론트엔드는 개발하지 않으셔도 됩니다. 웹 브라우저나 Postman을 사용 할 수 있도록 해주세요.
(API는 JSON 형식을 사용도록 합니다)  
- JPA를 사용하지 않으셔도 되며 회원 테이블의 create query를 꼭 제공해주세요.  

# 참고사항

```
 create table account (
       account_id varchar(255) not null,
        password varchar(255),
        primary key (account_id)
    )
```

- 단순한 CRUD 형태를 위한 로직입니다. 회원가입시 validate 로직은 제외하였습니다.  
> validateMethod() 예시
```
private void validateMethod(Account account) {
        List<Account> findAccount = repository.findById(account.getId());
        if (!findAccount.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

```
- updatePassword() 에서도 validate 로직이 필요하고 보안 이슈도 필요하지만 조건에 따라 간단하게 구현하였습니다.
> 간단한 validateMethod() 예시
```
import org.springframework.security.crypto.password.PasswordEncoder;
.
.
.
public void updatePassword(Account account, String newPassword) {
        account.setPassword(passwordEncoder.encode(newPassword));
        accountRepository.save(account);
    } 
```

# Postman JSON Example

POST http://localhost:8080/api/v1/accounts

```
{
    "id" : "1",
    "password" : "1234"
}
```

PUT http://localhost:8080/api/v1/accounts/password

```
{
    "id" : "1",
    "password" : "1234",
    "newPassword" : "test"
}
```

DELETE http://localhost:8080/api/v1/accounts

```
{
    "id" : "1",
    "password" : "1234"
}
```
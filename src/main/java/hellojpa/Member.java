package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// jpa를 사용한다는 것을 인식
@Entity
//@Table(name = "Member") // 객체와 테이블명이 다를때 사용 
public class Member {

    @Id // primary key를 알려준다.
    private Long id;

//    @Column(name = "name") // 컬럼과 다른 이름일때 사용
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

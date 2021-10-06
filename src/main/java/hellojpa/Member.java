package hellojpa;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity
 * 기본 생성자 필수
 * final 클래스, enum, interface 사용 X
 * 저장 필드에 final 사용 X
 */
@Entity
/**
 * Table
 * name 속성으로 다른 이름의 테이블 매핑 가능
 */
//@Table(name = "Member") // 객체와 테이블명이 다를때 사용 
public class Member {

    /**
     * Id
     * 기본키 직접 할당
     */
    @Id // primary key를 알려준다.

    /**
     * GeneratedValue
     * 기본키 자동 생성
     * IDENTITY : not null auto increment
     *            INSERT가 된 후에야 id를 알 수 있기 때문에 에외적으로 persist 시점에 INSERT (원래는 commit 시점)
     * SEQUENCE : sequence 값을 얻어와서 id로 사용하는 방식
     *            identity와 마찬가지로 id를 DB에 넣어봐야 알 수 있다.
     *
     * TABLE : 키 생성 전용 테이블을 하나 만들어 DB 시퀀스를 흉내내는 전략
     */
    @GeneratedValue()
    private Long id;

    /**
     * Column
     * name : 필드와 매핑할 테이블의 컬럼 이름
     * updatable : 등록, 변경 가능 여부
     * nullable : null값을 허용하는지
     * unique : unique 제약 조건을 건다. ( 잘 안씀 )
     * length : 길이 제한
     * columnDefinition : 컬럼 정보를 직접 입력
     */
    @Column(name = "username") // 컬럼과 다른 이름일때 사용
    private String name;

    // 변수 타입이 달라도 사용 가능
    private Integer age;

    // enum 타입 사용시 ( ORDINAL, STRING )
    // ORDINAL : 순서를 저장, STRING 문자열 그대로 저장.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // TIMESTAMP(날짜+시간), TIME(시간), DATE(날짜)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lasModifiedDate;

    // varchar를 넘는 큰걸 넣고 싶으면
    @Lob
    private String description;

    // DB에 사용 안하고 메모리에서만 사용하고 싶을 때 사용
    @Transient
    private int temp;



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

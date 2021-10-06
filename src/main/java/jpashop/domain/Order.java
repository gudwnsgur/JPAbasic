package jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;


    /**
     * 객체지향적이지 못한 설계
     * memberId 대신 Member 를 사용해야 한다.
     */
    @Column(name = "member_id")
    private Long memberId;


    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}

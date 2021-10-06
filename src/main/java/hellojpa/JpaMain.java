package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        // DB와 연결
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // connection을 하나 받는다.
        EntityManager em = emf.createEntityManager();

        // 코드 작성
        // 데이터를 변경하는 모든 작업은 트랜잭션 안에서 작업해야 한다.

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            /**
             * 생성
             */
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("Hyoung");
//            em.persist(member);

            /**
             * 조회
             */
//            Member findMember = em.find(Member.class, 1L);

            /**
             * 여러개 조회 : JPQL
             */
            // Member 객체를 대상으로 Query
//            List<Member> result = em.createQuery("SELECT m FROM Member m", Member.class).getResultList();



            /**
             * 수정
             */
//            Member member = em.find(Member.class, 1L);
//            member.setName("HyoungJoonHyuck");

            /**
             * 삭제
             */
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }


        em.close();
        emf.close();

    }
}

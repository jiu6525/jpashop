package jpql;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class jpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();

//            Member findMember = result.get(0);
//            findMember.setAge(20);

//            System.out.println("singleResult.getUsername() = " + result);

//            MemberDTO memberDTO = result.get(0);
//            System.out.println("memberDTO.getUsername() = " + memberDTO.getUsername());
//            System.out.println("memberDTO.getAge() = " + memberDTO.getAge());

            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();
//            String query = "select m.username, 'HELLO', true From Member m "
//                           + "where m.type = jpql.MemberType.ADMIN";
//            List<Object[]> result = em.createQuery(query)
//                    .getResultList();
//
//            for (Object[] objects : result) {
//                System.out.println("objects[0] = " + objects[0]);
//                System.out.println("objects[0] = " + objects[1]);
//                System.out.println("objects[0] = " + objects[2]);
//
//            }
            
//            String query = "select m from Member m where m.id = :memberId";
//
//            Member findMember = em.createQuery(query, Member.class)
//                    .setParameter("memberId", member1.getId())
//                    .getSingleResult();
//
//            System.out.println("findMember = " + findMember);

//            List<Member> resultList = em.createNamedQuery("Member.findByUsername", Member.class)
//                    .setParameter("username", "회원1")
//                    .getResultList();
//
//            for (Member member : resultList) {
//                System.out.println("member = " + member);
//            }

            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();

            em.clear();

            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("findMember.getAge() = " + findMember.getAge());
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();

        }finally {
            em.close();
        }

        emf.close();
    }

}
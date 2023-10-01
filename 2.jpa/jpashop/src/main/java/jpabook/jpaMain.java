package jpabook;

import jpabook.jpashop.domain.*;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class jpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

//            Team team = new Team();
//            team.setName("TeamA");
////            team.getMembers().add(member);
//            em.persist(team);
//
//            Member member = new Member();
//            member.setName("member1");
////            member.changeTeam(team);
//            em.persist(member);
//
//            team.addMember(member);
//
//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members = findTeam.getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getName());
//            }
//            OrderItem orderItem = new OrderItem();

//            Member member = new Member();
//
//            member.setName("hello");
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

//            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//            System.out.println("findMember.getName() = " + findMember.getId());

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Team teamB = new Team();
//            teamB.setName("teamB");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setName("member1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//
//            Member member2 = new Member();
//            member2.setName("member1");
//            member2.setTeam(team);
//
//            em.persist(member2);
//
//
//            em.flush();
//            em.clear();
//
////            Member m = em.find(Member.class, member2.getId());
//
//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
//                    .getResultList();

//            String qlString = "select m From Member m where m.username like '%kim'";
//            List<Member> result = em.createQuery(qlString
//                    , Member.class
//            ).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member);
//            }

//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//
//            Root<Member> m = query.from(Member.class);
//
//            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
//
//            List<Member> resultList = em.createQuery(cq)
//                    .getResultList();

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
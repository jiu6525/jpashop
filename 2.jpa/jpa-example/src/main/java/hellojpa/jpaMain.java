package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class jpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");
////            em.remove(findMember);    삭제
//            System.out.println(findMember.getName());
//            List<Member> result = em.createQuery("select m from Member as m" ,Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }

            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");


//            System.out.println("=== BEFORE ===");
            //영속
//            em.persist(member);
//            //준영속
////            em.detach(member);
//            System.out.println("=== AFTER ===");

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);

//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());


//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L,"B");
//            Member member = em.find(Member.class, 150L);
//            member.setName("aZZaZZa");
//            em.detach(member);

//            em.persist(member1);
//            em.persist(member2);

//            Member member = new Member();
//            member.setUsername("user1");
//            member.setCreateBy("kim");
//            member.setCreateDate(LocalDateTime.now());
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//
//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            em.remove(findParent);

//            Address address = new Address("city", "street", "10000");
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeaddress(address);
//            em.persist(member);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeaddress(address);
//            em.persist(member2);
//
//            member.getHomeaddress().setCity("newCity");

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeaddress(new Address("homeCity","street","10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

//            member.getAddressHistory().add(new Address("old1","street","10000"));
//            member.getAddressHistory().add(new Address("old2","street","10000"));

            member.getAddressHistory().add(new AddressEntity("old1","street","10000"));
            member.getAddressHistory().add(new AddressEntity("old1","street","10000"));
////

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("================START================");
            Member findMember = em.find(Member.class, member.getId());

//            List<Address> addressHistory = findMember.getAddressHistory();
//
//            for (Address address : addressHistory) {
//                System.out.println("address.getCity() = " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

//            findMember.getHomeaddress().setCity("newcity");
//            Address a = findMember.getHomeaddress();
//            findMember.setHomeaddress(new Address("newCity",a.getStreet(),a.getZipcode()));

//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");


//            findMember.getAddressHistory().remove(new Address("old1","street","10000"));
//            findMember.getAddressHistory().add(new Address("newCity1","street","10000"));


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}


//SELECT * FROM ITEM ;
//SELECT * FROM ALBUM ;
//SELECT * FROM BOOK  ;
//SELECT * FROM MOVIE  ;
package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

@Entity
//public class Member extends BaseEntity{
public class Member{

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    @Embedded
    private Address address;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn
//    private Team team;

//    public Locker getLocker() {
//        return locker;
//    }

//    public void setLocker(Locker locker) {
//        this.locker = locker;
//    }

//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }

    //    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //    @Column(name = "TEAM_ID")
//    private Long teamId;
//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;



    //    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}

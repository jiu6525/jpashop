package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
//@SequenceGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
//        initialValue = 1, allocationSize = 50)
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;


    //기간 Period
//    @Embedded
//    private Period workperiod;
//
//    //주소
    @Embedded
    private Address homeaddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
        @JoinColumn(name = "MEMBER_ID")
    )
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns =
//        @JoinColumn(name= "MEMBER_ID")
//    )
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    public Address getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(Address homeaddress) {
        this.homeaddress = homeaddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

//    public List<Address> getAddressHistory() {
//        return addressHistory;
//    }
//
//    public void setAddressHistory(List<Address> addressHistory) {
//        this.addressHistory = addressHistory;
//    }

    //    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city",
//                    column=@Column(name="WORK_CITY")),
//            @AttributeOverride(name = "street",
//                    column=@Column(name="WORK_STREET")),
//            @AttributeOverride(name = "zipcode",
//                    column=@Column(name="WORK_ZIPCODE"))
//    })
//    private Address workaddress;

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

//    public Period getWorkperiod() {
//        return workperiod;
//    }
//
//    public void setWorkperiod(Period workperiod) {
//        this.workperiod = workperiod;
//    }
//
//    public Address getHomeaddress() {
//        return homeaddress;
//    }
//
//    public void setHomeaddress(Address homeaddress) {
//        this.homeaddress = homeaddress;
//    }


    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }
}

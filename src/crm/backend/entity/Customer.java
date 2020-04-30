package crm.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "YH_CUSTOMER")
@Entity
public class Customer implements Serializable {
    @Id()
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CustomerCheckInfo> customerCheckInfoList;

    @Column(name = "NAME")
    private String name;
    @Column(name = "SEX")
    private String sex;
    @Column(name = "MOBILEPHONE")
    private String mobilephone;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "MEMBERSHIP_CARD")
    private String membershipCard; //会员卡号
    @Column(name = "HEALTH")
    private String health; //个人全身健康情况
    @Column(name = "INDIVIDUAL_EYE_HISTORY")
    private String individualEyeHistory; //个人眼病史

    @Column(name = "IS_HEREDITARY_OPHTHALMOPATHY")
    private String isHereditaryOphthalmopathy; //是否有家族遗传性眼病
    @Column(name = "IS_PARENTS_WEAR_GLASSES")
    private String isParentsWearGlasses; //父母是否戴镜

    @Column(name = "PROFESSION")
    private String  profession; //职业

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<CustomerCheckInfo> getCustomerCheckInfoList() {
        return customerCheckInfoList;
    }

    public void setCustomerCheckInfoList(List<CustomerCheckInfo> customerCheckInfoList) {
        this.customerCheckInfoList = customerCheckInfoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMembershipCard() {
        return membershipCard;
    }

    public void setMembershipCard(String membershipCard) {
        this.membershipCard = membershipCard;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getIndividualEyeHistory() {
        return individualEyeHistory;
    }

    public void setIndividualEyeHistory(String individualEyeHistory) {
        this.individualEyeHistory = individualEyeHistory;
    }

    public String getHereditaryOphthalmopathy() {
        return isHereditaryOphthalmopathy;
    }

    public void setHereditaryOphthalmopathy(String hereditaryOphthalmopathy) {
        isHereditaryOphthalmopathy = hereditaryOphthalmopathy;
    }

    public String getParentsWearGlasses() {
        return isParentsWearGlasses;
    }

    public void setParentsWearGlasses(String parentsWearGlasses) {
        isParentsWearGlasses = parentsWearGlasses;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}

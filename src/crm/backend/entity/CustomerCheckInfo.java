package crm.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "YH_CUSTOMER_CHECK_INFO")
@Entity
public class CustomerCheckInfo implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "CUSTOMER_CHECK_INFO_ID")
    private Long customerCheckInfoId;
    @Column(name = "AGE")
    private String age;
    @Column(name = "HEIGHT")
    private String height;
    @Column(name = "WIGHT")
    private String wight;
    @Column(name = "CHECK_DATE", nullable = false)
    private Date checkDate;

    @OneToMany(mappedBy = "customerCheckInfo",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<EyeCheckItem> eyeCheckItemList;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public Long getCustomerCheckInfoId() {
        return customerCheckInfoId;
    }

    public void setCustomerCheckInfoId(Long customerCheckInfoId) {
        this.customerCheckInfoId = customerCheckInfoId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWight() {
        return wight;
    }

    public void setWight(String wight) {
        this.wight = wight;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public List<EyeCheckItem> getEyeCheckItemList() {
        return eyeCheckItemList;
    }

    public void setEyeCheckItemList(List<EyeCheckItem> eyeCheckItemList) {
        this.eyeCheckItemList = eyeCheckItemList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

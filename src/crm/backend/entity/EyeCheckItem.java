package crm.backend.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "YH_EYE_CHECK_ITEM")
@Entity
public class EyeCheckItem implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "EYE_CHECK_ITEM_ID")
    private Long eyeCheckItemId;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_CHECK_INFO_ID")
    private CustomerCheckInfo customerCheckInfo;

    @Column(name = "EYE_TYPE", nullable = false)
    private String eyeType; //眼别
    @Column(name = "NAKED_VISION")
    private String nakedVision; //  裸眼视力
    @Column(name = "OLD_GLASS_DEGREE")
    private String oldGlassDegree; //  旧镜度数
    @Column(name = "OLD_GLASS_INTERPUPILLARY_DISTANCE")
    private String oldGlassInterpupillaryDistance; //  旧镜瞳距
    @Column(name = "OLD_GLASS_VISION")
    private String oldGlassVision; //  旧镜视力
    @Column(name = "PRESCRIPTION")
    private String prescription; //  最终处方
    @Column(name = "PRESCRIPTIVE_INTERPUPILLARY_DISTANCE")
    private String prescriptiveInterpupillaryDistance; //  处方瞳距
    @Column(name = "CORRECTED_VISION")
    private String correctedVision; //  矫正视力
    @Column(name = "EYE_SHAFT_LENGTH")
    private String eyeShaftLength; //  眼球轴长
    @Column(name = "CORNEAL_CURVATURE")
    private String cornealCurvature; //  角膜曲率
    @Column(name = "POSITION_OF_EYE")
    private String positionOfEye; //  眼位
    @Column(name = "STRESS_OF_EYE")
    private String stressOfEye; //眼压

    public Long getEyeCheckItemId() {
        return eyeCheckItemId;
    }

    public void setEyeCheckItemId(Long eyeCheckItemId) {
        this.eyeCheckItemId = eyeCheckItemId;
    }

    public CustomerCheckInfo getCustomerCheckInfo() {
        return customerCheckInfo;
    }

    public void setCustomerCheckInfo(CustomerCheckInfo customerCheckInfo) {
        this.customerCheckInfo = customerCheckInfo;
    }

    public String getEyeType() {
        return eyeType;
    }

    public void setEyeType(String eyeType) {
        this.eyeType = eyeType;
    }

    public String getNakedVision() {
        return nakedVision;
    }

    public void setNakedVision(String nakedVision) {
        this.nakedVision = nakedVision;
    }

    public String getOldGlassDegree() {
        return oldGlassDegree;
    }

    public void setOldGlassDegree(String oldGlassDegree) {
        this.oldGlassDegree = oldGlassDegree;
    }

    public String getOldGlassInterpupillaryDistance() {
        return oldGlassInterpupillaryDistance;
    }

    public void setOldGlassInterpupillaryDistance(String oldGlassInterpupillaryDistance) {
        this.oldGlassInterpupillaryDistance = oldGlassInterpupillaryDistance;
    }

    public String getOldGlassVision() {
        return oldGlassVision;
    }

    public void setOldGlassVision(String oldGlassVision) {
        this.oldGlassVision = oldGlassVision;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getPrescriptiveInterpupillaryDistance() {
        return prescriptiveInterpupillaryDistance;
    }

    public void setPrescriptiveInterpupillaryDistance(String prescriptiveInterpupillaryDistance) {
        this.prescriptiveInterpupillaryDistance = prescriptiveInterpupillaryDistance;
    }

    public String getCorrectedVision() {
        return correctedVision;
    }

    public void setCorrectedVision(String correctedVision) {
        this.correctedVision = correctedVision;
    }

    public String getEyeShaftLength() {
        return eyeShaftLength;
    }

    public void setEyeShaftLength(String eyeShaftLength) {
        this.eyeShaftLength = eyeShaftLength;
    }

    public String getCornealCurvature() {
        return cornealCurvature;
    }

    public void setCornealCurvature(String cornealCurvature) {
        this.cornealCurvature = cornealCurvature;
    }

    public String getPositionOfEye() {
        return positionOfEye;
    }

    public void setPositionOfEye(String positionOfEye) {
        this.positionOfEye = positionOfEye;
    }

    public String getStressOfEye() {
        return stressOfEye;
    }

    public void setStressOfEye(String stressOfEye) {
        this.stressOfEye = stressOfEye;
    }
}

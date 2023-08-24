package hikversion;

import lombok.Data;

/**
 * @author Cheng JiYe
 * @description: 员工岗位DTO
 * @date 2021/8/12 14:20
 */
@Data
public class BliuOaUserPostDto {
    private String UserPostOID;

    private String Organization_FK;

    private String Organization_Dept_FK;

    private String Post_FK;

    private String User_FK;

    private String IsMaster;

    private String IsVirtual;

    @Override
    public String toString() {
        return "BliuOaUserPostDto{" +
                "UserPostOID='" + UserPostOID + '\'' +
                ", Organization_FK='" + Organization_FK + '\'' +
                ", Organization_Dept_FK='" + Organization_Dept_FK + '\'' +
                ", Post_FK='" + Post_FK + '\'' +
                ", User_FK='" + User_FK + '\'' +
                ", IsMaster='" + IsMaster + '\'' +
                ", IsVirtual='" + IsVirtual + '\'' +
                '}';
    }
}

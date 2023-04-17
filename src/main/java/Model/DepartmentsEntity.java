package Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "departments", schema = "hr", catalog = "")
public class DepartmentsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "department_id", nullable = false)
    private int departmentId;
    @Basic
    @Column(name = "department_name", nullable = false, length = 30)
    private String departmentName;
    @Basic
    @Column(name = "location_id", nullable = true)
    private Integer locationId;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentsEntity that = (DepartmentsEntity) o;
        return departmentId == that.departmentId && Objects.equals(departmentName, that.departmentName) && Objects.equals(locationId, that.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, locationId);
    }

    @Override
    public String toString() {
        return "DepartmentsEntity [departmentId=" + departmentId + ", departmentName=" + departmentName
                + ", locationId=" + locationId + "]";
    }
    
}

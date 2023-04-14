package Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "countries", schema = "hr", catalog = "")
public class CountriesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id", nullable = false, length = 2)
    private String countryId;
    @Basic
    @Column(name = "country_name", nullable = true, length = 40)
    private String countryName;
    @Basic
    @Column(name = "region_id", nullable = false)
    private int regionId;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountriesEntity that = (CountriesEntity) o;
        return regionId == that.regionId && Objects.equals(countryId, that.countryId) && Objects.equals(countryName, that.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, countryName, regionId);
    }
}

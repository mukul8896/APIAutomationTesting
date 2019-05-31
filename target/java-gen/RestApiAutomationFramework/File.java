
package RestApiAutomationFramework;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * Employee
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "employeeName",
    "employeeId",
    "departmentName",
    "age"
})
public class File {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("employeeName")
    private String employeeName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("employeeId")
    private String employeeId;
    @JsonProperty("departmentName")
    private String departmentName;
    /**
     * Age in years
     * 
     */
    @JsonProperty("age")
    @JsonPropertyDescription("Age in years")
    private Integer age;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("employeeName")
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("employeeName")
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("employeeId")
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("employeeId")
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @JsonProperty("departmentName")
    public String getDepartmentName() {
        return departmentName;
    }

    @JsonProperty("departmentName")
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Age in years
     * 
     */
    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    /**
     * Age in years
     * 
     */
    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(employeeName).append(employeeId).append(departmentName).append(age).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof File) == false) {
            return false;
        }
        File rhs = ((File) other);
        return new EqualsBuilder().append(employeeName, rhs.employeeName).append(employeeId, rhs.employeeId).append(departmentName, rhs.departmentName).append(age, rhs.age).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

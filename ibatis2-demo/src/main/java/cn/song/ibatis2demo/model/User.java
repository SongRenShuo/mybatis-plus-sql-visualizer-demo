package cn.song.ibatis2demo.model;

import java.util.List;

/**
 * iBatis 2 的 JavaBean 参数对象。
 *
 * <p>动态标签的 property 判定（{@code <isNotNull>} / {@code <isNotEmpty>} / {@code <isEqual>} /
 * {@code <isGreaterThan>}）全部通过 iBatis 的 Probe 读这个 Bean 的 getter，
 * 所以这里必须有标准 getter/setter，属性名与 sqlmap/User.xml 的 property 严格对应。</p>
 */
public class User {

    private Integer id;
    private String username;
    private String email;
    private Integer age;
    private Integer status;
    private Integer deptId;
    /** {@code <iterate property="ids">} 的集合参数，占位符写作 #ids[]# */
    private List<String> ids;
    /** {@code $orderColumn$} 的字符串直替参数 */
    private String orderColumn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    @Override
    public String toString() {
        return "User{id=" + id
                + ", username=" + username
                + ", email=" + email
                + ", age=" + age
                + ", status=" + status
                + ", deptId=" + deptId
                + ", ids=" + ids
                + ", orderColumn=" + orderColumn
                + '}';
    }
}

package HibernateTasks.Entity;

import javax.persistence.*;
import java.sql.Date;

// POJO-class.
// Can use it via User.hbm.xml or via annotations
@Entity
@Table(name = "\"Users\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "username")
    private String username;
    @Column(name = "birthday_date")
    private Date birthdayDate;
    @Column(name = "age")
    private Integer age;
    @Column(name = "security_level")
    private Integer securityLevel;

    public User() { }

    public User(Integer userId, String username,
                Date birthdayDate, Integer age, Integer securityLevel) {
        this.userId = userId;
        this.username = username;
        this.birthdayDate = birthdayDate;
        this.age = age;
        this.securityLevel = securityLevel;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Integer securityLevel) {
        this.securityLevel = securityLevel;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", birthdayDate=" + birthdayDate +
                ", age=" + age +
                ", securityLevel=" + securityLevel +
                '}';
    }
}

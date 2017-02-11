package com.klevytska.rest_service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by katerynalevytska on 1/29/17.
 */

@XmlRootElement
@Entity
@Table(name="user")
public class User implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "nick_name")
    @NotNull
    protected String nick_name;

    @Column(name = "user_type")
    @NotNull
    private String userType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (nick_name != null ? !nick_name.equals(user.nick_name) : user.nick_name != null) return false;
        return userType != null ? userType.equals(user.userType) : user.userType == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nick_name != null ? nick_name.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nick_name='" + nick_name + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}

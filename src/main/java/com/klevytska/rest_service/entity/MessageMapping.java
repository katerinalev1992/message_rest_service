package com.klevytska.rest_service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by katerynalevytska on 1/29/17.
 */
@Entity
@XmlRootElement
@Table(name="messenger_map")
public class MessageMapping implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @JoinColumn(name = "to_id")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User to_id;

    @NotNull
    @JoinColumn(name = "from_id")
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User from_id;

    @NotNull
    @JoinColumn(name = "message_id")
    @ManyToOne(targetEntity = Message.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User message_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getTo_id() {
        return to_id;
    }

    public void setTo_id(User to_id) {
        this.to_id = to_id;
    }

    public User getFrom_id() {
        return from_id;
    }

    public void setFrom_id(User from_id) {
        this.from_id = from_id;
    }

    public User getMessage_id() {
        return message_id;
    }

    public void setMessage_id(User message_id) {
        this.message_id = message_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageMapping that = (MessageMapping) o;

        if (id != that.id) return false;
        if (to_id != null ? !to_id.equals(that.to_id) : that.to_id != null) return false;
        if (from_id != null ? !from_id.equals(that.from_id) : that.from_id != null) return false;
        return message_id != null ? message_id.equals(that.message_id) : that.message_id == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (to_id != null ? to_id.hashCode() : 0);
        result = 31 * result + (from_id != null ? from_id.hashCode() : 0);
        result = 31 * result + (message_id != null ? message_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MessageMapping{" +
                "id=" + id +
                ", to_id=" + to_id +
                ", from_id=" + from_id +
                ", message_id=" + message_id +
                '}';
    }
}

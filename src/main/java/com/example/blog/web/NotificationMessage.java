package com.example.blog.web;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author smustafov
 */
public class NotificationMessage implements Serializable {

    private NotificationType type;
    private String message;

    public NotificationMessage() {
    }

    public NotificationMessage(NotificationType type, String message) {
        this.type = type;
        this.message = message;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationMessage that = (NotificationMessage) o;
        return type == that.type &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, message);
    }
}

package com.example.blog.services;

import com.example.blog.models.NotificationMessage;
import com.example.blog.models.NotificationType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author smustafov
 */
@Service
@SessionScope
public class NotificationServiceImpl implements NotificationService, Serializable {

    private final List<NotificationMessage> notificationMessages = new ArrayList<>();

    @Override
    public void addInfoMessage(String message) {
        addNotificationMessage(NotificationType.INFO, message);
    }

    @Override
    public void addErrorMessage(String message) {
        addNotificationMessage(NotificationType.DANGER, message);
    }

    @Override
    public void addWarnMessage(String message) {
        addNotificationMessage(NotificationType.WARNING, message);
    }

    @Override
    public void addSuccessMessage(String message) {
        addNotificationMessage(NotificationType.SUCCESS, message);
    }

    @Override
    public void clearMessages() {
        notificationMessages.clear();
    }

    @Override
    public List<NotificationMessage> getMessages() {
        return Collections.unmodifiableList(notificationMessages);
    }

    private void addNotificationMessage(NotificationType type, String message) {
        if (!StringUtils.hasText(message)) {
            return;
        }

        notificationMessages.add(new NotificationMessage(type, message));
    }


}

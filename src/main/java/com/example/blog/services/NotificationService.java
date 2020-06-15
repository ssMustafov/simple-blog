package com.example.blog.services;

import com.example.blog.models.NotificationMessage;

import java.util.List;

/**
 * @author smustafov
 */
public interface NotificationService {

    void addInfoMessage(String message);

    void addErrorMessage(String message);

    void addWarnMessage(String message);

    void addSuccessMessage(String message);

    void clearMessages();

    List<NotificationMessage> getMessages();

}

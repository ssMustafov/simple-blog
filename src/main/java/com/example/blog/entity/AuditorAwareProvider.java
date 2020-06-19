package com.example.blog.entity;

import com.example.blog.models.User;
import com.example.blog.security.SecurityUtil;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author smustafov
 */
@Component
public class AuditorAwareProvider implements AuditorAware<String> {

    private static final String SYSTEM = "system";

    @Override
    public Optional<String> getCurrentAuditor() {
        return SecurityUtil.getAuthenticated()
                .map(User::getUsername)
                .or(() -> Optional.of(SYSTEM));
    }

}

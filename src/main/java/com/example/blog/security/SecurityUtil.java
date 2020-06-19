package com.example.blog.security;

import com.example.blog.models.UserSecureDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * @author smustafov
 */
public class SecurityUtil {

    private SecurityUtil() {
        // utility class
    }

    public static Optional<UserSecureDetails> getAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()
                && authentication.getPrincipal() instanceof UserSecureDetails) {
            UserSecureDetails userSecureDetails = (UserSecureDetails) authentication.getPrincipal();
            return Optional.of(userSecureDetails);
        }
        return Optional.empty();
    }

}

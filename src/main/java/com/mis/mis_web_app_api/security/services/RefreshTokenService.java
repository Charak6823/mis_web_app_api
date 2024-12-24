package com.mis.mis_web_app_api.security.services;

import com.mis.mis_web_app_api.exceptions.ApiException;
import com.mis.mis_web_app_api.models.RefreshToken;
import com.mis.mis_web_app_api.repositories.RefreshTokenRepository;
import com.mis.mis_web_app_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {
    @Value("${post.free.app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(Integer userId) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUser(userRepository.findById(userId).get());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token) throws ApiException {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new ApiException("Refresh token was expired. Please make a new sign in request");
        }

        return token;
    }

    @Transactional
    public void deleteByUserId(Integer userId) {
        refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
    }
}

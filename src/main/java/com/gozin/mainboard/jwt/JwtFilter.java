package com.gozin.mainboard.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gozin.mainboard.exception.dto.ApiExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <pre>
 * Class : JwtFilter
 * Comment:
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-01         이유리           최초 생성
 * </pre>
 *
 * @author 이유리
 * @version 1(클래스 버전)
 * @see
 */
public class JwtFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer";
    private final TokenProvider tokenProvider;

    public JwtFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = resolveToken(request);

            if(StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)){
                Authentication authentication = tokenProvider.getAuthentication(jwt);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        } catch (RuntimeException e){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            ApiExceptionDTO errorResponse = new ApiExceptionDTO(HttpStatus.UNAUTHORIZED, e.getMessage());

            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write(convertObjectToJson(errorResponse));
        }
    }

    private String convertObjectToJson(Object object) throws JsonProcessingException {
        if(object == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)){
            return bearerToken.substring(7);
        }
        return null;
    }
}

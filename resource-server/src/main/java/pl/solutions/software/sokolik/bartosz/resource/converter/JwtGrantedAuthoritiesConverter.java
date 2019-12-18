package pl.solutions.software.sokolik.bartosz.resource.converter;

import net.minidev.json.JSONArray;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.stream.Collectors;

public class JwtGrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    private static final String AUTHORITIES_KEY = "authorities";

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        JSONArray authorities = (JSONArray) jwt.getClaims().get(AUTHORITIES_KEY);
        return authorities.stream()
                .map(String.class::cast)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}

package pl.solutions.software.sokolik.bartosz.resource.configuration;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.nimbusds.jose.jwk.RSAKey;
import java.io.IOException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResuorceServerConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .oauth2ResourceServer()
        .jwt();
  }

  @Bean
  public JwtDecoder jwtDecoder() {
    return NimbusJwtDecoder.withPublicKey();
  }

  private String getPublicKeyAsString() {
    ClassPathResource resource = new ClassPathResource("public.txt");
    try {
      return IOUtils.toString(resource.getInputStream(), UTF_8);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice.learning.com.auth.security.user;

import java.util.Collection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservice.learning.com.core.model.Usuario;
import microservice.learning.com.core.repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author jader
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private UsuarioRepository usuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(String usuario) {
        log.info("Procurando usuario {}", usuario);
        Usuario user = usuarioRepository.findByUsuario(usuario);
        log.info("Ususario encontrado {}", user);
        
        if(user == null) {
            throw new UsernameNotFoundException(String.format("Usuario '%s' não encontrado", usuario));
        }
        return new CustomUserDetails(user);
    }
    
    private static final class CustomUserDetails extends Usuario implements UserDetails {

        public CustomUserDetails(Usuario usuario) {
            super(usuario);
        }
        
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_" + this.getRole());
        }

        @Override
        public String getPassword() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getUsername() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
        
    }
}

package com.Spring.controller;

import com.Spring.models.Usuario;
import com.Spring.services.EmailService;
import com.Spring.services.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    @Autowired
    private UsuarioService usuarioservice;

    @Autowired
    private EmailService emailService;

    @PostMapping("/auth/login")
    public Usuario login2(@RequestParam("user") String username, @RequestParam("password") String password) {
        List<Usuario> usuarios = usuarioservice.findAll();
        for (int i = 0; i < usuarios.size(); i++) {
            if (username.equals(usuarios.get(i).getUsuario()) && password.equals(usuarios.get(i).getPassword())) {
                String token = getJWTToken(username);
                usuarios.get(i).setToken(token);
                return usuarios.get(i);
            }
        }
        return null;
    }


    @PostMapping("/auth/register")
    public String register(@RequestParam("user") String username, @RequestParam("email") String email, @RequestParam("password") String password) throws IOException {
        Usuario usuario = new Usuario();
        usuario.setUsuario(username);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuarioservice.save(usuario);
        emailService.sendTextEmail(email, username);
        return "Realizado";
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // Token valido x 1 hora
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}

//package com.possenti.task.security;
//
//import com.possenti.task.entity.Perfil;
//import com.possenti.task.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.session.SessionRegistry;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.security.Principal;
//import java.util.Collection;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//
////    @RequestMapping(method = RequestMethod.GET)
////    public Principal user(Principal principal) {
////        return principal;
////    }
//
//
//    @RequestMapping(method = RequestMethod.POST)
//    public void save() {
//        Set<Perfil> perfils = new LinkedHashSet<>();
//        perfils.add(Perfil.ADMIN);
//        User user = new User(50L, "rafael_possenti@hotmail.com", "123", perfils);
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        PasswordEncoder encoder = (PasswordEncoder) context.getBean("passwordEncoder");
//        String encodedPassword = encoder.encode(password);
//        System.out.println("Encrypted password: " + encodedPassword);
//        JdbcUserDetailsManager jdbcUserMngr = (JdbcUserDetailsManager) context.getBean("jdbcUserDetailsManager");
//        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("Order View", "Order Create");
//        UserDetails userJoe = new User(username, encodedPassword, authorities);
//        jdbcUserMngr.createUser(userJoe);
//
//
//        jdbcUserDetailsManager.createUser(user);
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public void get() {
//        jdbcUserDetailsManager.userExists("rafael_possenti@hotmail.com");
//    }
//
//}

package com.letsplan;

import com.letsplan.config.CustomUserDetails;
import com.letsplan.entities.Role;
import com.letsplan.entities.Utilisateur;
import com.letsplan.repositories.UtilisateurRepository;
import com.letsplan.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class BlogApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	/**
	 * Password grants are switched on by injecting an AuthenticationManager.
	 * Here, we setup the builder so that the userDetailsService is the one we coded.
	 * @param builder
	 * @param repository
	 * @throws Exception
	 */
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UtilisateurRepository repository, UtilisateurService utilisateurService) throws Exception {
		if (repository.count()==0) {
			utilisateurService.save(new Utilisateur("admin", "adminPassword", Arrays.asList(new Role("USER"), new Role("ACTUATOR") , new Role("ADMIN")),"adminNom", "adminPrenom", "adminMail"));
		}
		builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
	}

	/**
	 * We return an istance of our CustomUserDetails.
	 * @param repository
	 * @return
	 */
	private UserDetailsService userDetailsService(final UtilisateurRepository repository) {
		return username -> new CustomUserDetails(repository.findByUsername(username));
	}
}

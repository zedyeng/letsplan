package com.letsplan.controllers;

import com.letsplan.config.CustomUserDetails;
import com.letsplan.entities.Evenement;
import com.letsplan.entities.Lieu;
import com.letsplan.pojos.EvenementCreation;
import com.letsplan.pojos.UserRegistration;
import com.letsplan.service.EvenementService;
import com.letsplan.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

	@Autowired
	private EvenementService evenementService;

	@Autowired
	private UtilisateurService userService;

//    @Autowired
//    private CommentService commentService;

	@GetMapping(value = "/posts")
	public List<Evenement> evenements() {
		return evenementService.getAllEvenement();
	}

	@GetMapping(value = "/the_post/{id}")
	public Optional<Evenement> getPostById(@PathVariable Long id) {
		return evenementService.getEvenement(id);
	}

	@PostMapping(value = "/post")
	public String publishPost(@RequestBody Evenement evenement) {
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		if (evenement.getDateCreated() == null)
			evenement.setDateCreated(new Date());
		evenement.setUtilisateurAdmin(userService.getUser(userDetails.getUsername()));
		evenementService.insert(evenement);
		return "Post was published";
	}

	@GetMapping(value = "/posts/{username}")
	public List<Evenement> evenementByUser(@PathVariable String username) {
		return evenementService.findByUser(userService.getUser(username));
	}

	@DeleteMapping(value = "/post/{id}")
	public boolean deleteEvenement(@PathVariable Long id) {
		return evenementService.deleteEvenement(id);
	}

	@PostMapping(value = "/evenement")
	public String creationEvenement(@RequestBody EvenementCreation evenementCreation) {
		System.out.println("laaaaaaaa");
		System.out.println(evenementCreation.getLoginsInvite());
		String tableau[] = evenementCreation.getLoginsInvite().split(",");
		System.out.println("ca bugggg");

		Evenement evenement = new Evenement();
		for (String username : tableau) {
			if (userService.getUser(username) == null) {
				return "Un ou plusieurs utilisateurs non trouvé";
			}else {
				System.out.println(userService.getUser(username).getNom());
				evenement.getMapInvité().put(userService.getUser(username), false);
				
			}
		}
		
		evenement.setLieu(new Lieu(evenementCreation.getLibelleLieu(), evenementCreation.getNumRue(), evenementCreation.getNomRue(), evenementCreation.getNomVille(), evenementCreation.getDepartement()));
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		evenement.setUtilisateurAdmin(userService.getUser(userDetails.getUsername()));
		evenement.setDateCreated(evenementCreation.getDate());

		
		evenementService.insert(evenement);
		
		return "Evenement created";
	}

//    @DeleteMapping(value = "/comment/{id}")
//    public boolean deleteComment(@PathVariable Long id){
//        return commentService.deletePost(id);
//    }

//    @GetMapping(value = "/comments/{postId}")
//    public List<Lieu> getComments(@PathVariable Long postId){
//        return commentService.getComments(postId);
//    }

//    @PostMapping(value = "/post/postComment")
//    public boolean postComment(@RequestBody CommentPojo comment){
//        Optional<Post> post = postService.find(comment.getPostId());
//        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User creator = userService.getUser(userDetails.getUsername());
//        if(post == null || creator == null)
//            return false;
//
//        commentService.comment(new Comment(comment.getText(),post,creator));
//        return true;
//    }

}

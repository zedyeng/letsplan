//package com.letsplan.service;
//
//import com.letsplan.entities.Lieu;
//import com.letsplan.pojos.CommentPojo;
//import com.letsplan.repositories.CommentRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CommentService {
//
//    @Autowired
//    private CommentRepository commentRepository;
//
//    public List<Lieu> getComments(Long postId) {
//        return commentRepository.findByPostId(postId);
//    }
//
//    public void comment(Lieu comment) {
//        commentRepository.save(comment);
//    }
//
//    public boolean deletePost(Long id) {
//        commentRepository.deleteById(id);
//        return true;
//    }
//}

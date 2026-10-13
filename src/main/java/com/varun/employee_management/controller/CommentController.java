package com.varun.employee_management.controller;

import com.varun.employee_management.entity.Comment;
import com.varun.employee_management.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Create comment
    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    // Get all comments
    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    // Get comment by ID
    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id).orElse(null);
    }

    // Update comment
    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id,
                                 @RequestBody Comment comment) {
        return commentService.updateComment(id, comment);
    }

    // Delete comment
    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return "Comment deleted successfully";
    }
}
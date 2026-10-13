package com.varun.employee_management.service;

import com.varun.employee_management.entity.Comment;
import com.varun.employee_management.entity.Task;
import com.varun.employee_management.entity.User;
import com.varun.employee_management.repository.CommentRepository;
import com.varun.employee_management.repository.TaskRepository;
import com.varun.employee_management.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository,
                          TaskRepository taskRepository,
                          UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    // Create comment
    public Comment createComment(Comment comment) {

        if (comment.getTask() == null ||
                comment.getTask().getId() == null ||
                comment.getUser() == null ||
                comment.getUser().getId() == null) {
            return null;
        }

        Long taskId = comment.getTask().getId();
        Long userId = comment.getUser().getId();

        Task task = taskRepository.findById(taskId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (task == null || user == null) {
            return null;
        }

        comment.setTask(task);
        comment.setUser(user);

        return commentRepository.save(comment);
    }

    // Get all comments
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    // Get comment by ID
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    // Update comment
    public Comment updateComment(Long id, Comment updatedComment) {

        Comment existingComment =
                commentRepository.findById(id).orElse(null);

        if (existingComment == null) {
            return null;
        }

        existingComment.setComment(updatedComment.getComment());

        // Update task only if provided
        if (updatedComment.getTask() != null &&
                updatedComment.getTask().getId() != null) {

            Task task = taskRepository
                    .findById(updatedComment.getTask().getId())
                    .orElse(null);

            if (task != null) {
                existingComment.setTask(task);
            }
        }

        // Update user only if provided
        if (updatedComment.getUser() != null &&
                updatedComment.getUser().getId() != null) {

            User user = userRepository
                    .findById(updatedComment.getUser().getId())
                    .orElse(null);

            if (user != null) {
                existingComment.setUser(user);
            }
        }

        return commentRepository.save(existingComment);
    }

    // Delete comment
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
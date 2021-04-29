package com.example.redesocial.controller;

import com.example.redesocial.dto.CommentDto;
import com.example.redesocial.entity.Comment;
import com.example.redesocial.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;

    @GetMapping
    @Transactional
    public ResponseEntity<CommentDto> getAll() {
        Optional<Comment> comment = commentRepository.findById(2L);
        CommentDto commentDto = CommentDto.parseDto(comment.get());
        return ResponseEntity.ok(commentDto);
    }
}

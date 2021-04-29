package com.example.redesocial.dto;


import com.example.redesocial.entity.Publication;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommentDto {

    private Long id;

    private String uuid;

    private String message;

    private Publication publication;

    // todo relacionamento com comment one to one
    private List<CommentDto> comments;

//    public static CommentDto parseDto(Comment comment) {
//        return CommentDto.builder()
//                .id(comment.getId())
//                .uuid(comment.getUuid())
//                .message(comment.getMessage())
////                .publication(comment.get().getPublication())
//                .comments(comment.getComments().stream().map(CommentDto::parseDto).collect(Collectors.toList()))
//                .build();
//    }
}

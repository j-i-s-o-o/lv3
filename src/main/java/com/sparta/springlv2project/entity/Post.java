package com.sparta.springlv2project.entity;

import com.sparta.springlv2project.dto.boardDto.PostRequestDto;
import io.jsonwebtoken.Claims;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "post")
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String contents;

    @OneToMany(mappedBy = "post")
    private List<Comment> comment = new ArrayList<>();

    public Post(PostRequestDto postRequestDto, Claims userInfo) {
        this.username = userInfo.getSubject();
        this.subject = postRequestDto.getSubject();
        this.contents = postRequestDto.getContents();
    }

}

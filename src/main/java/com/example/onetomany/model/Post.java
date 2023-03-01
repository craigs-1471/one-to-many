package com.example.onetomany.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    private Long id;
    private String title;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="post_comm_fid", referencedColumnName = "post_id")
    List<Comment> comments = new ArrayList<>();

    public Post(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }
}

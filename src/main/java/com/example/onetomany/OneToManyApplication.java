package com.example.onetomany;

import com.example.onetomany.model.Comment;
import com.example.onetomany.model.Post;
import com.example.onetomany.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToManyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OneToManyApplication.class, args);
    }

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        Post post = new Post("Title 1", "Description 1");
        Comment comment = new Comment("Comment 1");
        Comment comment1 = new Comment("Comment 2");
        Comment comment2 = new Comment("Comment 3");

        post.getComments().add(comment);
        post.getComments().add(comment1);
        post.getComments().add(comment2);

        postRepository.save(post);
    }
}

package kz.dar.academy.postofficeapi.controller;

import kz.dar.academy.postofficeapi.feign.ClientFeign;
import kz.dar.academy.postofficeapi.feign.PostFeign;
import kz.dar.academy.postofficeapi.model.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post-api")
public class PostController {
    @Autowired
    PostFeign postFeign;

    @Autowired
    ClientFeign clientFeign;

    @GetMapping("/check")
    public String checkPost() {
        return "post-core-api is working";
    }

    @GetMapping("/post/check")
    public String checkPostOffice() {
        return postFeign.checkPostOffice();
    }

    @GetMapping("/post/all")
    public List<PostResponse> getAllPosts() {
        return postFeign.getAllPosts();
    }

    @GetMapping("/post/{postId}")
    public PostResponse getPostById(@PathVariable String postId) {
        return postFeign.getPostById(postId);
    }

    public PostResponse getPostDetails(PostResponse post, String clientId, String receiver) {
        post.setClient(clientFeign.getClientById(clientId));
        post.setReceiver(clientFeign.getClientById(receiver));
        return post;
    }
}

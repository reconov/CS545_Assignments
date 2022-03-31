package com.spring.assignmentOne.repo;

import com.spring.assignmentOne.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo{

    private static List<Post> postList;

    static {
        postList = new ArrayList<>();
        Post p1 = new Post(1, "Some post goes here", "blah blah", "Mr. x");
        Post p2 = new Post(2, "Another post here", "blah blah", "Mr. y");
        Post p3 = new Post(3, "My hands are still typing", "blah blah", "Mr. z");
        Post p4 = new Post(4, "Man, got to go and sllllpp", "blah blah", "Mr. a");

        postList.addAll(Arrays.asList(p1, p2, p3, p4));
    }

    @Override
    public List<Post> getAll(){
        System.out.println(postList);
        return postList;
    }

    @Override
    public Post getById(int id){
        return postList.stream()
                .filter(eachPost -> eachPost.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean save(Post p){
        return postList.add(p);
    }

    @Override
    public void delete(int id){
        List<Post> temp = postList;
        postList = temp.stream()
                .filter(eachPost -> eachPost.getId() != id)
                .collect(Collectors.toList());
    }

    @Override
    public void update(int id, Post p) {
        int index = postList.indexOf(postList.stream().filter(eachP -> eachP.getId() == id).findFirst().orElse(null));
        postList.set(index, p);
    }
}
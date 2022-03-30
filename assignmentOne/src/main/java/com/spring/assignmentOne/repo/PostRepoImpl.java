package com.spring.assignmentOne.repo;

import com.spring.assignmentOne.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo{

    private static List<Post> postList;

    static {
        postList = new ArrayList<>();
        Post p1 = new Post(123214, "Some post goes here", "blah blah", "Mr. x");
        Post p2 = new Post(234234, "Another post here", "blah blah", "Mr. y");
        Post p3 = new Post(323453, "My hands are still typing", "blah blah", "Mr. z");
        Post p4 = new Post(674567, "Man, got to go and sllllpp", "blah blah", "Mr. a");

        postList.addAll(Arrays.asList(p1, p2, p3, p4));
    }

    @Override
    public List<Post> getAll(){
        System.out.println("The output list is : \n");
        System.out.println(postList);
        return postList;
    }
}


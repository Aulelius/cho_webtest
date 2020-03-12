package com.chowebtest.admin.web.domain.posts;


import com.chowebtest.admin.domain.posts.Posts;
import com.chowebtest.admin.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

@Autowired
    PostsRepository postsRepository;

@After // Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정한다. 보통 베포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용한다.
    public void cleanup() {
    postsRepository.deleteAll();
}

@Test
    public void 게시글저장_불러오기() {
    // given
    String title = "테스트게시글";
    String content = "테스트본문";

    postsRepository.save(Posts.builder() // 테이블 posts에 insert/update 쿼리를 실행한다. id값이 없다면 insert 쿼리, id값이 있다면 update 쿼리 실행
    .title(title)
    .content(content)
    .author("drcho90@gmail.com")
    .build());

    // when
    List<Posts> postsList = postsRepository.findAll(); // 테이블 posts에 있는 모든 데이터를 조회해오는 메소드이다.

    // then
    Posts posts = postsList.get(0);
    assertThat(posts.getTitle()).isEqualTo(title);
    assertThat(posts.getContent()).isEqualTo(content);

}

}

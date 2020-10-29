package com.kdk;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.kdk.domain.Member;
import com.kdk.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

  @Autowired
  private MemberRepository repository;

  @Before
  public void cleanUp() throws Exception {
    repository.deleteAll();

    repository.save(new Member("kdk01", "123"));
    repository.save(new Member("kdk02", "123"));
    repository.save(new Member("kdk03", "123"));
    repository.save(new Member("kdk04", "123"));
    repository.save(new Member("kdk05", "123"));
  }

  @Test
  public void selectMemberListTest() throws Exception {
    List<Member> personList = repository.findAll();
    assertThat(personList.size()).isEqualTo(5);
}
}

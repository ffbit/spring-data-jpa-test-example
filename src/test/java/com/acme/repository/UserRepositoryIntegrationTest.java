package com.acme.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.acme.domain.User;
import com.acme.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:repository-context.xml")
@Transactional
public class UserRepositoryIntegrationTest {
    
    @Autowired
    UserRepository userRepository;
    
    @Test
    public void sampleTestCase() {
      User dave = new User("Dave", "Matthews");
      userRepository.save(dave);

      User carter = new User("Carter", "Beauford");
      userRepository.save(carter);

      List<User> result = userRepository.findByLastname("Matthews");
      
      assertThat(result.size(), is(1));
      assertThat(result, hasItem(dave));
    }

}

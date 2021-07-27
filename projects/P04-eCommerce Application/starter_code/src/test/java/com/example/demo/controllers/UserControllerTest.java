package com.example.demo.controllers;
// @author asmaa **


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.demo.TestUtils;
import com.example.demo.model.persistence.User;
import com.example.demo.model.persistence.repositories.CartRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import com.example.demo.model.requests.CreateUserRequest;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserControllerTest {
  private UserController userController;
  private UserRepository userRepo =  mock(UserRepository.class);
  private CartRepository cartRepo = mock(CartRepository.class);
  private BCryptPasswordEncoder encoder = mock(BCryptPasswordEncoder.class);

  @Before
  public void setup(){
    userController = new UserController();
    TestUtils.injectObject(userController, "userRepository", userRepo);
    TestUtils.injectObject(userController, "cartRepository", cartRepo);
    TestUtils.injectObject(userController, "bCryptPasswordEncoder", encoder);
  }

  @Test
  public void createUserTest() throws Exception {
    when(encoder.encode("12345678")).thenReturn("HashedAndReady");
    CreateUserRequest req = new CreateUserRequest();
    req.setUsername("asmaa");
    req.setPassword("12345678");
    req.setConfirmPassword("12345678");
    ResponseEntity<User> response = userController.createUser(req);
    assertNotNull(response);
    assertEquals(200, response.getStatusCodeValue());
    User user = response.getBody();
    assertNotNull(user);
    assertEquals(0,user.getId());
    assertEquals("asmaa",user.getUsername());
  }

  @Test
  public void createTwoUsers() throws Exception {
    CreateUserRequest req = new CreateUserRequest();
    CreateUserRequest req1 = new CreateUserRequest();
    req.setUsername("asmaa");
    req.setPassword("12345678");
    req.setConfirmPassword("12345678");
    req1.setUsername("asigh");
    req1.setPassword("asdfghjkl");
    req1.setConfirmPassword("asdfghjkl");
    ResponseEntity<User> response = userController.createUser(req);
    ResponseEntity<User> response1 = userController.createUser(req1);
    assertNotNull(response);
    assertNotNull(response1);
    User user = response.getBody();
    User user1 = response1.getBody();
    assertNotEquals(user.getUsername(),user1.getUsername());
  }

  @Test
  public void findByUserNameTest() throws Exception{
    when(encoder.encode("12345678")).thenReturn("HashedAndReady");
    CreateUserRequest req = new CreateUserRequest();
    req.setUsername("asmaa");
    req.setPassword("12345678");
    req.setConfirmPassword("12345678");
    ResponseEntity<User> response = userController.createUser(req);
    assertNotNull(response);
    User user = response.getBody();

    //test if user exist
    when(userRepo.findByUsername(user.getUsername())).thenReturn(user);
    ResponseEntity<User> response1 = userController.findByUserName(user.getUsername());
    assertNotNull(response1);
    User user1 = response1.getBody();
    assertEquals("asmaa", user1.getUsername());
  }

  @Test
  public void findByIdTest() throws Exception{
    when(encoder.encode("asdfghkk")).thenReturn("HashedAndReady");
    CreateUserRequest req = new CreateUserRequest();
    req.setUsername("asigh");
    req.setPassword("asdfghkk");
    req.setConfirmPassword("asdfghkk");
    ResponseEntity<User> response = userController.createUser(req);
    assertNotNull(response);
    User user = response.getBody();

    //test if user exist
    when(userRepo.findById(user.getId())).thenReturn(Optional.of(user));
    ResponseEntity<User> response1 = userController.findById(user.getId());
    assertNotNull(response1);
    User user1 = response1.getBody();
    assertEquals(0, user1.getId());
  }
}

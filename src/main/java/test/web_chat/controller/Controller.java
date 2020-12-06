package test.web_chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import test.web_chat.entity.MessageEntity;
import test.web_chat.entity.UserEntity;
import test.web_chat.services.MessageService;
import test.web_chat.services.UserService;

import java.util.List;

@RestController
@CrossOrigin
public class Controller
{
  @Autowired
  MessageService messageService;

  @Autowired
  UserService userService;

  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;

  @MessageMapping("/chat/{to}")
  public void sendMassage(@DestinationVariable String to, MessageEntity message)
  {
    System.out.println("handling send message: " + message.getContent() + " to " + to);
    boolean isExists = userService.getUser(to) != null;
    if(isExists)
    {
      simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message.getContent());
    }
  };

  @GetMapping("/registration/{userName}")
  public ResponseEntity<Void> register(@PathVariable String userName)
  {
    try
    {
      UserEntity newUser = UserEntity.builder().nickName(userName).enabled(true).build();
      userService.saveUser(newUser);
    }
    catch(Exception e)
    {
      ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok().build();
  }

  @GetMapping("/fetchAllUsers")
  public List<UserEntity> fetchAllActiveUsers()
  {
    return userService.getUsers();
  }
}

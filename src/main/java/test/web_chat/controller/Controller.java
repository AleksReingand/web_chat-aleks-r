package test.web_chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    System.out.println("handling send message: " + message + " to " + to);
    boolean isExists = userService.getUser() != null;
    if(isExists)
    {
      simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
    }
  };

  @GetMapping("/registration/{userName}")
  public List<MessageEntity> register(@PathVariable String userName)
  {
    return messageService.getMessageList();
  }

  @GetMapping("/fetchAllUsers")
  public List<UserEntity> fetchAllActiveUsers()
  {
    return userService.getUsers();
  }
}

package test.web_chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.web_chat.entity.MessageEntity;
import test.web_chat.repo.MessageJpa;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService
{
  @Autowired
  MessageJpa messageJpa;

  @Override
  public List<MessageEntity> getMessages()
  {
    return messageJpa.findAll();
  }
}

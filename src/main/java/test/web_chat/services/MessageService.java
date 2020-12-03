package test.web_chat.services;

import test.web_chat.entity.MessageEntity;

import java.util.List;

public interface MessageService
{
  List<MessageEntity> getMessageList();

}

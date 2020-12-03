package test.web_chat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import test.web_chat.entity.MessageEntity;

import java.util.List;

public interface MessageJpa extends JpaRepository<MessageEntity, Integer>
{
  List<MessageEntity> findAllByNickName();
}

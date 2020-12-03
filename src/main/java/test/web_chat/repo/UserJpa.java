package test.web_chat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import test.web_chat.entity.UserEntity;

import java.util.List;

public interface UserJpa extends JpaRepository<UserEntity, Integer>
{
  List<UserEntity> findAllByEnabledIsTrue();
  UserEntity findByNickName();
}

package test.web_chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.web_chat.entity.UserEntity;
import test.web_chat.repo.UserJpa;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
  @Autowired
  UserJpa userJpa;

  @Override
  public List<UserEntity> getUsers()
  {
    return userJpa.findAllByEnabledIsTrue();
  }

  @Override
  public UserEntity getUser(String name)
  {
    return userJpa.findByNickName(name);
  }

  @Override
  public void saveUser(UserEntity user)
  {
    userJpa.save(user);
  }
}

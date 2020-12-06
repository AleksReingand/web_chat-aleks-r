package test.web_chat.services;

import test.web_chat.entity.UserEntity;

import java.util.List;

public interface UserService
{
  List<UserEntity> getUsers();
  UserEntity getUser(String name);
  void saveUser(UserEntity user);
}

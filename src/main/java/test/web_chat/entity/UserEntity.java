package test.web_chat.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Table(name = "users", schema = "public", catalog = "ddm8g1tsouo1g4")
public class UserEntity
{
  private int userId;
  private String nickName;
  private Boolean enabled;
  private Collection<MessageEntity> messagesByUserId;

  @Id
  @Column(name = "user_id")
  public int getUserId()
  {
    return userId;
  }

  public void setUserId(int userId)
  {
    this.userId = userId;
  }

  @Basic
  @Column(name = "nick_name")
  public String getNickName()
  {
    return nickName;
  }

  public void setNickName(String nickName)
  {
    this.nickName = nickName;
  }

  @Basic
  @Column(name = "enabled")
  public Boolean getEnabled()
  {
    return enabled;
  }

  public void setEnabled(Boolean enabled)
  {
    this.enabled = enabled;
  }

  @Override
  public boolean equals(Object o)
  {
    if(this == o)
      return true;
    if(o == null || getClass() != o.getClass())
      return false;

    UserEntity that = (UserEntity) o;

    if(userId != that.userId)
      return false;
    if(nickName != null ? !nickName.equals(that.nickName) : that.nickName != null)
      return false;
    if(enabled != null ? !enabled.equals(that.enabled) : that.enabled != null)
      return false;

    return true;
  }

  @Override
  public int hashCode()
  {
    int result = userId;
    result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
    result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
    return result;
  }

  @OneToMany(mappedBy = "usersByUserId")
  public Collection<MessageEntity> getMessagesByUserId()
  {
    return messagesByUserId;
  }

  public void setMessagesByUserId(Collection<MessageEntity> messagesByUserId)
  {
    this.messagesByUserId = messagesByUserId;
  }
}

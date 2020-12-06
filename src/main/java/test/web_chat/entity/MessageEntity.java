package test.web_chat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "messages", schema = "public", catalog = "ddm8g1tsouo1g4")
public class MessageEntity
{
  private String content;
  private Timestamp creationTime;
  private int messageId;
  private UserEntity usersByUserId;

  @Basic
  @Column(name = "content")
  public String getContent()
  {
    return content;
  }

  public void setContent(String content)
  {
    this.content = content;
  }

  @Basic
  @Column(name = "creation_time")
  public Timestamp getCreationTime()
  {
    return creationTime;
  }

  public void setCreationTime(Timestamp creationTime)
  {
    this.creationTime = creationTime;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "message_id")
  public int getMessageId()
  {
    return messageId;
  }

  public void setMessageId(int messageId)
  {
    this.messageId = messageId;
  }

  @Override
  public boolean equals(Object o)
  {
    if(this == o)
      return true;
    if(o == null || getClass() != o.getClass())
      return false;

    MessageEntity that = (MessageEntity) o;

    if(messageId != that.messageId)
      return false;
    if(content != null ? !content.equals(that.content) : that.content != null)
      return false;
    if(creationTime != null ? !creationTime.equals(that.creationTime) : that.creationTime != null)
      return false;

    return true;
  }

  @Override
  public int hashCode()
  {
    int result = content != null ? content.hashCode() : 0;
    result = 31 * result + (creationTime != null ? creationTime.hashCode() : 0);
    result = 31 * result + messageId;
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, table = "messages")
  public UserEntity getUsersByUserId()
  {
    return usersByUserId;
  }

  public void setUsersByUserId(UserEntity usersByUserId)
  {
    this.usersByUserId = usersByUserId;
  }
}

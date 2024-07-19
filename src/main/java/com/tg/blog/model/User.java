package com.tg.blog.model;

import java.util.Date;


/**
 * 
 * 
 * 
 **/
public class User{


  /****/

  private Long userId;


  /****/

  private String username;


  /****/

  private String password;


  /****/

  private String email;


  /****/

  private Date created;


  /****/

  private Date lastModified;




  public void setUserId(Long userId) { 
    this.userId = userId;
  }


  public Long getUserId() { 
    return this.userId;
  }


  public void setUsername(String username) { 
    this.username = username;
  }


  public String getUsername() { 
    return this.username;
  }


  public void setPassword(String password) { 
    this.password = password;
  }


  public String getPassword() { 
    return this.password;
  }


  public void setEmail(String email) { 
    this.email = email;
  }


  public String getEmail() { 
    return this.email;
  }


  public void setCreated(Date created) { 
    this.created = created;
  }


  public Date getCreated() { 
    return this.created;
  }


  public void setLastModified(Date lastModified) { 
    this.lastModified = lastModified;
  }


  public Date getLastModified() { 
    return this.lastModified;
  }

  @Override
  public String toString() {
    return "User{" +
            "userId=" + userId +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", created=" + created +
            ", lastModified=" + lastModified +
            '}';
  }
}

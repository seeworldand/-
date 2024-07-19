package com.tg.blog.model;

import java.util.Date;


/**
 * 
 * 
 * 
 **/
public class Message{


  /****/

  private Long postId;


  /****/

  private String title;


  /****/

  private String content;


  /****/

  private Long userId;


  /****/

  private Date created;


  /****/

  private Date lastModified;




  public void setPostId(Long postId) {     this.postId = postId;
  }


  public Long getPostId() {     return this.postId;
  }


  public void setTitle(String title) {     this.title = title;
  }


  public String getTitle() {     return this.title;
  }


  public void setContent(String content) {     this.content = content;
  }


  public String getContent() {     return this.content;
  }


  public void setUserId(Long userId) {     this.userId = userId;
  }


  public Long getUserId() {     return this.userId;
  }


  public void setCreated(Date created) {     this.created = created;
  }


  public Date getCreated() {     return this.created;
  }


  public void setLastModified(Date lastModified) {     this.lastModified = lastModified;
  }


  public Date getLastModified() {     return this.lastModified;
  }

}

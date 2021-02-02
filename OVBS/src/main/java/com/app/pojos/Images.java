//package com.app.pojos;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="images")
//public class Images {
//	 @Id
//	    @Column(name = "id")
//	    private Long id;
//	  
//	    @Column(name = "name")
//	  private String name;
//
//	  @Lob
//	    @Column(name="pic")
//	    private byte[] pic;
//	  
//	  public Images(){}
//	  
//	  public Images(long id, String name, byte[] pic){
//	    this.id = id;
//	    this.name = name;
//
//	    this.pic = pic;
//	  }
//	  
//	  public Long getId(){
//	    return this.id;
//	  }
//	  
//	  public void setId(Long id){
//	    this.id = id;
//	  }
//	  
//	  public String getName(){
//	    return this.name;
//	  }
//	  
//	  public void setName(String name){
//	    this.name = name;
//	  }
//	  
//	  public byte[] getPic(){
//	    return this.pic;
//	  }
//	  
//	  public void setPic(byte[] pic){
//	    this.pic = pic;
//	  }
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.dto;

import java.util.List;

/**
 *
 * @author ASUS-PC
 */
public abstract class AbstractFacadePage<T> {
      
    private List<T> content;
   
    private Integer totalElements;

    public AbstractFacadePage() {
    }

    public AbstractFacadePage(List<T> content, Integer totalElements) {
        this.content = content;
        this.totalElements = totalElements;
    }
    

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

  
    
    
}

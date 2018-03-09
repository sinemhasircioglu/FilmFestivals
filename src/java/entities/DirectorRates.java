/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author sinem
 */
public class DirectorRates {
  private int id;
  private int juryid;
  private int directorid;
  private int rate ;

    public DirectorRates() {
    }
  

    public DirectorRates(int id, int juryid, int directorid,int rate) {
        this.id = id;
        this.juryid = juryid;
        this.directorid = directorid;
        this.rate = rate;
         }
 public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getJuryid() {
        return juryid;
    }

    public void setJuryid(int id) {
        this.juryid = juryid;
    }
    public int getDirectorid() {
        return directorid;
    }

    public void setDirectorid(int directorid) {
        this.directorid = directorid;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

   
     
    @Override
    public String toString() {
        return "DirectorRates{" + "id=" + id + ", juryid=" + juryid + ", directorid=" + directorid + ", rate=" + rate + '}';
    }
}

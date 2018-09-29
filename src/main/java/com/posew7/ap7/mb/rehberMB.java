package com.posew7.ap7.mb;

import com.posew7.ap7.entity.Rehber;
import com.posew7.ap7.sesion.RehberFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "rehberMB")
@SessionScoped
public class rehberMB implements Serializable {

    @EJB
    private RehberFacade rehberFacade;

    private String ad;
    private String tel;
    private String bilgi;
    
    private List<Rehber> kisiListesi;
            
            
    public rehberMB() {
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBilgi() {
        return bilgi;
    }

    public void setBilgi(String bilgi) {
        this.bilgi = bilgi;
    }

    public String ekle() {

        Rehber r = new Rehber();

        r.setAd(ad);
        r.setBilgi(bilgi);
        r.setTel(tel);

        rehberFacade.create(r);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("BAŞARILI", ad + " adlı kişi kayıt edildi"));

        temizle();

        return "";
    }

    public String temizle() {

        ad = "";
        bilgi = "";
        tel = "";

        return "";
    }

    public String getir() {

        Rehber r = rehberFacade.find(ad);

        this.ad = r.getAd();
        this.tel = r.getTel();
        this.bilgi = r.getBilgi();

        return "";
    }

    public String guncelle() {

        Rehber r = new Rehber();

        r.setAd(ad);
        r.setBilgi(bilgi);
        r.setTel(tel);

        rehberFacade.edit(r);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("BAŞARILI", ad + " isimli kişi güncellendi"));
        temizle();
        return "";
    }

    public String sil() {
        Rehber r = new Rehber();

        r.setAd(ad);
        r.setBilgi(bilgi);
        r.setTel(tel);

        rehberFacade.remove(r);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("BAŞARILI", ad + " kişi silindi"));

        temizle();

        return "";
    }
    
    public List<Rehber> listele(){
        if (kisiListesi == null) {
            kisiListesi = rehberFacade.findAll();
            return kisiListesi;
        } else {
            return kisiListesi;
        }
    }

}

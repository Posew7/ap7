package com.posew7.ap7.mb;

import com.posew7.ap7.entity.Grsklnc;
import com.posew7.ap7.sesion.GrsdmnFacade;
import com.posew7.ap7.sesion.GrsklncFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "girisMB")
@SessionScoped
public class girisMB implements Serializable {

    @EJB
    private GrsklncFacade grsklncFacade;

    @EJB
    private GrsdmnFacade grsdmnFacade;

    private String klnc;
    private String sfr;

    public girisMB() {
    }

    public String getKlnc() {
        return klnc;
    }

    public void setKlnc(String klnc) {
        this.klnc = klnc;
    }

    public String getSfr() {
        return sfr;
    }

    public void setSfr(String sfr) {
        this.sfr = sfr;
    }

    public String girisKontrol() {
        boolean sonuc = grsdmnFacade.giriseYetkiliMi(klnc, sfr);
        if (sonuc) {
            return "menu.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("HATA", "kullanıcı adı veya şifre yanlış"));
            return "";
        }
    }

    public String girisKontroll() {
        boolean sonuc = grsklncFacade.giriseYetkiliMi(klnc, sfr);
        if (sonuc) {
            return "menu.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("HATA", "kullanıcı adı veya şifre yanlış"));
            return "";
        }
    }

}

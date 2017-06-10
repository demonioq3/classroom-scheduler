package cl.ciisa.cr.beans;

import javax.faces.bean.ManagedBean;

/**
 * Created by agustinsantiago on 6/9/17.
 */
@ManagedBean
public class HomeBean {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
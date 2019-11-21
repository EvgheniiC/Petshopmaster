package com.eventim.petshop;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FacesUtils {


    private static final String USER_ID = "userId";

    public static HttpSession getSession() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return (HttpSession) facesContext.getExternalContext().getSession(true);
    }

    public static void putUserId(Integer userId) {
        getSession().setAttribute(USER_ID, userId);
    }

    public static Integer getUserId() {
        return (Integer) getSession().getAttribute(USER_ID);
    }

    public static void redirect(String destination) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

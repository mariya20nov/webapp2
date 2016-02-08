package com.epam.java.courses.finalproject.Client;

import com.epam.java.courses.finalproject.Logger4j;
import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Class of the handler of user tag
 */
public class NameTag extends TagSupport{
    private String name;

    public void setName(Object name) {
        this.name = (String)name;
    }


    public int doStartTag() throws JspException {
        Logger4j.log = Logger.getLogger(NameTag.class.getName());

        try {
            JspWriter out = pageContext.getOut();
            out.print(name);

        } catch(Exception e) {
            Logger4j.log.error("Exception in NameTag. ", e);
            throw new JspException("Error: " + e.getMessage());
        }
        return SKIP_BODY;
    }


    public int doEndTag() throws JspException {
        return SKIP_PAGE;
    }
}

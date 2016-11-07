package stingion.jsp;

import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class HelloAdvanceTag extends SimpleTagSupport {

    @Setter
    private int attr;
    @Setter
    private String second;

    private StringWriter sw = new StringWriter();

    public void doTag() throws JspException, IOException {
        if (getJspBody() != null) {
            getJspBody().invoke(sw);
            getJspContext().getOut().println(sw.toString());
        }
        if (attr != 0 && second != null) {
            JspWriter out = getJspContext().getOut();
            out.println(attr + " >>> " + second);
        }
    }
}

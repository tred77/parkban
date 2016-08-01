package ir.ssa.parkban.service.dto.reponse;

/**
 * author hym
 */
public class ParkbanMessageResponse {

    String text;
    String subject;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

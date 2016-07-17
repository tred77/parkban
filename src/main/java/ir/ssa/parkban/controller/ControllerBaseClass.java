package ir.ssa.parkban.controller;

import ir.ssa.parkban.vertical.core.util.DateUtils.DateConverter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.lang.annotation.Target;
import java.util.Date;

/**
 * Created by hadoop on 7/1/16.
 */
public class ControllerBaseClass {

    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport(){
            public void setAsText(String value) {
                try {
                    setValue(DateConverter.convertShamsiToMiladiBeginningOfDay(value));
                } catch(Exception e) {
                    setValue(null);
                }
            }

            public String getAsText() {
                return DateConverter.convertMiladiToShamsiWithoutTime((Date)getValue());
            }
        });



    }

}

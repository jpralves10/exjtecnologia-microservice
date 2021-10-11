package br.com.exj.cadastro.config.ff4j;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.ff4j.property.Property;
import org.ff4j.web.embedded.ConsoleRenderer;
import org.ff4j.web.embedded.ConsoleServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.ff4j.web.embedded.ConsoleConstants.*;
import static org.ff4j.web.embedded.ConsoleOperations.exportFile;
import static org.ff4j.web.embedded.ConsoleRenderer.*;

/**
 * Classe para tratar problema do servlet não aberto pelo spring
 */
public class ConsoleCustomServlet extends ConsoleServlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        super.init(servletConfig);
    }

    @Override
    public void pageCore(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String message = null;
        String messageType = "info";
        //Serve operation from GET
        String operation = req.getParameter(OPERATION);
        String featureId = req.getParameter(FEATID);
        try {
            // 'RSC' parameter will load some static resources
            if(ConsoleRenderer.renderResources(req, res)) return;

            if(operation != null && !operation.isEmpty()){
                //Operation which do not required features
                if(OP_EXPORT.equalsIgnoreCase(operation)){
                    exportFile(getFf4j(), res);
                    return;
                }

                //Work on a feature ID
                if((featureId != null) && (!featureId.isEmpty())){
                    if(getFf4j().getFeatureStore().exist(featureId)){
                        message = workWithFeature(res, operation, featureId);
                    }
                    if(getFf4j().getPropertiesStore().existProperty(featureId)){
                        message = workWithProperties(res, req, operation, featureId);
                    }
                }
            }
        }catch (Exception e){
            //Any Error is trapped and display in the console
            messageType = ERROR;
            message = e.getMessage();
        }
        //Default page rendering (table)
        if(operation == null || featureId == null){
            renderPage(getFf4j(), req, res, message, messageType);
        }
    }

    private String workWithFeature(HttpServletResponse res, String operation, String uid) throws IOException {
        String message = null;
        if(OP_DISABLE.equalsIgnoreCase(operation)){
            getFf4j().getFeatureStore().disable(uid);
            res.setContentType(CONTENT_TYPE_HTML);
            res.getWriter().println(renderMessageBox(msg(uid,"DISABLED"), "info"));
        }

        if(OP_ENABLE.equalsIgnoreCase(operation)){
            getFf4j().getFeatureStore().enable(uid);
            res.setContentType(CONTENT_TYPE_HTML);
            res.getWriter().println(renderMessageBox(msg(uid, "ENABLED"), "info"));
            FF4j teste = new FF4j("ff4j-features.xml");
            teste.enable(uid);
        }

        if(OP_READ_FEATURE.equalsIgnoreCase(operation)){
            Feature f = getFf4j().getFeatureStore().read(uid);
            res.setContentType(CONTENT_TYPE_JSON);
            res.getWriter().println(f.toJson());
        }

        //As no return the page is draw
        if(OP_RMV_FEATURE.equalsIgnoreCase(operation)){
            getFf4j().getFeatureStore().delete(uid);
            message = msg(uid, "DELETED");
        }
        return message;
    }

    private String workWithProperties(HttpServletResponse res, HttpServletRequest req, String operation, String uid) throws IOException {
        String message = null;
        if(OP_RMV_PROPERTY.equalsIgnoreCase(operation)){
            getFf4j().getPropertiesStore().deleteProperty(uid);
            LOGGER.info("Property '" + uid + "' has been deleted");
            message = renderMsgProperty(uid, "DELETED");
        }

        if(OP_READ_PROPERTY.equalsIgnoreCase(operation)){
            Property<?> ap = getFf4j().getPropertiesStore().readProperty(uid);
            res.setContentType(CONTENT_TYPE_JSON);
            res.getWriter().println(ap.toString());
        }

        if(OP_DELETE_FIXEDVALUE.equalsIgnoreCase(operation)){
            String fixedValue = req.getParameter(PARAM_FIXEDVALUE);
            Property<?> ap = getFf4j().getPropertiesStore().readProperty(uid);
            ap.getFixedValues().remove(fixedValue);
            getFf4j().getPropertiesStore().updateProperty(ap);
        }

        //As no return the page is draw
        if(OP_ADD_FIXEDVALUE.equalsIgnoreCase(operation)){
            String fixedValue = req.getParameter(PARAM_FIXEDVALUE);
            Property<?> ap = getFf4j().getPropertiesStore().readProperty(uid);
            ap.add2FixedValueFromString(fixedValue);
            getFf4j().getPropertiesStore().updateProperty(ap);
        }
        return message;
    }

    @Override
    public ServletConfig getServletConfig(){
        return this.config;
    }
}

package com.jdriven.ng2boot.model;

import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collection;

public class PD4MLUtil {

    public static ByteArrayOutputStream streamPDF(String html, HttpServletRequest request, Collection<URL> styleSheets ) {
        try {
            PD4ML pd4ml = PD4MLUtil.setupStandardPd4ml( false, styleSheets );
            InputStream inps = new ByteArrayInputStream(html.getBytes("UTF-8"));
            InputStreamReader r = new InputStreamReader( inps, "UTF-8" );
            return render(pd4ml, r, new URL(request.getRequestURL().toString()));
        } catch (RuntimeException rte) {
            throw rte;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PD4ML setupStandardPd4ml(boolean landscapeValue, Collection<URL> styleSheets) throws UnknownHostException {
        final PD4ML pd4ml = new PD4ML();
        pd4ml.enableDebugInfo();
        try {
            final String hostname = InetAddress.getLocalHost().getHostName();
            pd4ml.setAuthorName("Roma" + " - " + hostname);
        } catch (UnknownHostException e) {
            pd4ml.setAuthorName("Roma");
        }
        pd4ml.setHtmlWidth(800);
        pd4ml.adjustHtmlWidth();
        pd4ml.enableSmartTableBreaks(true);
        pd4ml.enableImgSplit(false);
        pd4ml.setPageSize(PD4Constants.LETTER);
        if (landscapeValue) {
            pd4ml.setPageSize(pd4ml.changePageOrientation(PD4Constants.LETTER));
        }
        // Adding StyleSheets
        if (null != styleSheets) {
            for (URL styleSheet : styleSheets) {
                pd4ml.addStyle(styleSheet, true);
            }
        }

        return pd4ml;
    }

    private static ByteArrayOutputStream render(PD4ML pd4ml, InputStreamReader in, URL base) throws IOException, FileNotFoundException {
        ByteArrayOutputStream pdf = new ByteArrayOutputStream();
        pd4ml.enableDebugInfo();
        pd4ml.useTTF("java:fonts", true); //TRAX-47137,47202,61909
        pd4ml.render(in, pdf, base);
        return pdf;
    }



}

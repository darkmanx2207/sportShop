package com.jdriven.ng2boot.controllers;

import com.jdriven.ng2boot.entity.Protein;
import com.jdriven.ng2boot.entity.User;
import com.jdriven.ng2boot.model.Image;
import com.jdriven.ng2boot.model.PD4MLUtil;
import com.jdriven.ng2boot.model.TablePageRequest;
import com.jdriven.ng2boot.service.ProteinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/protein")
public class ProteinController {

    private final ProteinService proteinService;


    public ProteinController(ProteinService proteinService) {
        this.proteinService = proteinService;
    }

    @GetMapping("/{id}")
    public Protein getProtein(@PathVariable("id") Long id) {
        return proteinService.getProtein(id);
    }

    @GetMapping("/{id}/image")
    public Image getImage(@PathVariable("id") Long id) {
        return proteinService.getImage(id);
    }

    @PostMapping("/proteins")
    public ResponseEntity<List<Protein>> getListofProteins(@RequestBody TablePageRequest tablePageRequest,
                                                           final HttpServletRequest request) throws MalformedURLException {
        List<Protein> list =  proteinService.getListofProteins(tablePageRequest);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}/pdf")
    protected ResponseEntity<byte []> getPDF(@PathVariable("id") Long id,
                                             final HttpServletRequest request) throws MalformedURLException {

        String content = "This is my test work";
        ByteArrayOutputStream bos = createPDFStream(content, request);

        return new ResponseEntity<>(bos.toByteArray(), HttpStatus.OK);
    }

    private ByteArrayOutputStream createPDFStream(String content, HttpServletRequest request) throws MalformedURLException {
        List<URL> cssList = new ArrayList<>();
        cssList.add(createURL(request, "/test.css"));

        return PD4MLUtil.streamPDF(content, request, cssList);
    }

    private URL createURL(final HttpServletRequest request, final String contextPath) throws MalformedURLException {
        return new URL(request.getScheme(), request.getServerName(), request.getServerPort(), contextPath);
    }
}

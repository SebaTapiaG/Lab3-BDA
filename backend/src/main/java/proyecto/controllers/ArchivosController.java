package proyecto.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/archivos")
public class ArchivosController {

    private final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    @PostMapping("/upload")
    public String subirArchivo(@RequestParam("file") MultipartFile archivo) throws IOException {
        // Crear el directorio si no existe
        File directorio = new File(UPLOAD_DIR);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        // Guardar el archivo
        String rutaArchivo = UPLOAD_DIR + archivo.getOriginalFilename();
        archivo.transferTo(new File(rutaArchivo));

        return "Archivo subido con éxito: " + rutaArchivo;
    }
}


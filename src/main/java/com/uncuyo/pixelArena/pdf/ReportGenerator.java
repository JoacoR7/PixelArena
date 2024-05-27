package com.uncuyo.pixelArena.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.uncuyo.pixelArena.model.Empresa;
import com.uncuyo.pixelArena.model.Juego;
import com.uncuyo.pixelArena.model.Torneo;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReportGenerator {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static void generarReportePDF(List<Empresa> empresas, List<Juego> juegos, List<Torneo> torneos, String nombreArchivo) throws IOException {
        Date fechaActual = new Date();
        PdfWriter writer = new PdfWriter(nombreArchivo);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Add header with report title and date
        Paragraph header = new Paragraph("Reporte de Datos")
                .setTextAlignment(TextAlignment.CENTER);
        document.add(header);

        document.add(new Paragraph("Fecha: " + DATE_FORMAT.format(fechaActual)));


        addSectionTitle(document, "Empresas");
        addDataList(document, empresas);
        addSectionTitle(document, "Juegos");
        addDataList(document, juegos);
        addSectionTitle(document, "Torneos");
        addDataList(document, torneos);

        document.close();
    }

    private static void addSectionTitle(Document document, String title) {
        Paragraph sectionTitle = new Paragraph(title);
        document.add(sectionTitle);
    }

    private static void addDataList(Document document, List<?> dataList) {
        for (Object item : dataList) {
            Paragraph dataItem = new Paragraph("- " + item.toString());
            document.add(dataItem);
        }
    }
}

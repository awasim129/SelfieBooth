/*
 * Copyright (C) 2018 xterminate
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package booth_ai;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Chromaticity;
import javax.print.attribute.standard.Finishings;


/**
 *
 * @author xterminate
 */
public class Printer {
  
  public static Image image;
    
  public static void print() throws DocumentException, BadElementException, IOException, PrinterException {  
  Document document = new Document(PageSize.A4, 20, 20, 20, 20);
      try {
          PdfWriter.getInstance(document, new FileOutputStream(GLOBAL_VARS.PRINT_DOCUMENT_PATH));
      } catch (FileNotFoundException ex) {
          Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
      }
  document.open();
  image = Image.getInstance(GLOBAL_VARS.OUTPUT_FILE);
  document.add(image);
  document.close();
  
 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob docPrintJob = service.createPrintJob();
FileInputStream fis = null;
try {
    fis = new FileInputStream(GLOBAL_VARS.PRINT_DOCUMENT_PATH);
} catch (FileNotFoundException ex) {
    ex.printStackTrace();
}
 
DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
Doc doc = new SimpleDoc(fis, flavor, null);
 
PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
aset.add(Chromaticity.COLOR);
aset.add(Finishings.STAPLE);
 
try {
    docPrintJob.print(doc, aset);
} catch (Exception e) {
    e.printStackTrace();
}


  }
  
  
}

package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    @Test
    public void test() throws IOException {
        ///Java'da bir dosyayı açmak için bu kullanılır.
        // Parametre bölümüne açmak istediğimiz dosyanın adresi (dosya yolu,path) yazılır
        String filePath = "src/test/resources/ULKELER.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //Birinci sayfaya gider.(index)
        Sheet sheet = workbook.getSheetAt(0);
        //0 index numarali sayfaya gider index 0 dan baslar

        //Workbook
        //1. satira  gidelim.(index degeri 0'dan baslar)
        Row row = sheet.getRow(0);

        //1. Hücreyi alalim
        Cell ulkeler = row.getCell(0);
        Cell baskentler = row.getCell(1);
        Cell meshurlar = row.getCell(2);
        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);
// Excel'e Git -> Sheet 0'a git -> 2. İndexteki Satıra git -> 1. İndexteki Hücre
        System.out.println(workbook.getSheetAt(0).getRow(2).getCell(1));
        System.out.println(workbook.getSheetAt(0).getRow(7).getCell(2));//peynir

        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0));//Arjantin
// Son satır(Row)'ın numarasını almak için (indexini, index 0 dan başlar)
        int satirSayisi = workbook.getSheetAt(0).getLastRowNum();
        System.out.println("Satır sayısı : " + satirSayisi);

        int doluSatir = workbook.getSheetAt(0).getPhysicalNumberOfRows();

        //tüm ülkeleri yazdirdik
        int sonSatirinIndexi = workbook.getSheetAt(0).getLastRowNum(); // 10
        for (int i = 0; i <= sonSatirinIndexi; i++) {
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }
        //tüm baskentleri yazdiralim
        int sonSatirIndex = workbook.getSheetAt(0).getLastRowNum(); // 10
        for (int j = 0; j <= sonSatirIndex; j++) {
            System.out.println(workbook.getSheetAt(0).getRow(j).getCell(1));
        }
        // meshur sütunu yazdirma
        for (int k = 0; k <= sonSatirinIndexi; k++) {
            System.out.println(workbook.getSheetAt(0).getRow(k).getCell(2));
        }
        //bir satirin son sütunun indexini alma

        // bir satırın son sütunun indexini alma
        //Bu birden baslar.

        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("Son Sütun İndex : " + sonSutunIndex);

        for (int l =0; l<sonSutunIndex ; l++){
            System.out.println("4. Satır " + l +". Sütun :" + workbook.getSheetAt(0).getRow(3).getCell(l) );
        }

        fileInputStream.close();
        workbook.close();

    }
}
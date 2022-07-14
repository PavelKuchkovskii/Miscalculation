package com.example.miscalculation.excelUtill;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;

import com.example.miscalculation.ContinePrice;
import com.example.miscalculation.MainActivity;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;

import java.io.*;

public class ExcelCreator implements Serializable {

    public static final String BALDOR_PICTURE = "wind/baldor_picture.png";
    public static final String WIND1STNO_PICTURE = "wind/wind1stno_picture.png";
    public static final String WIND1STOP_PICTURE = "wind/wind1stop_picture.png";
    public static final String WIND2ST1OP_PICTURE = "wind/wind2st1op_picture.png";
    public static final String WIND2ST2OP_PICTURE = "wind/wind2st2op_picture.png";
    public static final String WIND2STNO_PICTURE = "wind/wind2stno_picture.png";
    public static final String WIND3ST1OP_PICTURE = "wind/wind3st1op_picture.png";
    public static final String WIND3ST2OP_PICTURE = "wind/wind3st2op_picture.png";
    public static final String WIND3STNO_PICTURE = "wind/wind3stno_picture.png";
    public static final String WIND3ST3OP_PICTURE = "wind/wind3st3op_picture.png";
    public static final String WIND4ST2OP_PICTURE = "wind/wind4st2op_picture.png";
    public static final String WIND4STNO_PICTURE = "wind/wind4stno_picture.png";
    public static final String WIND4ST1OP_PICTURE = "wind/wind4st1op_picture.png";
    public static final String WIND4ST3OP_PICTURE = "wind/wind4st3op_picture.png";
    public static final String WIND4ST4OP_PICTURE = "wind/wind4st4op_picture.png";
    public static final String DOOR1ST_PICTURE = "wind/door1st_picture.png";
    public static final String DOOR2ST_PICTURE = "wind/door2st_picture.png";
    public static final String AL1STNO_PICTURE = "al/al1stno_picture.png";
    public static final String AL2ST1OP_PICTURE = "al/al2st1op_picture.png";
    public static final String AL2ST2OP_PICTURE = "al/al2st2op_picture.png";
    public static final String AL2STNO_PICTURE = "al/al2stno_picture.png";
    public static final String AL3ST1OP_PICTURE = "al/al3st1op_picture.png";
    public static final String AL3ST2OP_PICTURE = "al/al3st2op_picture.png";
    public static final String AL3STNO_PICTURE = "al/al3stno_picture.png";
    public static final String AL3ST3OP_PICTURE = "al/al3st3op_picture.png";
    public static final String AL4ST2OP_PICTURE = "al/al4st2op_picture.png";
    public static final String AL4STNO_PICTURE = "al/al4stno_picture.png";
    public static final String AL4ST1OP_PICTURE = "al/al4st1op_picture.png";
    public static final String AL4ST3OP_PICTURE = "al/al4st3op_picture.png";
    public static final String AL4ST4OP_PICTURE = "al/al4st4op_picture.png";


    private static String tmpPicturePath;
    private static int tmpWidth;
    private static int tmpHeight;

    private final int nextPage = 52;



    private final HSSFWorkbook wb;
    private final HSSFSheet sheet;

    private int count = 0;

    private int countPod = 0;
    private int countOtl = 0;
    private int countMS = 0;
    private int countSoed = 0;
    private int countRash = 0;

    private final AssetManager am;


    public ExcelCreator(AssetManager am) {
        this.am = am;
        this.wb = new HSSFWorkbook();
        this.sheet = wb.createSheet("KomPred");
        createBook();
     }

    public void addWindow(String picturePath, int height, int width, String info) throws IOException {
        createCells(picturePath, height, width, info);
        count++;
    }

    //Рисует новые ячейки для нового изделия
    private void createCells(String picturePath, int height, int width, String info) throws IOException {
        int page;

        //Высчитываем какая страница
        page = (count+1)/6 + 1;


//=================================================СТИЛИ================================================================
        //Выраванивание и цвет
        CellStyle style1 = wb.createCellStyle();
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setVerticalAlignment(VerticalAlignment.CENTER);
        style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style1.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());

        //Границы
        style1.setBorderBottom(BorderStyle.MEDIUM);
        style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderLeft(BorderStyle.MEDIUM);
        style1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderRight(BorderStyle.MEDIUM);
        style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style1.setBorderTop(BorderStyle.MEDIUM);
        style1.setTopBorderColor(IndexedColors.BLACK.getIndex());

        CellStyle style2 = wb.createCellStyle();
        style2.setAlignment(HorizontalAlignment.LEFT);
        style2.setVerticalAlignment(VerticalAlignment.TOP);

        style2.setBorderBottom(BorderStyle.MEDIUM);
        style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style2.setBorderLeft(BorderStyle.MEDIUM);
        style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style2.setBorderRight(BorderStyle.MEDIUM);
        style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style2.setBorderTop(BorderStyle.MEDIUM);
        style2.setTopBorderColor(IndexedColors.BLACK.getIndex());

        HSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short)7);
        style2.setWrapText(true);
        style2.setFont(font);
//======================================================================================================================

        addToPage(page, picturePath, height, width, info, style1, style2);
    }

    //Рисует страницы и добавляет на них изделия
    private void addToPage(int page, String picturePath, int height, int width, String info, CellStyle style1, CellStyle style2) throws IOException {
        int count_nextPage;
        int start;

        //Если уже не первая страница
        if (page > 1) {
            //Каждые 52 строки(настраивается) новая страница(Зависит от принтера)
            start = nextPage * (page - 1);

            //МАТЕМАТИКА =)
            count_nextPage = count - ((page * 5) + (page - 7));
            /* У нас идет закономерность что если страница 2 то уже 5 изделий
                Если страница 3 то 11, если 4 то 17 и т.д
                вывел формулу, как получать это кол-во.И отнимаем его от общего кол-ва, что бы знать сколько уже на этой странице есть
            */
        }
        //Если еще первая страница, то кол-во оставляем текущее, начало ячеек с 8 индекса
        else {
            start = 8;
            count_nextPage = count;
        }

        for (int i = 0; i < 8; i++) {
            HSSFRow row = sheet.createRow(start + i + (8 * count_nextPage));
            for (int j = 0; j < 9; j++) {
                row.createCell(j);
                if (i < 2 && j > 3 ) {
                    row.getCell(j).setCellStyle(style1);
                }
                else {
                    row.getCell(j).setCellStyle(style2);
                }
            }
        }


        //Объединение ячеек полей картинки
        sheet.addMergedRegion(new CellRangeAddress(
                start + (8 * count_nextPage), //first row (0-based)
                start + 7 + (8 * count_nextPage), //last row  (0-based)
                0, //first column (0-based)
                3  //last column  (0-based)
        ));

        //Объединение ячеек полей информации
        sheet.addMergedRegion(new CellRangeAddress(
                start + 2 + (8 * count_nextPage), //first row (0-based)
                start + 7 + (8 * count_nextPage), //last row  (0-based)
                4, //first column (0-based)
                8  //last column  (0-based)
        ));


        sheet.addMergedRegion(new CellRangeAddress(
                start + (8 * count_nextPage), //first row (0-based)
                start + 1 + (8 * count_nextPage), //last row  (0-based)
                4, //first column (0-based)
                5  //last column  (0-based)
        ));
        sheet.addMergedRegion(new CellRangeAddress(
                start + (8 * count_nextPage), //first row (0-based)
                start + 1 + (8 * count_nextPage), //last row  (0-based)
                6, //first column (0-based)
                6  //last column  (0-based)
        ));
        sheet.addMergedRegion(new CellRangeAddress(
                start + (8 * count_nextPage), //first row (0-based)
                start + 1 + (8 * count_nextPage), //last row  (0-based)
                7, //first column (0-based)
                7  //last column  (0-based)
        ));
        sheet.addMergedRegion(new CellRangeAddress(
                start + (8 * count_nextPage), //first row (0-based)
                start + 1 + (8 * count_nextPage), //last row  (0-based)
                8, //first column (0-based)
                8  //last column  (0-based)
        ));

        //Маркер компании
        sheet.getRow(start + (count_nextPage * 8)).getCell(0).setCellValue("ООО \"ЕВРОХОЛЛ\"");

        //Вставляем картинку
        InputStream is = readFile(picturePath);
        byte[] bytes = IOUtils.toByteArray(is);
        is.close();
        // Топ-менеджер по рисованию, только один лист может получить один (обязательно обратите внимание на этот момент)
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // якорь в основном используется для установки свойств картинки
        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) 1, start + 2 + (count_nextPage * 8), (short) 3, start + 6 + (count_nextPage * 8));
        anchor.setAnchorType(ClientAnchor.AnchorType.byId(3));
        // Вставить картинку
        patriarch.createPicture(anchor, wb.addPicture(bytes, HSSFWorkbook.PICTURE_TYPE_JPEG));


        //Добавляем информацию на страницу
        HSSFRow row = sheet.getRow(start + (8 * count_nextPage));
        //ПОЗИЦИЯ
        row.getCell(4).setCellValue("№" + (count + 1));
        //ВЫСОТА
        row.getCell(6).setCellValue(height);
        //ШИРИНА
        row.getCell(7).setCellValue(width);
        //КОЛ-ВО
        row.getCell(8).setCellValue(1);
        //Информация
        sheet.getRow(start + 2 + (8 * count_nextPage)).getCell(4).setCellValue(info);
    }

    //Получаем готвую спецификацию
    public Uri getSpecification(int price, Context context) throws IOException {
        //Выясняем какая страница
        int page = (count+1)/6 + 1;

        int start;

        //????
        if ( count - ((page) * 5 + (page) - 7) >= 1 ) {

            if (page == 1) {
                start = 10 + (count * 8);
            }
            else{
                //Каждые 52(настраивается) строки новая страница(Зависит от принтера)
                start = (nextPage * (page - 1)) + ((count - ((page * 5) + (page - 7))) * 8) + 2;
            }

        } else {
            start = nextPage * (page - 1);
        }

        //Создаем ячейки
        for (int i = 0; i < 8; i++) {
            HSSFRow row = sheet.createRow(start + i);
            for (int j = 0; j < 9; j++) {
                row.createCell(j);
            }
        }

        //Делаем объединения
        for (int i = 0; i < 7; i++) {
            int j = 0;
            if(i == 6) {
                ++j;
            }
            sheet.addMergedRegion(new CellRangeAddress(
                    start + i, //first row (0-based)
                    start + i + j, //last row  (0-based)
                    0, //first column (0-based)
                    6  //last column  (0-based)
            ));

            sheet.addMergedRegion(new CellRangeAddress(
                    start + i, //first row (0-based)
                    start + i + j, //last row  (0-based)
                    7, //first column (0-based)
                    8  //last column  (0-based)
            ));
        }

        //Отрисовываем границы и устанавливаем стиль
        //Cтили
        CellStyle style = getStyle1();
        CellStyle style2 = getStyle2();
        CellStyle style3 = getStyle3();
        CellStyle style4 = getStyle4();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                sheet.getRow(start + 1 + i).getCell(j).setCellStyle(style2);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                sheet.getRow(start + 1 + i).getCell(j + 7).setCellStyle(style3);
            }
        }

        //Ячейка кол-ва
        HSSFRow row = sheet.getRow(start);
        row.getCell(7).setCellStyle(style);
        row.getCell(8).setCellStyle(style);
        //Ячейка ИТОГО
        row = sheet.getRow(start + 6);
        for (int i = 0; i < 7; i++) {
            row.getCell(i).setCellStyle(style);
        }
        row = sheet.getRow(start + 7);
        for (int i = 0; i < 7; i++) {
            row.getCell(i).setCellStyle(style);
        }
        //Ячейка итого ЦЕНА
        row = sheet.getRow(start + 6);
        row.getCell(7).setCellStyle(style);
        row.getCell(8).setCellStyle(style);
        row = sheet.getRow(start + 7);
        row.getCell(7).setCellStyle(style);
        row.getCell(8).setCellStyle(style);

        for (int i = 0; i < 7; i++) {
            sheet.getRow(start).getCell(i).setCellStyle(style4);
        }

        sheet.getRow(start).getCell(0).setCellValue("Дополнительные комплектующие: ");
        sheet.getRow(start + 1).getCell(0).setCellValue("Подоконники: ");
        sheet.getRow(start + 2).getCell(0).setCellValue("Отливы: ");
        sheet.getRow(start + 3).getCell(0).setCellValue("М\\С: ");
        sheet.getRow(start + 4).getCell(0).setCellValue("Соединители: ");
        sheet.getRow(start + 5).getCell(0).setCellValue("Расширители: ");
        sheet.getRow(start + 6).getCell(0).setCellValue("ИТОГО ПО ОБЪЕКТУ С МОНТАЖОМ: ");
        sheet.getRow(start).getCell(7).setCellValue("Кол-во, шт.");
        sheet.getRow(start + 1).getCell(7).setCellValue(countPod);
        sheet.getRow(start + 2).getCell(7).setCellValue(countOtl);
        sheet.getRow(start + 3).getCell(7).setCellValue(countMS);
        sheet.getRow(start + 4).getCell(7).setCellValue(countSoed);
        sheet.getRow(start + 5).getCell(7).setCellValue(countRash);
        sheet.getRow(start + 6).getCell(7).setCellValue(price + " руб.");
        //Какой то метод который получает книгу
        Uri uri = writeList(context);

        //Удаляем ячейки с итогом
        for (int i = 0; i < 8; i++) {
            sheet.removeRow(sheet.getRow(start + i));
        }
        for (int i = 0; i < 14; i++) {
            sheet.removeMergedRegion(sheet.getNumMergedRegions() - 1);
        }
        return uri;
    }

    private Uri writeList(Context context) throws IOException {
        Uri uri = null;

        OutputStream fileOut = null;

        //Для андроид 10+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, MainActivity.nameMeasure + " спец.xls");
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "application/octet-stream");
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS + File.separator + "Miscalculation");
            ContentResolver resolver = context.getContentResolver();

            final Uri contentUri = MediaStore.Files.getContentUri("external");
            //Перед созданием нового элемента, полностью удаляем всю таблицу файлов "external"
            resolver.delete(contentUri, null, null);

            uri = resolver.insert(contentUri, contentValues);

            fileOut = resolver.openOutputStream(uri);
        }
        //Для более старых версий
        else {
            //Сохраняем спецификацию в папку приложения
            fileOut = new FileOutputStream(new File(context.getExternalFilesDir(null), MainActivity.nameMeasure + " спец.xls"));
        }

        // написать файл Excel
        wb.write(fileOut);
        return uri;
    }

    private void createBook() {
        CellStyle style = getStyle1();

        for (int i = 0; i < 8; i++) {
            HSSFRow row = sheet.createRow(i);
            for (int j = 0; j < 9; j++) {
                row.createCell(j);
                row.getCell(j).setCellStyle(style);
            }
        }

        sheet.addMergedRegion(new CellRangeAddress(
                0, //first row (0-based)
                1, //last row  (0-based)
                0, //first column (0-based)
                8  //last column  (0-based)
        ));
        sheet.addMergedRegion(new CellRangeAddress(
                2, //first row (0-based)
                5, //last row  (0-based)
                0, //first column (0-based)
                8  //last column  (0-based)
        ));

        sheet.addMergedRegion(new CellRangeAddress(
                6, //first row (0-based)
                7, //last row  (0-based)
                0, //first column (0-based)
                3  //last column  (0-based)
        ));
        sheet.addMergedRegion(new CellRangeAddress(
                6, //first row (0-based)
                7, //last row  (0-based)
                4, //first column (0-based)
                5  //last column  (0-based)
        ));
        sheet.addMergedRegion(new CellRangeAddress(
                6, //first row (0-based)
                6, //last row  (0-based)
                6, //first column (0-based)
                7  //last column  (0-based)
        ));
        sheet.addMergedRegion(new CellRangeAddress(
                6, //first row (0-based)
                7, //last row  (0-based)
                8, //first column (0-based)
                8  //last column  (0-based)
        ));

        sheet.getRow(0).getCell(0).setCellValue("ООО \"ЕВРОХОЛЛ\"");
        sheet.getRow(0).getCell(0).setCellStyle(getStyle6());
        sheet.getRow(2).getCell(0).setCellValue("СПЕЦИФИКАЦИЯ \n к изготовлению конструкций оконных заполнений с оценкой их стоимости по объекту");
        sheet.getRow(2).getCell(0).setCellStyle(getStyle5());
        sheet.getRow(6).getCell(0).setCellValue("Эскиз изделия");
        sheet.getRow(6).getCell(4).setCellValue("Позиция");
        sheet.getRow(6).getCell(6).setCellValue("Размеры, мм");
        sheet.getRow(7).getCell(6).setCellValue("Высота");
        sheet.getRow(7).getCell(7).setCellValue("Ширина");
        sheet.getRow(6).getCell(8).setCellValue("Кол-во");
    }

    public InputStream readFile(String fileName) throws IOException {
        return am.open(fileName);
    }

    //ВСЕ ТОЛСТЫЕ ЛИНИИ, ВЫРАВНИВАНИЕ ПО ЦЕНТРУ, ЖИРНЫЙ ТЕКСТ
    private CellStyle getStyle1() {
        CellStyle style = wb.createCellStyle();
        HSSFFont font = wb.createFont();

        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        font.setBold(true);

        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setFont(font);

        return style;
    }

    //Верхние нижние и правые линии тонкие - левые толстые, ВЫРАВНИВАНИЕ ПО правому краю
    private CellStyle getStyle2() {
        CellStyle style = wb.createCellStyle();

        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        return style;
    }

    //Верхние нижние и левые линии тонкие - правые толстые, ВЫРАВНИВАНИЕ ПО центру
    private CellStyle getStyle3() {
        CellStyle style = wb.createCellStyle();

        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        return style;
    }

    //ВСЕ ТОЛСТЫЕ ЛИНИИ, ВЫРАВНИВАНИЕ ПО Левому краю, ЖИРНЫЙ ТЕКСТ
    private CellStyle getStyle4() {
        CellStyle style = wb.createCellStyle();
        HSSFFont font = wb.createFont();

        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        font.setBold(true);

        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setFont(font);

        return style;
    }

    //ВСЕ ТОЛСТЫЕ ЛИНИИ, ВЫРАВНИВАНИЕ ПО ЦЕНТРУ, ЖИРНЫЙ ТЕКСТ, ПЕРЕНОС ТЕКСТА
    private CellStyle getStyle5() {
        CellStyle style = wb.createCellStyle();
        HSSFFont font = wb.createFont();

        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        font.setBold(true);

        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setFont(font);
        style.setWrapText(true);

        return style;
    }

    //ВСЕ ТОЛСТЫЕ ЛИНИИ, ВЫРАВНИВАНИЕ ПО ЦЕНТРУ, ЖИРНЫЙ ТЕКСТ - РАЗМЕР 18
    private CellStyle getStyle6() {
        CellStyle style = wb.createCellStyle();
        HSSFFont font = wb.createFont();

        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        font.setBold(true);
        font.setFontHeightInPoints((short) 18);

        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setFont(font);

        return style;
    }

    public void incrementCountPod() {
        ++countPod;
    }
    public void incrementCountOtl() {
        ++countOtl;
    }
    public void incrementCountMS() {
        ++countMS;
    }
    public void incrementCountSoed() {
        ++countSoed;
    }
    public void incrementCountRash() {
        ++countRash;
    }

    public void decrementCountPod() {
        --countPod;
    }
    public void decrementCountOtl() {
        --countOtl;
    }
    public void decrementCountMS() {
        --countMS;
    }
    public void decrementCountSoed() {
        --countSoed;
    }
    public void decrementCountRash() {
        --countRash;
    }

    public static int getTmpWidth() {
        return tmpWidth;
    }

    public static int getTmpHeight() {
        return tmpHeight;
    }

    public static String getTmpPicturePath() {
        return tmpPicturePath;
    }

    public static void setTmpHeight(int tmpHeight) {
        ExcelCreator.tmpHeight = tmpHeight;
    }

    public static void setTmpWidth(int tmpWidth) {
        ExcelCreator.tmpWidth = tmpWidth;
    }

    public static void setTmpPicturePath(String tmpPicturePath) {
        ExcelCreator.tmpPicturePath = tmpPicturePath;
    }
}

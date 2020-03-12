package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReadExcel {

    public static Object[][] readExcel(String path) throws IOException {

        path = "src/main/java/TestData" + File.separator + path;

        List<List<Object>> result = null;


        DataFormatter fmt = new DataFormatter();

        File excel = new File(path);

        Workbook workbook = WorkbookFactory.create(excel);

        for(Sheet sheet: workbook){
            int rawStart = 1;
            int rawEnd = sheet.getLastRowNum();
            int lastColumn = -1;

            result = new LinkedList<>();

            List<Object> rowData = null;
            for(int rid = rawStart; rid <= rawEnd; ++rid){
                Row row = sheet.getRow(rid);

                lastColumn = row.getLastCellNum();

                rowData = new LinkedList<>();

                for(int cidx = 0; cidx<lastColumn; ++cidx){
                    Cell cell = row.getCell(cidx, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String text = fmt.formatCellValue(cell);
                    rowData.add(text);
                }
                result.add(rowData);

            }
        }
        if(result == null){
            return null;
        }
        return convertToArray(result);
    }

    public static Object[][] convertToArray(List<List<Object>> data){
        int row = data.size();
        if(row == 0){
            return null;
        }
        int column = data.get(0).size();
        Object[][] result = new Object[row][column];


        for(int i=0; i<row; i ++){
            List<Object> rowData = data.get(i);
            for(int j=0; j < column; j++){
                result[i][j] = rowData.get(j);

            }
        }

        return result;
    }
}

import org.apache.poi.hssf.record.aggregates.RowRecordsAggregate;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ReadExcel {
    public User[] readExcel(File file) {
        User users[]=null;
        try {
            XSSFWorkbook xw = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet xs= xw.getSheetAt(0);
            users=new User[xs.getLastRowNum()];
            for (int j = 1; j<=xs.getLastRowNum(); j++) {
                    XSSFRow row = xs.getRow(j);
                User user=new User();

                    for (int k = 0; k <= row.getLastCellNum(); k++) {
                        XSSFCell cell = row.getCell(k);
                        if (cell == null)
                            continue;
                        if (k == 0) {
                            user.setUsername(this.getValue(cell));//给username属性赋值
                        } else if (k == 1) {
                            user.setPassword(this.getValue(cell));//给password属性赋值
                        } else if (k == 2) {
                            user.setAddress(this.getValue(cell));//给address属性赋值
                        } else if (k == 3) {
                            user.setPhone(this.getValue(cell));//给phone属性赋值
                        }
                        users[j-1]=user;
                    }
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private String getValue(XSSFCell cell) {
        String value;
        CellType type = cell.getCellTypeEnum();

        switch (type) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BLANK:
                value = "";
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue() + "";
                break;
            case NUMERIC:
                value = cell.getNumericCellValue() + "";
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case ERROR:
                value = "非法字符";
                break;
            default:
                value = "";
                break;
        }
        return value;
    }
}
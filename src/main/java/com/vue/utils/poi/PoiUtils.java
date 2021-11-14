package com.vue.utils.poi;

import com.vue.entity.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PoiUtils {
    private final static String xls = "xls";
    private final static String xlsx = "xlsx";

    public static List<Emp> importEmp2List(MultipartFile file,
                                                List<Nation> allNations,
                                                List<PoliticsStatus> allPolitics,
                                                List<Department> allDeps,
                                                List<Position> allPos,
                                                List<JobLevel> allJobLevels) {
        List<Emp> emps = new ArrayList<Emp>();
        try {
            HSSFWorkbook workbook =
                    new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                Emp employee;
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue;//标题行
                    }
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//没数据
                    }
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    employee = new Emp();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellTypeEnum()) {
                            case STRING: {
                                String cellValue = cell.getStringCellValue();
                                if (cellValue == null) {
                                    cellValue = "";
                                }
                                switch (k) {
                                    case 1:
                                        employee.setName(cellValue);
                                        break;
                                    case 2:
                                        employee.setWorkID(cellValue);
                                        break;
                                    case 3:
                                        employee.setGender(cellValue);
                                        break;
                                    case 5:
                                        employee.setIdCard(cellValue);
                                        break;
                                    case 6:
                                        employee.setWedlock(cellValue);
                                        break;
                                    case 7:
                                        int nationIndex = allNations.indexOf(new Nation(cellValue));
                                        employee.setNationId(allNations.get(nationIndex).getId());
                                        break;
                                    case 8:
                                        employee.setNativePlace(cellValue);
                                        break;
                                    case 9:
                                        int psIndex = allPolitics.indexOf(new PoliticsStatus(cellValue));
                                        employee.setPoliticId(allPolitics.get(psIndex).getId());
                                        break;
                                    case 10:
                                        employee.setPhone(cellValue);
                                        break;
                                    case 11:
                                        employee.setAddress(cellValue);
                                        break;
                                    case 12:
                                        int depIndex = allDeps.indexOf(new Department(cellValue));
                                        employee.setDepartmentId(allDeps.get(depIndex).getId());
                                        break;
                                    case 13:
                                        int jlIndex = allJobLevels.indexOf(new JobLevel(cellValue));
                                        employee.setJobLevelId(allJobLevels.get(jlIndex).getId());
                                        break;
                                    case 14:
                                        int posIndex = allPos.indexOf(new Position(cellValue));
                                        employee.setPosId(allPos.get(posIndex).getId());
                                        break;
                                    case 15:
                                        employee.setEngageForm(cellValue);
                                        break;
                                    case 16:
                                        employee.setTiptopDegree(cellValue);
                                        break;
                                    case 17:
                                        employee.setSpecialty(cellValue);
                                        break;
                                    case 18:
                                        employee.setSchool(cellValue);
                                        break;
                                    case 19:
                                    case 20:
                                        employee.setWorkState(cellValue);
                                        break;
                                    case 21:
                                        employee.setEmail(cellValue);
                                        break;
                                }
                            }
                            break;
                            default: {
                                switch (k) {
                                    case 4:
                                        employee.setBirthday(cell.getDateCellValue());
                                        break;
                                    case 19:
                                        employee.setBeginDate(cell.getDateCellValue());
                                        break;
                                    case 22:
                                        employee.setContractTerm(cell.getNumericCellValue());
                                        break;
                                    case 23:
                                        employee.setBeginContract(cell.getDateCellValue());
                                        break;
                                    case 24:
                                        employee.setEndContract(cell.getDateCellValue());
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    emps.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emps;
    }

//    public static List<Emp> importEmp2List(MultipartFile file,
//                                           List<Nation> nations,
//                                           List<PoliticsStatus> allPolitics,
//                                           List<Department> departments,
//                                           List<Position> positions1,
//                                           List<JobLevel> jobLevels) {
//        List<Emp> emps = new ArrayList<Emp>();
//
//        String fileName = file.getOriginalFilename();
//
//        try {
//            HSSFWorkbook workbook   = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
////            XSSFWorkbook xssfWorkbook = null;
//            //判断文件是否是excel文件
//            int numberOfSheets = workbook.getNumberOfSheets();
//            for(int i = 0;i<numberOfSheets;i++){
//                HSSFSheet sheet = workbook.getSheetAt(i);
//                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
//                Emp emp;
//                for(int j = 0;j<physicalNumberOfRows;j++){
//                    if(j==0){
//                        //标题行
//                        continue;
//                    }
//                    HSSFRow row = sheet.getRow(j);
//                    if(row == null){
//                      //没数据
//                      continue;
//                    }
//                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
//                    emp = new Emp();
//                    for(int k = 0;k<physicalNumberOfCells;k++){
//                        HSSFCell cell = row.getCell(k);
//                        switch (cell.getCellTypeEnum()){
//                            case STRING:{
//                                String cellValue = cell.getStringCellValue();
//                                if(cellValue == null){
//                                    cellValue = "";
//                                }
//                                switch (k){
//                                    case 1:
//                                        emp.setName(cellValue);
//                                        break;
//                                    case 2:
//                                        emp.setWorkID(cellValue);
//                                        break;
//                                    case 3:
//                                        emp.setGender(cellValue);
//                                        break;
//                                    case 5:
//                                        emp.setIdCard(cellValue);
//                                        break;
//                                    case 6:
//                                        emp.setWedlock(cellValue);
//                                        break;
//                                    case 7:
//                                        System.out.println("case 7====>"+new Nation(cellValue)+"   nations.size()====>"+nations.size());
//                                        int nationIndex = nations.indexOf(new Nation(cellValue));
//                                        emp.setNationId(nations.get(nationIndex).getId());
//                                        break;
//                                    case 8:
//                                        emp.setNativePlace(cellValue);
//                                        break;
//                                    case 9:
//                                        int psIndex = allPolitics.indexOf(new PoliticsStatus(cellValue));
//                                        emp.setPoliticId(allPolitics.get(psIndex).getId());
//                                        break;
//                                    case 10:
//                                        emp.setPhone(cellValue);
//                                        break;
//                                    case 11:
//                                        emp.setAddress(cellValue);
//                                        break;
//                                    case 12:
//                                        int depIndex = departments.indexOf(new Department(cellValue));
//                                        emp.setDepartmentId(departments.get(depIndex).getId());
//                                        break;
//                                    case 13:
//                                        int jlIndex = jobLevels.indexOf(new JobLevel(cellValue));
//                                        emp.setJobLevelId(jobLevels.get(jlIndex).getId());
//                                        break;
//                                    case 14:
//                                        int posIndex = positions1.indexOf(new Position(cellValue));
//                                        emp.setPosId(positions1.get(posIndex).getId());
//                                        break;
//                                    case 15:
//                                        emp.setEngageForm(cellValue);
//                                        break;
//                                    case 16:
//                                        emp.setTiptopDegree(cellValue);
//                                        break;
//                                    case 17:
//                                        emp.setSpecialty(cellValue);
//                                        break;
//                                    case 18:
//                                        emp.setSchool(cellValue);
//                                        break;
//                                    case 19:
//                                    case 20:
//                                        emp.setWorkState(cellValue);
//                                        break;
//                                    case 21:
//                                        emp.setEmail(cellValue);
//                                        break;
//                                }
//                            }
//                            break;
//                        }
//                    }
//                    emps.add(emp);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return emps;
//    }
}

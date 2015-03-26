package WebApp.Util;


import WebApp.Model.CourseMarks;
import WebApp.Model.StudentTabulation;
import WebApp.Model.StudentTabulationHeader;
import  java.io.*;
import  java.util.List;
import  org.apache.poi.hssf.usermodel.HSSFCell;
import  org.apache.poi.hssf.usermodel.HSSFCellStyle;
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;



/**
 *
 * @author Mithun
 */
public class Excel 
{
    public static String createTabulationSheet(StudentTabulationHeader studentTabulationHeader, List<StudentTabulation> studentTabulations,String realPath) throws FileNotFoundException, IOException
    {
        
        String filename=realPath+"//download//1tabulation.xls" ;
        File file = new File(filename);
        
        if(file.exists())
        {
            file.delete();
        }
          
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet =  workbook.createSheet("FirstSheet");
        
        HSSFCellStyle style = workbook.createCellStyle();
        
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setWrapText(true);
        
        HSSFCellStyle style_rotation = workbook.createCellStyle();
        style_rotation.setRotation((short) 90);
        style_rotation.setWrapText(true);
        
        HSSFCellStyle style1 = workbook.createCellStyle();
        style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style1.setRotation((short) 90);
        style1.setWrapText(true); 
         
        HSSFRow rowhead=   sheet.createRow((short)0);
        HSSFRow row1=   sheet.createRow((short)1);
        HSSFRow row2=   sheet.createRow((short)2);
        HSSFRow row3=   sheet.createRow((short)3);
        HSSFRow row4=   sheet.createRow((short)4);
        short s=0,s1=0,s3=500;
        rowhead.setHeight((short) 300);
        row1.setHeight((short) 600);
        row2.setHeight((short) 300);
        row3.setHeight((short) 900);
        row4.setHeight((short) 1400);
        
         HSSFCell cell1 []=null;
         cell1=new HSSFCell [20];
         int columnLength=0;
        
          for(int i=0;i<7;i++)//No Change,Same for all
         {
                HSSFCell cell=rowhead.createCell(s);
                if(i==0)
                {
                    cell.setCellValue("Name \n Of The \n Hall");
                    sheet.setColumnWidth((short) 0, (short) 4000);
                }
                     
                if(i==1)
                {
                    cell.setCellValue("Registration \n No.");
                    sheet.setColumnWidth((short) 1, (short) 5000);
                }
                if(i==2)
                {
                    cell.setCellValue("Session");
                    sheet.setColumnWidth((short) 2, (short) 3500);
                }
                if(i==3)
                {
                    cell.setCellValue("Class \n Roll \n No.");
                    sheet.setColumnWidth((short) 3, (short) 3000);
                }
                if(i==4)
                {
                    cell.setCellValue("Exam \n Roll \n No.");
                    sheet.setColumnWidth((short) 4, (short) 3000);
                }
                if(i==5)
                {
                    cell.setCellValue("Name \n Of \n Examinee");
                    sheet.setColumnWidth((short) 5, (short) 6000);
                }
                if(i==6)
                {
                    cell.setCellValue("Appearing\n Courses \n Nos.");
                    sheet.setColumnWidth((short) 6, (short) 9000);
                }
                cell.setCellStyle(style);
                Region rg=new Region();
                 rg.setColumnFrom((short) i);
                 rg.setColumnTo((short) i);
                 rg.setRowFrom(0);
                 rg.setRowTo(4);
                 sheet.addMergedRegion(rg);
                 s++;
                 columnLength++;
         }
        
         s=7;
         HSSFCell cell=rowhead.createCell(s);
         cell.setCellValue("Honours Courses and Grades");
         cell.setCellStyle(style);
         Region region=new Region();
         region.setColumnFrom((short) s);//from 7
         short length = (short)(7+studentTabulationHeader.getTheoryCourse()*5+studentTabulationHeader.getLabCourse()*3);
         region.setColumnTo((short) length);//7+coursenumber*5+labnumber*3
         region.setRowFrom(0);
         region.setRowTo(0);
         sheet.addMergedRegion(region);
                 
         s=7;
                 
         for(int i=0;i<studentTabulationHeader.getTheoryCourse();i++)//loop length course number(number of theory course on that semester)
         {
             
                 cell=row1.createCell(s);
                 cell.setCellValue(studentTabulationHeader.getTheory().get(i).getCourseCode());
                 cell.setCellStyle(style);
                 region.setColumnFrom((short) s);
                 region.setColumnTo((short) (s+4));
                 region.setRowFrom(1);
                 region.setRowTo(1);
                 sheet.addMergedRegion(region);
                 
                 cell=row2.createCell(s);
                 cell.setCellValue(studentTabulationHeader.getTheory().get(i).getCredit());
                 cell.setCellStyle(style);
                 region.setColumnFrom((short) s);
                 region.setColumnTo((short) (s+4));
                 region.setRowFrom(2);
                 region.setRowTo(2);
                 sheet.addMergedRegion(region);
                 
                 cell=row3.createCell(s);
                 cell.setCellValue(studentTabulationHeader.getTheory().get(i).getTitle());
                 cell.setCellStyle(style);
                 region.setColumnFrom((short) s);
                 region.setColumnTo((short) (s+4));
                 region.setRowFrom(3);
                 region.setRowTo(3);
                 sheet.addMergedRegion(region);
                 s+=5;
         }
         
          for(int i=0;i<studentTabulationHeader.getLabCourse();i++)//looplength labnumber(number of lab on that semester)
         {
                 cell=row1.createCell(s);
                 cell.setCellValue(studentTabulationHeader.getLab().get(i).getCourseCode());
                 cell.setCellStyle(style);
                 region.setColumnFrom((short) s);
                 region.setColumnTo((short) (s+2));
                 region.setRowFrom(1);
                 region.setRowTo(1);
                 sheet.addMergedRegion(region);
                 
                 cell=row2.createCell(s);
                 cell.setCellValue(studentTabulationHeader.getLab().get(i).getCredit());
                 cell.setCellStyle(style);
                 region.setColumnFrom((short) s);
                 region.setColumnTo((short) (s+2));
                 region.setRowFrom(2);
                 region.setRowTo(2);
                 sheet.addMergedRegion(region);
                 
                 cell=row3.createCell(s);
                 cell.setCellValue(studentTabulationHeader.getLab().get(i).getCredit());
                 cell.setCellStyle(style);
                 region.setColumnFrom((short) s);
                 region.setColumnTo((short) (s+2));
                 region.setRowFrom(3);
                 region.setRowTo(3);
                 sheet.addMergedRegion(region);
                 s+=3;
         }
         
         s1=s;
         s=6;
         for(int i=0;i<studentTabulationHeader.getTheoryCourse();i++)//loop length coursenumber
         {
             cell=row4.createCell(++s);
             cell.setCellValue("Internal \n Evaluation\n40");
             cell.setCellStyle(style1);
             cell=row4.createCell(++s);
             cell.setCellValue("Course Final\n60");
             cell.setCellStyle(style1);
             cell=row4.createCell(++s);
             cell.setCellValue("Total Marks\n100");
             cell.setCellStyle(style1);
             cell=row4.createCell(++s);
             cell.setCellValue("Grade");
             cell.setCellStyle(style1);
             cell=row4.createCell(++s);
             cell.setCellValue("Grade Point");
             cell.setCellStyle(style1);
             columnLength+=5;
         }
         for(int i=0;i<studentTabulationHeader.getLabCourse();i++)//loop length labnumber
         {
             cell=row4.createCell(++s);
             cell.setCellValue("Total Marks\n50");
             cell.setCellStyle(style1);
             cell=row4.createCell(++s);
             cell.setCellValue("Grade");
             cell.setCellStyle(style1);
             cell=row4.createCell(++s);
             cell.setCellValue("Grade Point");
             cell.setCellStyle(style1);
             columnLength+=3;
         }
         s++;
         Region rg;
         if(studentTabulationHeader.getSemister()==8)
         {
                cell=rowhead.createCell(s);
                cell.setCellValue("4th year\n2nd semester\nTotal\nWeighted\nGrade\nPoint\n"+studentTabulations.get(0).getCurrentTotalCredit()+"\nCredits");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("4th year\n2nd semester\nGrade Point \nAverage\n(SGPA)");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("4th year\n2nd semester\nTotal Marks");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                 rg.setColumnFrom((short) s);
                 rg.setColumnTo((short) s);
                 rg.setRowFrom(0);
                 rg.setRowTo(4);
                 sheet.addMergedRegion(rg);
                 s++;
                 columnLength++;
                 cell=rowhead.createCell(s);
         }
         else if(studentTabulationHeader.getSemister()==7)
         {
                cell=rowhead.createCell(s);
                cell.setCellValue("4th year\n1st semester\nTotal\nWeighted\nGrade\nPoint\n"+studentTabulations.get(0).getCurrentTotalCredit()+"\nCredits");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("4th year\n1st semester\nGrade Point \nAverage\n(SGPA)");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("4th year\n1st semester\nTotal Marks");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                 rg.setColumnFrom((short) s);
                 rg.setColumnTo((short) s);
                 rg.setRowFrom(0);
                 rg.setRowTo(4);
                 sheet.addMergedRegion(rg);
                 s++;
                 columnLength++;
                 cell=rowhead.createCell(s);
                
                
         }
         else  if(studentTabulationHeader.getSemister()==6)
         {
                cell=rowhead.createCell(s);
                cell.setCellValue("3rd year\n2nd semester\nTotal\nWeighted\nGrade\nPoint\n"+studentTabulations.get(0).getCurrentTotalCredit()+"\nCredits");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("3rd year\n2nd semester\nGrade Point \nAverage\n(SGPA)");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("3rd year\n2nd semester\nTotal Marks");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                 rg.setColumnFrom((short) s);
                 rg.setColumnTo((short) s);
                 rg.setRowFrom(0);
                 rg.setRowTo(4);
                 sheet.addMergedRegion(rg);
                 s++;
                 columnLength++;
                 cell=rowhead.createCell(s);
                
         }
         else if(studentTabulationHeader.getSemister()==5)
         {
                cell=rowhead.createCell(s);
                cell.setCellValue("3rd year\n1st semester\nTotal\nWeighted\nGrade\nPoint\n"+studentTabulations.get(0).getCurrentTotalCredit()+"\nCredits");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("3rd year\n1st semester\nGrade Point \nAverage\n(SGPA)");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("3rd year\n1st semester\nTotal Marks");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                 rg.setColumnFrom((short) s);
                 rg.setColumnTo((short) s);
                 rg.setRowFrom(0);
                 rg.setRowTo(4);
                 sheet.addMergedRegion(rg);
                 s++;
                 columnLength++;
                 cell=rowhead.createCell(s);
                
                
         }
         
         else  if(studentTabulationHeader.getSemister()==4)
         {
                cell=rowhead.createCell(s);
                cell.setCellValue("2nd year\n2nd semester\nTotal\nWeighted\nGrade\nPoint\n"+studentTabulations.get(0).getCurrentTotalCredit()+"\nCredits");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("2nd year\n2nd semester\nGrade Point \nAverage\n(SGPA)");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("2nd year\n2nd semester\nTotal Marks");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                 rg.setColumnFrom((short) s);
                 rg.setColumnTo((short) s);
                 rg.setRowFrom(0);
                 rg.setRowTo(4);
                 sheet.addMergedRegion(rg);
                 s++;
                 columnLength++;
                 cell=rowhead.createCell(s);
                
                
                       
         }
         else if(studentTabulationHeader.getSemister()==3)
         {
                cell=rowhead.createCell(s);
                cell.setCellValue("2nd year\n1st semester\nTotal\nWeighted\nGrade\nPoint\n"+studentTabulations.get(0).getCurrentTotalCredit()+"\nCredits");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("2nd year\n1st semester\nGrade Point \nAverage\n(SGPA)");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("2nd year\n1st semester\nTotal Marks");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                 rg.setColumnFrom((short) s);
                 rg.setColumnTo((short) s);
                 rg.setRowFrom(0);
                 rg.setRowTo(4);
                 sheet.addMergedRegion(rg);
                 s++;
                 columnLength++;
                 cell=rowhead.createCell(s);
                                    
         }
         else  if(studentTabulationHeader.getSemister()==2)
         {
                cell=rowhead.createCell(s);
                cell.setCellValue("1st year\n2nd semester\nTotal\nWeighted\nGrade\nPoint\n"+studentTabulations.get(0).getCurrentTotalCredit()+"\nCredits");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("1st year\n2nd semester\nGrade Point \nAverage\n(SGPA)");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("1st year\n2nd semester\nTotal Marks");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                 rg.setColumnFrom((short) s);
                 rg.setColumnTo((short) s);
                 rg.setRowFrom(0);
                 rg.setRowTo(4);
                 sheet.addMergedRegion(rg);
                 s++;
                 columnLength++;
                 cell=rowhead.createCell(s);
                          
         }
         
         else if(studentTabulationHeader.getSemister()==1)
         {
                cell=rowhead.createCell(s);
                cell.setCellValue("1st year\n1st semester\nTotal\nWeighted\nGrade\nPoint\n"+studentTabulations.get(0).getCurrentTotalCredit()+"\nCredits");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("1st year\n1st semester\nGrade Point \nAverage\n(SGPA)");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
                
                
                cell.setCellValue("1st year\n1st semester\nTotal Marks");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                cell.setCellStyle(style);
                rg=new Region();
                 rg.setColumnFrom((short) s);
                 rg.setColumnTo((short) s);
                 rg.setRowFrom(0);
                 rg.setRowTo(4);
                 sheet.addMergedRegion(rg);
                 s++;
                 columnLength++;
                 cell=rowhead.createCell(s);
              
                       
         }
         
         
         cell.setCellValue("Cumulative\nGrade Point\nAverage("+studentTabulations.get(0).getTotalCredit()+"credits)");//on that semester grade points
         sheet.setColumnWidth(s, (short) 3000);
                
         cell.setCellStyle(style);
        rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                 rg.setRowFrom(0);
                 rg.setRowTo(4);
                 sheet.addMergedRegion(rg);
                 s++;
                 columnLength++;
                 cell=rowhead.createCell(s);
                
                
                cell.setCellValue("Results");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                
                cell.setCellStyle(style);
                rg=new Region();
                 rg.setColumnFrom((short) s);
                 rg.setColumnTo((short) s);
                 rg.setRowFrom(0);
                 rg.setRowTo(4);
                 sheet.addMergedRegion(rg);
                 s++;
                 columnLength++;
                 cell=rowhead.createCell(s);
                
                
                cell.setCellValue("Exam\nRoll");//on that semester grade points
                    sheet.setColumnWidth(s, (short) 3000);
                
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                
                cell.setCellValue("Remarks");//on that semester grade points
                sheet.setColumnWidth(s, (short) 3000);
                
                cell.setCellStyle(style);
                rg=new Region();
                rg.setColumnFrom((short) s);
                rg.setColumnTo((short) s);
                rg.setRowFrom(0);
                rg.setRowTo(4);
                sheet.addMergedRegion(rg);
                s++;
                columnLength++;
                cell=rowhead.createCell(s);
        
          int studentNo=0;
          
          for(StudentTabulation studentTabulation : studentTabulations)
          {
              HSSFRow row= sheet.createRow((short) (studentNo+5));
              row.setHeight((short) 600);
              HSSFCell cell_value=row.createCell((short) 0);
              
              for(int j=0;j<columnLength;j++)
             {
                 if(j<7)
                 {
                    if(j==0)
                    {
                        cell_value.setCellValue(studentTabulation.getNameOfHall());
                    }
                    if(j==1)
                    {
                        cell_value=row.createCell((short) j);
                        cell_value.setCellValue(studentTabulation.getRegistration());//registration number
                       // sheet.setColumnWidth((short) 1, (short) 5000);
                    }
                    if(j==2)
                    {
                         cell_value=row.createCell((short) j);
                         cell_value.setCellValue(studentTabulation.getRegistrationSession());//session
                        //sheet.setColumnWidth((short) 2, (short) 3500);
                    }
                    if(j==3)
                    {
                         cell_value=row.createCell((short) j);
                        cell_value.setCellValue(studentTabulation.getDept_Roll());//class roll no
                        //sheet.setColumnWidth((short) 3, (short) 3000);
                    }
                    if(j==4)
                    {
                         cell_value=row.createCell((short) j);
                        cell_value.setCellValue(studentTabulation.getExamRoll());//exam roll no
                        //sheet.setColumnWidth((short) 4, (short) 3000);
                    }
                    if(j==5)
                    {
                         cell_value=row.createCell((short) j);
                        cell_value.setCellValue(studentTabulation.getName());//name
                       // sheet.setColumnWidth((short) 5, (short) 6000);
                    }
                    if(j==6)
                    {
                         cell_value=row.createCell((short) j);
                         String courseCode ="";
                         boolean flag =false;
                         for(CourseMarks courseMarks : studentTabulation.getTheory())
                         {
                              if(!flag)
                              {
                                  flag=true;
                                  courseCode +=courseMarks.getCourseCode();
                              }
                              else
                              {
                                courseCode +=","+courseMarks.getCourseCode();
                              }
                         }
                            cell_value.setCellValue(courseCode);
                         }
                    
                        cell_value.setCellStyle(style);
                    }
                   if(j==7)
                   {
                        for(int k=0;k<studentTabulationHeader.getTheoryCourse();k++)//loop length course number
                        {
                         
                                 cell_value=row.createCell((short) j);
                                 cell_value.setCellValue(studentTabulation.getTheory().get(k).getIncourseMarks());
                                 cell_value.setCellStyle(style);
                                 cell_value=row.createCell((short) ++j);
                                 cell_value.setCellValue(studentTabulation.getTheory().get(k).getFinalMarks());
                                 cell_value.setCellStyle(style);
                                 cell_value=row.createCell((short) ++j);
                                 cell_value.setCellValue(studentTabulation.getTheory().get(k).getIncourseMarks()+studentTabulation.getTheory().get(k).getFinalMarks());
                                 cell_value.setCellStyle(style);
                                 cell_value=row.createCell((short) ++j);
                                 cell_value.setCellValue(getGrade(studentTabulation.getTheory().get(k).getIncourseMarks()+studentTabulation.getTheory().get(k).getFinalMarks()));
                                 cell_value.setCellStyle(style);
                                 cell_value=row.createCell((short) ++j);
                                 cell_value.setCellValue(getPoint(studentTabulation.getTheory().get(k).getIncourseMarks()+studentTabulation.getTheory().get(k).getFinalMarks()));
                                 cell_value.setCellStyle(style);
                                 j++;
                        }
                    }
                   if(j==7+studentTabulationHeader.getTheoryCourse()*5)//condition 7+coursenumber*5
                    {
                        for(int k=0;k<studentTabulationHeader.getLabCourse();k++)//loop length lab number
                        {
                             cell_value=row.createCell((short) j);
                             cell_value.setCellValue(studentTabulation.getLab().get(k).getFinalMarks());
                             cell_value.setCellStyle(style);
                             cell_value=row.createCell((short) ++j);
                             cell_value.setCellValue(getGradeLab(studentTabulation.getLab().get(k).getFinalMarks()));
                             cell_value.setCellStyle(style);
                             cell_value=row.createCell((short) ++j);
                             cell_value.setCellValue(getPointLab(studentTabulation.getLab().get(k).getFinalMarks()));
                             cell_value.setCellStyle(style);
                             j++;
                        }
                    }
                   
                   if(j==7+studentTabulationHeader.getTheoryCourse()*5+studentTabulationHeader.getLabCourse()*3)//condition 7+coursenumber*5+labnumber*3
                    {
                       
                            cell_value=row.createCell((short) j);
                            cell_value.setCellValue(studentTabulation.getCurrentWeightedPoint());
                            j++;
                
                            cell_value=row.createCell((short) j);
                            cell_value.setCellValue(studentTabulation.getCurrentWeightedPoint()/studentTabulation.getCurrentTotalCredit());
                            j++;
                
                
                            cell_value=row.createCell((short) j);
                            cell_value.setCellValue(studentTabulation.getCurrentTotalMarks());
                            j++;
                
                      
         
                        cell_value=row.createCell((short) j);
                        cell_value.setCellValue(studentTabulation.getCgpa());
                        j++;
                        cell_value=row.createCell((short) j);
                       cell_value.setCellValue(studentTabulation.getExamRoll());
                       j++;
                       cell_value=row.createCell((short) j);
                       
                       if(studentTabulation.getCgpa()>=2.0)
                                  cell_value.setCellValue("Passed");
                       else
                           cell_value.setCellValue("Failed");
                       j++;
                       j=46;
                    }
                 
                 
                     
                 }
                 
              studentNo++;
          }
        FileOutputStream fileOut =  new FileOutputStream(file);
        workbook.write(fileOut);
        fileOut.close();
        
        return filename;
    }
    
    public static String getGrade(double mark)
    {
        if(mark>=80)
        {
            return "A+";
        }
        else if(mark>=75)
        {
            return "A";
        }
        else if(mark>=70)
        {
            return "A-";
        }
        else if(mark>=65)
        {
            return "B+";
        }
        else if(mark>=60)
        {
            return "B";
        }
        else if(mark>=55)
        {
            return "B-";
        }
        else if(mark>=50)
        {
            return "C+";
        }
        else if(mark>=45)
        {
            return "C";
        }
        else if(mark>=40)
        {
            return "D";
            
        }
        
       return "F";     
    }
    public static double getPoint(double mark)
    {
        
        if(mark>=80)
            return 4.0;
        else if(mark>=75)
            return 3.75;
        else if(mark>=70)
            return 3.5;
        else if(mark>=65)
            return 3.25;
        else if(mark>=60)
            return 3.0;
        else if(mark>=55)
            return 2.75;
        else if(mark>=50)
            return 2.50;
        else if(mark>=45)
            return 2.25;
        else if(mark>=40)
            return 2.0;
        else
            return 0.0;
            
            
    }
    public static String getGradeLab(double mark)
    {
        if(mark*2>=80)
        {
            return "A+";
        }
        else if(mark*2>=75)
        {
            return "A";
        }
        else if(mark*2>=70)
        {
            return "A-";
        }
        else if(mark*2>=65)
        {
            return "B+";
        }
        else if(mark*2>=60)
        {
            return "B";
        }
        else if(mark*2>=55)
        {
            return "B-";
        }
        else if(mark*2>=50)
        {
            return "C+";
        }
        else if(mark*2>=45)
        {
            return "C";
        }
        else if(mark*2>=40)
        {
            return "D";
            
        }
        
       return "F";     
    }
    public static double getPointLab(double mark)
    {
        
        if(mark*2>=80)
            return 4.0;
        else if(mark*2>=75)
            return 3.75;
        else if(mark*2>=70)
            return 3.5;
        else if(mark*2>=65)
            return 3.25;
        else if(mark*2>=60)
            return 3.0;
        else if(mark*2>=55)
            return 2.75;
        else if(mark*2>=50)
            return 2.50;
        else if(mark*2>=45)
            return 2.25;
        else if(mark*2>=40)
            return 2.0;
        else
            return 0.0;
            
            
    }


}

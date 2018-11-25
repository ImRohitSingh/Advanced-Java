
package myPackage;

import java.io.Serializable;

/**
 *
 * @author Rohit
 */
public class Student implements Serializable
{
    int empId;
    String empName;
    float marks1, marks2, marks3;
    
    public Student(){}
    
    public int getEmpId()
    { 
        return empId; 
    }
    public void setEmpId(int empId){ this.empId = empId; }
    
    public String getEmpName(){ return empName; }
    public void setEmpName(String empName){ this.empName = empName; }
    
    public float getMarks1(){ return marks1; }
    public void setMarks1(float marks1){ this.marks1 = marks1; }
    
    public float getMarks2(){ return marks2; }
    public void setMarks2(float marks2){ this.marks2 = marks2; }
    
    public float getMarks3(){ return marks3; }
    public void setMarks3(float marks3){ this.marks3 = marks3; }
    
    public float average(){ return ( marks1 + marks2 +marks3 )/3; }
}

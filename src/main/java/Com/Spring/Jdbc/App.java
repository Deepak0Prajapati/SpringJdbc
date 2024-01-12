package Com.Spring.Jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(jdbcConfig.class);
        studentdaoimpl template = context.getBean("studentdao",studentdaoimpl.class);
        Scanner sc=new Scanner(System.in);
        
        System.out.println("*********** Student database managenent ***********");
        while(true) {
        	extracted();
        	
        	int Choice = 0;
        	try {
        		Choice=Integer.parseInt(sc.next());
        	}catch (Exception e) {
//        		System.out.println("invalid Input!!");
				// TODO: handle exception
			}
        	    	
        	switch(Choice) {
        	case 1: System.out.println("enter name of the student");
        			student s=new student();
        			s.setName(sc.next());
        			System.out.println("enter id of student");
        			s.setId(sc.nextInt());
        			System.out.println("enter city of student");
        			s.setAddress(sc.next());
        			int insert = template.insert(s);
        			System.out.println(" Rows Inserted:"+insert);
        			break;
        	case 2: 	System.out.println("enter id of student  you want to update");
						student s1=new student();
        				s1.setId(sc.nextInt());
        				System.out.println("enter new name");
            			s1.setName(sc.next());
            			System.out.println("enter new City");
            			s1.setAddress(sc.next());
            			
            			int update = template.change(s1);
            			if (update>=1) {
            				System.out.println("Row updated:" +update);
							
						}
            			else {
							System.out.println("Incorrect Id entered");
						}
            			break;
        	case 3: System.out.println("All student in DataBase....");
					List<student> std2 = template.getAll();
					for (student student : std2) {
					System.out.println("ID:"+student.getId());
					System.out.println("Name:"+student.getName());
					System.out.println("City:"+student.getAddress());
					System.out.println("*******************************");
			}
        			
        			System.out.println("Enter the Id of Student You want to delete!");
        			
        			int delete = template.delete(sc.nextInt());
        			if(delete>=1) {
        				System.out.println("Rows Deleted:"+delete);	
        			}else {
						System.out.println("Incorrect Value entered!!");
					}
        		
        			
        			
        			break;
        			
        	case 4:System.out.println("All student in DataBase....");
			 	   List<student> std1 = template.getAll();
			 	   for (student student : std1) {
			 	   System.out.println("ID:"+student.getId());
			 	   System.out.println("Name:"+student.getName());
			 	   System.out.println("City:"+student.getAddress());
			 	   System.out.println("*******************************");
			 	   } 
        		
        		    System.out.println("enter the id of student you wenat to view!!");
        			student getstudent = template.getstudent(sc.nextInt());
        			System.out.println(getstudent);
        			break;
        			
        	case 5: System.out.println("All student in DataBase....");
        			List<student> std = template.getAll();
        			for (student student : std) {
						System.out.println("ID:"+student.getId());
						System.out.println("Name:"+student.getName());
						System.out.println("City:"+student.getAddress());
						System.out.println("*******************************");
					}
        			break;
        			
        	case 6: System.out.println("Thankyou for using management System!!");
        	        System.exit(0);
        	        break;
        	        
        	default: System.out.println("Invalid Input, Pleaase choose from the option Given Below:");
        	
        			
        			
        		
            			

        				
        	
        	}
        	
        }
  		
    }

	private static void extracted() {
		System.out.println("What you would like to do...");
		System.out.println("1. insert data of a student.");
		System.out.println("2. update data of a student.");
		System.out.println("3. delete data of a student.");
		System.out.println("4. view data of a student.");
		System.out.println("5. view data of all student.");
		System.out.println("6. Exit the Program");
	}
}

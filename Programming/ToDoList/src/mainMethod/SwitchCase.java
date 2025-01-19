package mainMethod;
import java.sql.SQLException;
import java.util.Scanner;
public class SwitchCase {
	Scanner sc=new Scanner(System.in);
	TaskBL ob = new TaskBL();
	
	public void sw() throws ClassNotFoundException, SQLException
	{
		while(true) {
		System.out.println("Choose Operations, you want!");
		System.out.println("press 1, to create task");
		System.out.println("press 2, to Update task");
		System.out.println("press 3, to View Previous task");
		System.out.println("press 4, to Delete task");
		System.out.println("press 0, for Exit ");
		
		int ch=sc.nextInt();
		if(ch==0) {
			System.out.println("application is closed.");
			System.out.println("Thanks for visiting");
			break;
		}
	switch(ch)
	{
	case 1:{
		ob.addAll();
		break;
	}
	case 2:{
		while(true) {
		System.out.println("press 1, to Update task");
		System.out.println("press 2, to Update Status");
		System.out.println("press 3, to Update both");
		System.out.println("press 0, for Exit ");
		int ch1 = sc.nextInt();
		if(ch1==0) {
			System.out.println("return to main menu");
			break;
		}
		switch(ch1) {
		case 1: {
			ob.updTask();
			break;
		}
		case 2: {
			ob.updStatus();
			break;
		}
		case 3: {
			ob.update();
			break;
		}
		default:System.out.println("invalid number");
		}
		}
		break;
	}
	case 3:{
		ob.view();
		break;
	}
	case 4:{
		ob.delete();
		break;
	}
	default:System.out.println("invalid number");

	}
	
	}
	}

}

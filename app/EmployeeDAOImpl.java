package MyPackage.app;
import MyPackage.config.HibernateUtils;
import MyPackage.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAOImpl {
    public static void main(String[] args) throws Exception {
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        // Enter 10 employee details
        Transaction tx = session.beginTransaction();
        Scanner sc = new Scanner(System.in);
        Boolean req = true;
//        while (req.equalsIgnoreCase("Y")) {
        while (req) {
            System.out.println("enter ename");
            String ename = sc.nextLine();
            System.out.println("enter basic");
            int basic = Integer.parseInt(sc.nextLine());
            System.out.println("enter HRA");
            int HRA = Integer.parseInt(sc.nextLine());
            System.out.println("enter DA");
            int DA = Integer.parseInt(sc.nextLine());
            System.out.println("Deductions");
            int Deductions = Integer.parseInt(sc.nextLine());
            MyPackage.domain.Employee st = new MyPackage.domain.Employee(ename, basic, HRA, DA, Deductions);
            session.save(st);
            System.out.println("Do you want to add new student [true/false]? ");
            String userInput = sc.nextLine();
            req = Boolean.parseBoolean(userInput);
        }
        System.out.println("----------------------------");
        tx.commit();
//        session.close();
        // Calculate Salary of Employee "John Marquee"
//        session = sf.openSession();
        ApplicationContext context = new ClassPathXmlApplicationContext("MyPackage/config/context.xml");
        Employee employee = context.getBean("employee", Employee.class);
        org.hibernate.Query query = session.createQuery("from Employee where ename=:employee");
        query.setParameter("employee", employee.getEname());
        List <Employee> employeeList = query.list();
        for (Employee e : employeeList) {
            int Gross_Salary = e.getBasic() + e.getDA() + e.getHRA();
            int Net_Salary = Gross_Salary - (((15 * Gross_Salary) / 100) + e.getDeductions());
            System.out.println("Net Salary of Employee " + e.getEname() + " is " + Net_Salary);
        }
        System.out.println("----------------------------");
        session.close();
        // Display employee Records
        session = sf.openSession();
        TypedQuery <Employee> employeeTypedQueryquery = session.createQuery("from MyPackage.domain.Employee");
        List <Employee> employees = employeeTypedQueryquery.getResultList();
        for (Employee employeelist : employees) {
            System.out.println(employeelist);
        }
        System.out.println("----------------------------");
        session.close();
        sf.close();
    }
}

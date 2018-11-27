package MyPackage.domain;
public class Employee {
    private int empid;
    private String ename;
    private int basic;
    private int HRA;
    private int DA;
    private int deductions;
    public int getEmpid() {
        return empid;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public int getBasic() {
        return basic;
    }
    public void setBasic(int basic) {
        this.basic = basic;
    }
    public int getHRA() {
        return HRA;
    }
    public void setHRA(int hRA) {
        HRA = hRA;
    }
    public int getDA() {
        return DA;
    }
    public void setDA(int dA) {
        DA = dA;
    }
    public int getDeductions() {
        return deductions;
    }
    public void setDeductions(int deductions) {
        this.deductions = deductions;
    }
    public Employee() {
        super();
    }

    public Employee(String ename, int basic, int HRA, int DA, int deductions) {
        this.ename = ename;
        this.basic = basic;
        this.HRA = HRA;
        this.DA = DA;
        this.deductions = deductions;
    }

    public Employee(String ename) {
        this.ename = ename;
    }

    public Employee(int empid, String ename, int basic, int hRA, int dA, int deductions) {
        super();
        this.empid = empid;
        this.ename = ename;
        this.basic = basic;
        HRA = hRA;
        DA = dA;
        this.deductions = deductions;
    }
    @Override
    public String toString() {
        return "Employee [empid=" + empid + ", ename=" + ename + ", basic=" + basic + ", HRA=" + HRA + ", DA=" + DA
                + ", deductions=" + deductions + "]";
    }
}


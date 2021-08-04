import java.io.Serializable;
import java.util.Comparator;
import java.util.Scanner;

public class Student implements Serializable {
    private String name;
    private String phone;
    private String specialized;
    private int born;

    Student() {
    }

    Student(String name, String phone, int born, String specialized) {
        this.name = name;
        this.phone = phone;
        this.born = born;
        this.specialized = specialized;
    }

    public int getBorn() {
        return born;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setBorn(int born) {
        this.born = born;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    public void fillDataStudent() {
        Scanner sc = new Scanner(System.in);
        String name, specialized, phone;
        int age;
        System.out.println("Nhap ten sinh vien: ");
        name = sc.nextLine();
        setName(name);
        System.out.println("Nhap chuyen nganh: ");
        specialized = sc.nextLine();
        setSpecialized(specialized);
        System.out.println("Nhap nam sinh: ");
        age = sc.nextInt();
        setBorn(age);
        sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        phone = sc.nextLine();
        setPhone(phone);
    }

    public String toString() {
        return "Ten: " + this.name + ", SDT: " + this.phone + ", nganh hoc: " + this.specialized;
    }

    static Comparator<Student> sortByName = new Comparator<Student>() {
        @Override
        public int compare(Student obj1, Student obj2) {
            return obj1.name.compareTo(obj2.name);
        }
    };
    static Comparator<Student> sortByAge = new Comparator<Student>() {
        public int compare(Student obj1, Student obj2) {
            return obj1.born - obj2.born;
        }
    };
    static Comparator<Student> sortBySDT = new Comparator<Student>() {
        public int compare(Student obj1, Student obj2) {
            return obj1.phone.compareTo(obj2.phone);
        }
    };
}

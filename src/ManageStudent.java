
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ManageStudent {
    ArrayList<Student> students;;

    public void init() {
        students = new ArrayList<>();
    }

    public int findByPhone(Student temp) {
        if (students.isEmpty())
            return 1;
        for (Student i : students)
            if (temp.getPhone().equals(i.getPhone()))
                return 0;
        return 1;
    }

    public void addStudent(Student temp) {
        if (findByPhone(temp) == 1)
            students.add(temp);
        else
            System.out.println("Sinh vien da ton tai");
    }

    public void fixStudent(int position) {
        if (position > 0 && position <= students.size()) {
            position -= 1;
            Scanner sc = new Scanner(System.in);
            int choose = 0;
            while (choose != 5) {
                System.out.println("1. Sua ten");
                System.out.println("2. Sua so dien thoai");
                System.out.println("3. Sua chuyen nganh");
                System.out.println("4. Sua nam sinh");
                System.out.println("5. Thoat");
                System.out.println("Moi chon");
                choose = sc.nextInt();
                switch (choose) {
                    case 1:
                        sc.nextLine();
                        System.out.println("Nhap ten moi: ");
                        students.get(position).setName(sc.nextLine());
                        break;
                    case 2:

                        sc.nextLine();
                        System.out.println("Nhap so dien thoai moi: ");
                        students.get(position).setPhone(sc.nextLine());
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("Nhap nganh moi: ");
                        students.get(position).setSpecialized(sc.nextLine());
                        break;
                    case 4:
                        sc.nextLine();
                        System.out.println("Nhap nam sinh moi: ");
                        students.get(position).setBorn(sc.nextInt());
                        break;
                    default:
                        break;
                }
            }
        } else {
            System.out.println("Sinh vien khong co trong danh sach");
        }
    }

    public void deleteStudent(int position) {
        if (position >= 0 && position <= students.size()) {
            students.remove(position - 1);
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Sinh vien khong co trong danh sach!");
        }
    }

    public void printList() {
        System.out.println("---Danh sach sinh vien---");
        for (Student i : students)
            System.out.println(i.toString());
    }

    public void sortByName() {
        Collections.sort(students, Student.sortByName);
        System.out.println("Danh sach da sap xep theo ten");
        printList();
    }

    public void sortByAge() {
        Collections.sort(students, Student.sortByAge);
        System.out.println("Danh sach da sap xep theo tuoi");
        printList();
    }

    public void sortByPhone() {
        Collections.sort(students, Student.sortBySDT);
        System.out.println("Danh sach da sap xep theo so dien thoai");
        printList();
    }

    public void chooseSort() {
        int choose = 0;
        Scanner sc = new Scanner(System.in);
        while (choose != 4) {
            System.out.println("1. Sap xep theo ten");
            System.out.println("2. Sap xep theo nam sinh");
            System.out.println("3. Sap xep theo so dien thoai");
            System.out.println("4. Thoat");
            System.out.println("Moi chon: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    sortByName();
                    break;
                case 2:
                    sortByAge();
                    break;
                case 3:
                    sortByPhone();
                    break;
                default:
                    break;
            }
        }
    }

    public void filterBySpecialized() {
        System.out.println("Danh sach sinh vien dai hoc");
        for (Student i : students) {
            if (i.getSpecialized().equalsIgnoreCase("dai hoc"))
                System.out.println(i.toString());
        }
        System.out.println("Danh sach sinh vien cao dang");
        for (Student i : students) {
            if (i.getSpecialized().equalsIgnoreCase("cao dang"))
                System.out.println(i.toString());
        }
    }

    public void searchKey() {
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        int age = 0;
        String find;
        while (choose != 5) {
            System.out.println("1. Tim theo ten");
            System.out.println("2. Tim theo so dien thoai");
            System.out.println("3. Tim theo nganh");
            System.out.println("4. Tim theo nam sinh");
            System.out.println("5. Thoat");
            System.out.println("Moi chon");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    sc.nextLine();
                    System.out.println("Nhap ten can tim: ");
                    find = sc.nextLine();
                    System.out.println("Danh sach ten can tim: ");
                    for (Student i : students) {
                        if (i.getName().contains(find))
                            System.out.println(i.toString());
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Nhap so dien thoai can tim: ");
                    find = sc.nextLine();
                    System.out.println("Danh sach so dien thoai can tim: ");
                    for (Student i : students) {
                        if (i.getPhone().contains(find))
                            System.out.println(i.toString());
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Nhap nganh can tim: ");
                    find = sc.nextLine();
                    System.out.println("Danh sach nganh can tim: ");
                    for (Student i : students) {
                        if (i.getSpecialized().contains(find))
                            System.out.println(i.toString());
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.println("Nhap nam sinh can tim: ");
                    age = sc.nextInt();
                    System.out.println("Danh sach nam sinh can tim: ");
                    for (Student i : students) {
                        if (i.getBorn() == age)
                            System.out.println(i.toString());
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void menu() {
        int choose = 0;
        int position = 0;
        Scanner sc = new Scanner(System.in);
        while (choose != 8) {
            System.out.println("1. Them sinh vien");
            System.out.println("2. Sua sinh vien");
            System.out.println("3. Xoa sinh vien");
            System.out.println("4. Hien danh sach sinh vien");
            System.out.println("5. Sap xep danh sach sinh vien");
            System.out.println("6. Loc sinh vien");
            System.out.println("7. Tim theo keyword");
            System.out.println("8. Thoat");
            System.out.println("Moi chon chuc nang: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    sc.nextLine();
                    Student a = new Student();
                    a.fillDataStudent();
                    addStudent(a);
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Nhap thu tu sinh vien can sua thong tin");
                    position = sc.nextInt();
                    fixStudent(position);
                    break;
                case 3:
                    System.out.println("Nhap thu tu sinh vien can xoa");
                    position = sc.nextInt();
                    sc.nextLine();
                    deleteStudent(position);
                    break;
                case 4:
                    printList();
                    sc.nextLine();
                    break;
                case 5:
                    chooseSort();
                    sc.nextLine();
                    break;
                case 6:
                    filterBySpecialized();
                    break;
                case 7:
                    searchKey();
                    sc.nextLine();
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ManageStudent manage = new ManageStudent();
        manage.init();
        manage.menu();
    }
}

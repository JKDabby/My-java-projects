package pmqlks;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
class doan implements Serializable{
	int doan;
	int soluong;
	int tinhtien;
	doan(int doan, int soluong){
		this.doan = doan;
		this.soluong = soluong;
		if(doan == 1) {
			this.tinhtien =  soluong * 12000;
		}
		else {
			this.tinhtien =  soluong * 35000;
		}
	}
}
class phongdon implements Serializable{
	String ten;
	String gioitinh;
	String sodienthoai;
	ArrayList<doan> doan = new ArrayList<>();
	phongdon(){
		ten ="";
	}
	phongdon(String ten,String gioitinh,String Sodienthoai){
		this.ten = ten;
		this.gioitinh = gioitinh;
		this.sodienthoai = Sodienthoai;
	}
}
class phongdoi extends phongdon implements Serializable{
		String ten2;
		String gioitinh2;
		String sodienthoai2;
	phongdoi(){
		ten = "";
		ten2 = "";
	}
	phongdoi(String ten, String ten2, String gioitinh, String gioitinh2, String sodienthoai, String sodienthoai2){
		this.ten = ten;
		this.ten2 = ten2;
		this.gioitinh = gioitinh;
		this.gioitinh = gioitinh2;
		this.sodienthoai = sodienthoai;
		this.sodienthoai2 = sodienthoai2;
	}
}
class phongkara implements Serializable{
		String ten;
		String sdt;
		int sotieng;
		ArrayList<doan> doan = new ArrayList<>();
	phongkara(){
		ten="";
	}
	phongkara(String ten, String sdt, int sotieng){
		this.ten = ten;
		this.sdt = sdt;
		this.sotieng = sotieng;
		
	}
}
class notavalible extends Exception{
	public String toString()
    {
        return "Not Available !";
    }
}
class sophong implements Serializable{
	phongdon phongd[] = new phongdon[20];
	phongdon phongdd[] = new phongdoi[20];
	phongkara phongkaraoke[] = new phongkara[10];
}
class dvkhachsan{
	 static sophong hotel_room = new sophong();
	 static Scanner luachonit = new Scanner(System.in);
	 static Scanner luachonst = new Scanner(System.in);
	 static int i;
	 static void ttkhachhang(int i, int f) {
		 String ten;
		 String gioitinh;
		 String sodienthoai;
		 System.out.println("Ten nguoi dat: ");
		 ten = luachonst.nextLine();
		 System.out.println("Gioi tinh: ");
		 gioitinh = luachonst.nextLine();
		 System.out.println("\nSo dien thoai: ");
		 sodienthoai = luachonst.nextLine();
		 if(i == 1){
			 hotel_room.phongd[f-1] = new phongdon(ten,gioitinh,sodienthoai);
		 }
		 else if(i == 2){
			 String ten2;
			 String gioitinh2;
			 String sodienthoai2;
			 System.out.println("Ten nguoi dat thu 2: ");
			 ten2 = luachonst.nextLine();
			 System.out.println("Gioi tinh: ");
			 gioitinh2 = luachonst.nextLine();
			 System.out.println("So dien thoai: ");
			 sodienthoai2 = luachonst.nextLine();
			 hotel_room.phongdd[f-21] = new phongdoi(ten,ten2,gioitinh,gioitinh2,sodienthoai,sodienthoai2);
		 }
		 else{
			 System.out.println("Ban muon su dung may tieng: ");
			 int gio = luachonit.nextInt();
			 hotel_room.phongkaraoke[f-41] = new phongkara(ten,sodienthoai,gio);
		 }
		 System.out.println("Dat phong thanh cong. ");
	 }
	 static void datphong() {
		 int t = 0; 
		 System.out.println("Ban muon dat dang phong nao :\n1.Phong don\n2.Phong doi\n3.Phong karaoke");
		 i = luachonit.nextInt();
		 if(i == 1){
			 System.out.print("Cac phong ban co the dat: ");
			 while(t < 20){
				 if(hotel_room.phongd[t] == null) System.out.print(t+1+",");
				 t++;
			 }
			 try{
			 System.out.print("\nBan muon dat phong nao: ");
			 t = luachonit.nextInt();
			 if(hotel_room.phongd[t-1] != null){
				 throw new notavalible();
			 	}
			 ttkhachhang(i,t);
			 }
			 catch(Exception e){
				 System.out.println("Loi nhap du lieu vao.");
			 }
		 }
		 else if(i == 2) {
			 System.out.print("Cac phong ban co the dat: ");
			 while(t < 20){
				 if(hotel_room.phongdd[t] == null) System.out.print(t+21+",");
				 t++;
			 }
			 try {
			 System.out.print("\nBan muon dat phong nao: ");
			 t = luachonit.nextInt();
			 if(hotel_room.phongdd[t-21] != null) throw new notavalible();
			 ttkhachhang(i,t);
			 }
			 catch(Exception e){
				 System.out.println("Loi nhap du lieu vao.");
			 }
			 
		 }
		 else{
			 System.out.print("Cac phong ban co the dat: ");
			 while(t < 10){
				 if(hotel_room.phongkaraoke[t] == null) System.out.print(t+41+",");
				 t++;
			 }
			 try{
			 System.out.print("\nBan muon dat phong nao: ");
			 t = luachonit.nextInt();
			 if(hotel_room.phongkaraoke[t-41] != null) throw new notavalible();
			 ttkhachhang(i,t);
			 }
			 catch(Exception e){
				 System.out.println("Loi nhap du lieu vao.");
			 }
		 }
	 }
	 static void traphong(int t){
		 int tongtien = 0;
		 int tiendoan = 0;
		 try{
		 if(t<=20){
			 tongtien+=200000;
			 if(hotel_room.phongd[t-1] != null) {
				 System.out.print("Cac chi phi: \n1.Phi Phong: 200000 \n2.Phi do an: ");
				 for(doan dulieu : hotel_room.phongd[t-1].doan) {
					 tiendoan = tiendoan + dulieu.tinhtien;
				 }
				 hotel_room.phongd[t-1] = null;
			 }
			 else {
				 System.out.println("Phong chua dat ne khong the tra phong! ");
			 }
		 }
		 else if(t<=40){
			 tongtien+=350000;
			 if(hotel_room.phongdd[t-21] != null) {
				 System.out.print("Cac chi phi: \n1.Phi Phong: 350000 \n2.Phi do an: ");
				 for(doan dulieu : hotel_room.phongdd[t-21].doan) {
					 tiendoan = tiendoan + dulieu.tinhtien;
				 }
				 hotel_room.phongdd[t-21] = null;
			 }
			 else {
				 System.out.println("Phong chua dat ne khong the tra phong! ");
			 }
		 }
		 else{
			 tongtien+=150000;
			 if(hotel_room.phongkaraoke[t-41] != null) {
				 System.out.print("Cac chi phi: \n1.Phi Phong: 150000 \n2.Phi do an: ");
				 for(doan dulieu : hotel_room.phongkaraoke[t-41].doan) {
					 tiendoan = tiendoan + dulieu.tinhtien;
				 }
				 hotel_room.phongkaraoke[t-41] = null;
			 }
			 else System.out.println("Phong chua dat ne khong the tra phong! ");
		 }
		 System.out.println(tiendoan);
		 System.out.println("Tong cong: "+(tongtien+tiendoan));
		 }
		 catch(NullPointerException e) {
			 System.out.println("Loi o tra phong.");
		 }
	 }
	 static void datdoan(int i){
		 char f;
		 try{
		 do{
		 System.out.println("Menu do an: \n1.Banh mi cha lua\n2.Com suon nuong\nLua chon: ");
		 int da = luachonit.nextInt();
		 if(da == 2 || da == 1){
			 System.out.println("So luong: ");
			 int sl = luachonit.nextInt();
			 if(i <= 20 && hotel_room.phongd[i-1] != null) hotel_room.phongd[i-1].doan.add(new doan(da,sl));
			 else if(i <= 40 && hotel_room.phongdd[i-21] != null) hotel_room.phongdd[i-21].doan.add(new doan(da,sl));
			 else hotel_room.phongkaraoke[i-41].doan.add(new doan(da,sl));
		 }
		 else {
			 System.out.println("Thong tin nhap khong chinh xac.");
		 }
			 System.out.print("Ban co muon dat tiep(Y/N): ");
			 f = luachonst.next().charAt(0);
		 }while(f == 'y' || f == 'Y');
		 }
		 catch(Exception e){
			 System.out.println("Phong chua duoc dat.");
		 	}
	 }
	 static void tinhtrangp(){
		 int t = 0;
		 System.out.print("Cac phong con trong: \n1.Phong Don ");
		 while(t<20){
			 if(hotel_room.phongd[t] == null) System.out.print(t+1+", ");
			 t++;
		 }
		 System.out.print("\n2.Phong Doi: ");
		 while(t<40){
			 if(hotel_room.phongdd[t-20] == null) System.out.print(t+1+", ");
			 t++;
		 }
		 System.out.print("\n3.Phong Karaoke: ");
		 while(t<50){
			 if(hotel_room.phongkaraoke[t-40] == null) System.out.print(t+1+", ");
			 t++;
		 }
		 System.out.print("\n");
	 }
	 static void mieutap(){
		 int t;
		 System.out.println("Ban muon xem mieu ta ve dang phong nao: \n1.Phong Don\n2.Phong Doi\n3.Phong Karaoke");
		 t = luachonit.nextInt();
		 if(t == 1){
			 System.out.println("Phong don co cac dich vu:\n1.An sang mien phi deo can tra so tien lon phai tra\n2.Su dung ho boi\n3.Giat quan ao mien phi\n4.Phong co may lanh\nGia : 200000d/phong\n");
		 }
		 else if(t == 2) {
			 System.out.println("Phong don co cac dich vu:\n1.An sang mien phi\n2.Su dung ho boi\n3.Giat quan ao mien phi\n4.Phong co may lanh\nGia : 350000d/phong\n");
		 }
		 else {
			 System.out.println("Phong don co cac dich vu:\n1.Nuoc uong mien phi\n2.Phong co may lanh\n3.He thong lua chon bai hat da dang\nGia : 150000d/phong\n");
		 }
	 }
	 static void hotro() {
		 System.out.println("Ban co the lien he voi cac so sau de duoc ho tro: \n1.Bo phan ho tro khan cap: 0836187812\n2.Goi do an: 0911327728\n3.Bo phan tiep tan: 01236187812\n");
	 }
}
class write implements Runnable{
	sophong hotel_room;
	write(sophong hotel_room){
		this.hotel_room = hotel_room;
	}
	public void run() {
		try{
			FileOutputStream f = new FileOutputStream("dulieuqlks");
			ObjectOutputStream obb = new ObjectOutputStream(f);
			obb.writeObject(hotel_room);
	}
	catch(Exception e){
		System.out.println("Loi luu du lieu.");
		}
	}
}
public class QuanLyKhachSan2{
	public static void main(String agrs[]){
	File khachsan = new File("dulieuqlks");
	if(khachsan.exists())
	{	
	try {
	FileInputStream fghi = new FileInputStream(khachsan);
	ObjectInputStream Oghi = new ObjectInputStream(fghi);
	dvkhachsan.hotel_room = (sophong)Oghi.readObject();
	}
	catch(Exception e){
			System.out.println("Loi nhap du lieu.");
		}
	}
	try{
	Scanner luachonit = new Scanner(System.in);
	Scanner luachonst = new Scanner(System.in);
	int i,t,gda = 0;
	char ve;
	do{
	System.out.println("Dich vu dat phong online Dabby: \n1.Dat phong\n2.Tra phong\n3.Dat do an\n4.Xem tinh trang phong\n5.Mieu ta phong\n6.Ho tro khan cap\n7.Thoat chuong  trinh");
	i = luachonit.nextInt();
	if(i == 1) 
	{
		dvkhachsan.datphong();
	}
	else if(i == 2) 
	{
		System.out.println("Phong ban muon tra: ");
		if((t = luachonit.nextInt()) <= 50) dvkhachsan.traphong(t);
		else System.out.println("Phong khong kha dung: ");
	}
	else if(i == 3) 
	{
		System.out.println("Phong ban muon dat: ");
		if((t = luachonit.nextInt()) <= 50) dvkhachsan.datdoan(t);
		else System.out.println("Phong khong kha dung: ");
	}
	else if(i == 4)
	{
		dvkhachsan.tinhtrangp();
	}
	else if(i == 5)
	{
		dvkhachsan.mieutap();
	}
	else if(i == 6)
	{
		dvkhachsan.hotro();
	}
	else if(i == 7)
	{
		System.out.println("Tam biet ban.");
		break;
	}
	else{
		System.out.println("Yeu cau khong kha thi");
	}
	System.out.print("Tro ve trang chu(Y/N): ");
	ve = luachonst.next().charAt(0);
	while(!(ve == 'y' || ve == 'Y' || ve == 'n' || ve == 'N')) {
		System.out.println("Du lieu khong phu hop.");
		ve = luachonst.next().charAt(0);
		}
	}
	while(ve == 'y' || ve == 'Y');
	Thread f = new Thread(new write(dvkhachsan.hotel_room));
	f.start();
	}
	catch(Exception e){
		System.out.printf("Chuong trinh bi loi.");
		}
	}
}

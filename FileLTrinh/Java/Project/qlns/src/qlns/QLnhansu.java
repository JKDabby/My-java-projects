package qlns;

import java.io.File;
import java.util.Scanner;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

class thongtinnv implements Serializable{
	 String ten;
	 String ngaysinh;
	 String cccd;
	 String chucvu;
	thongtinnv(){
		this.ten ="";
	}
	thongtinnv(String ten, String ngaysinh, String cccd, int i){
		this.ten = ten;
		this.ngaysinh = ngaysinh;
		this.cccd = cccd;
		if(i == 1) this.chucvu = "Giam Doc";
		else if(i == 2) this.chucvu = "Pho Giam Doc";
		else if(i == 3) this.chucvu = "Truong Phong";
		else this.chucvu = "Nhan Vien";
 	}
}
class kieumau implements Serializable{
	LinkedList<thongtinnv> quanly = new LinkedList<>();
}
class qlns{
	static kieumau quanlyns = new kieumau();
	static Scanner luachon = new Scanner(System.in);
	static Scanner luachonit = new Scanner(System.in);
	static Scanner luachonch = new Scanner(System.in);
	static void nhapthongtin(){
		String ten;
		String ngaysinh;
		String cccd;
		System.out.print("Ho va ten: ");
		ten = luachon.nextLine();
		System.out.print("\nNgay sinh: ");
		ngaysinh = luachon.nextLine();
		System.out.print("\nCan Cuoc Cong Dan: ");
		cccd = luachon.nextLine();
		System.out.println("Chuc vu: \n1.Giam Doc\n2.Pho Giam Doc\n3.Truong Phong\n4.Nhan Vien");
		int i = luachonit.nextInt();
		quanlyns.quanly.add(new thongtinnv(ten,ngaysinh,cccd,i));
	}
	static void xuatthongtintong(){
		int t = 1;
		String a;
		System.out.println("Ban muon xem thong tin nhan thuoc chuc vu:\n1.Giam Doc\n2.Pho Giam Doc\n3.Truong Phong\n4.Nhan Vien"); 
		int i = luachonit.nextInt();
		if(i == 1) a = "Giam Doc";
		else if(i == 2) a = "Pho Giam Doc";
		else if(i == 1) a = "Truong Phong";
		else a = "Nhan Vien";
		for(thongtinnv tt : quanlyns.quanly) {
			if(tt.chucvu.equalsIgnoreCase(a)) {
				System.out.println(t+" Ho va ten: "+tt.ten+"\n Ngay Sinh: "+tt.ngaysinh+"\n CCCD: "+tt.cccd+"\n Chuc Vu: "+tt.chucvu);
				t++;
			}
		}
	}
	static void xuatttnv(int t){
		 System.out.println((t+1)+". Ho ten: "+quanlyns.quanly.get(t).ten+"\n Ngay Sinh"+quanlyns.quanly.get(t).ngaysinh+"\n CCCD: "+quanlyns.quanly.get(t).cccd+"\n Chuc Vu: Giam Doc");
	}
	static int timkiem(String hoten,int f){
		int i = 0,t,dstim = 0;
			for(t = 0; t<quanlyns.quanly.size();t++) {
				if((quanlyns.quanly.get(t).ten).equalsIgnoreCase(hoten)) { 
					System.out.println(t+". Ho va ten"+quanlyns.quanly.get(t).ten+"\n Chuc Vu: "+quanlyns.quanly.get(t).chucvu);
					i++;
					dstim = t;
					}
				}
			if(f == 3) {	 
				if(i == 1){
					System.out.println("Ban co muon xem thong tin chi tiet(Y/N): ");
					char a = luachonch.next().charAt(0);
					if(a == 'y'|| a=='Y') xuatttnv(dstim);
					return 0;
				}
				else{
					System.out.println("Co "+i+" truong hop phu hop voi yeu cau.");
					System.out.println("Ban muon xem thong tin cua truong hop nao: ");
					t =luachonit.nextInt();
					xuatttnv(t);
					return 0;
				}
			}
			else if(f == 4){
				if(i == 1) { 
				System.out.println("Ban co muon cap nhat thong tin cua truong hop tren(Y/N): ");
				char a = luachonch.next().charAt(0);
				if(a == 'y'|| a=='Y') return dstim;
				else return 0;
				}
				else{
					System.out.println("Co "+i+" truong hop phu hop voi yeu cau.");
					System.out.println("Ban muon cap nhat thong tin truong hop nao: ");
					t = luachonit.nextInt();
					return t-1;
				}
			}
			else{
				if(i == 1) { 
					System.out.println("Ban co muon xoa thong tin cua truong hop tren(Y/N): ");
					char a = luachonch.next().charAt(0);
					if(a == 'y'|| a=='Y') return dstim;
					else return 0;
					}
					else{
						System.out.println("Co "+i+" truong hop phu hop voi yeu cau.");
						System.out.println("Ban muon xoa truong hop nao: ");
						t = luachonit.nextInt();
						return t-1;
					}
			}
	}
	static void suathongtin(int tt){
		char tieptuc;
		do{
		System.out.println("Ban muon cap nhat thong tin nao: \n1.Ho va ten: \n2.Ngay Sinh: \n3.CCCD: ");
		int thongtin = luachonit.nextInt();
		System.out.print("Noi dung moi: ");
		String thaydoi = luachon.nextLine();
		if(thongtin == 1) quanlyns.quanly.get(tt).ten = thaydoi;
		else if(thongtin == 2) quanlyns.quanly.get(tt).ngaysinh = thaydoi;
		else quanlyns.quanly.get(tt).cccd = thaydoi;
		System.out.println("Cap nhat thanh cong.");
		System.out.print("Tiep tuc sua(Y/N): ");
		tieptuc = luachonch.next().charAt(0);
		}while(tieptuc == 'y'|| tieptuc == 'Y');
	}
	static void xoathongtin(){
		System.out.print("Ho ten nhan vien can xoa: ");
		String hoten = luachon.nextLine();
		int tt = timkiem(hoten,5);
		System.out.println("Muon xoa(Y/N): ");
		char xoa = luachonch.next().charAt(0);
		if(xoa == 'y' || xoa == 'Y') {
			quanlyns.quanly.remove(tt);
			System.out.println("Xoa thong tin thanh cong.");
		}
	}	
}
class write implements Runnable{
	kieumau quanlyns = new kieumau();
	write(kieumau quanlyns){
		this.quanlyns = quanlyns;
	}
	public void run(){
	try {
		FileOutputStream f = new FileOutputStream("dulieunhansu");
		ObjectOutputStream obb = new ObjectOutputStream(f);
		obb.writeObject(quanlyns);
		}
	catch(Exception e) {
		System.out.println("Loi ghi du lieu");
		}
	}
	
}
public class QLnhansu {

	public static void main(String[] args) {
		String hoten;
		int lc;
		char c;
		File dulieuns = new File("dulieunhansu");
		try{
		if(dulieuns.exists()) {
			FileInputStream f = new FileInputStream(dulieuns);
			ObjectInputStream obb = new ObjectInputStream(f);
			qlns.quanlyns = (kieumau)obb.readObject();
			}
		}
		catch(Exception e) {
			System.out.println("Loi doc file du lieu.");
		}
		try{
		do {
		System.out.println("\t\tHe Thong Quan Ly Nhan Su Tan Phat");
		System.out.println("1.Them nhan vien moi: \n2.Xuat Thong Tin Nhan Vien Thuoc Cac Chuc Vu:\n3.Tim kiem thong tin nhan vien\n4.Cap nhat thong tin nhan vien\n5.Xoa thong tin\n6.Thoat chuong trinh");
		lc = qlns.luachonit.nextInt();
		if(lc == 1) {	
			qlns.nhapthongtin();
		}
		else if(lc == 2) {
			qlns.xuatthongtintong();
		}
		else if(lc == 3) {
			System.out.print("Ho ten can tim: ");
			hoten = qlns.luachon.nextLine();
			int tt = qlns.timkiem(hoten, lc);
		}
		else if(lc == 4) {
			System.out.print("Ho ten truong hop can cap nhat: ");
			hoten = qlns.luachon.nextLine();
			qlns.suathongtin(qlns.timkiem(hoten, lc));
		}
		else if(lc == 5) qlns.xoathongtin();
		else break;
		System.out.print("Tiep tuc(Y/N): ");
		c = qlns.luachonch.next().charAt(0);
		}while(c == 'y'|| c =='Y');
		Thread t = new Thread(new write(qlns.quanlyns));
		t.run();
		}
		catch(Exception e) {
			System.out.println("Loi Chuong trinh."+e);
			
		}
	}
}

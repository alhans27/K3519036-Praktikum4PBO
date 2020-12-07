/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamahasiswa;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author GGibran
 */
public class Data {
    ArrayList<Mahasiswa> dataMhs = new ArrayList<>();
    
    void addData(Mahasiswa data){
        dataMhs.add(data);
    }
    
    void removeData(String nimMhs){
        dataMhs.removeIf(item -> item.nim.equals(nimMhs));
    }
    
    void getData(String nimMhs){
        System.out.println("\nData Mahasiswa : \n");
        
        boolean x = false;
        int index = -1;
        for (int i=0; i < dataMhs.size(); i++){
            if (dataMhs.get(i).nim.equals(nimMhs)){
                index = i;
                x = true;
            }
        }
        if (x == true){
            dataMhs.get(index).print();
                System.out.println("-------------------------\n");
        }else if(x == false){
            System.out.println("Data Tidak Ditemukan !\n");
        }
    }
    
    void getData(int genderMhs){
        System.out.println("\nData Mahasiswa : \n");
        
        boolean x = false;
        for (int i=0; i < dataMhs.size(); i++){
            if (dataMhs.get(i).gender == genderMhs){
                dataMhs.get(i).print();
                System.out.println("-------------------------\n");
                x = true;
            }
        }
        if (x == false){
            System.out.println("Data Tidak Ditemukan !\n");
        }
    }
    
    void tampilData(){
        System.out.println("\nData Mahasiswa : \n");
        for (Mahasiswa dataTampil : dataMhs){
            dataTampil.print();
            System.out.println("-------------------------\n");
        }
    }
    
    void input() throws ParseException{
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        while (true){
            System.out.println("=========== MENU UTAMA ===========\n");
            System.out.println("Silahkan Pilih Menu Berikut:\n"
                    + "1. Tambah Data\n"
                    + "2. Hapus Data\n"
                    + "3. Cari Data\n"
                    + "4. Tampilkan Data\n"
                    + "5. Keluar\n");
            System.out.print("Pilihan Menu : ");
            int menu = input.nextInt();
            String ex = input.nextLine();
            
            if (menu == 1){
                System.out.println("\n===========\nMENU TAMBAH DATA\n===========");
                System.out.print("Masukkan NIM Mahasiswa\t\t : ");
                String nim = input.nextLine();
                System.out.print("Masukkan Nama Mahasiswa\t\t : ");
                String nama = input.nextLine();
                System.out.print("Masukkan Tanggal lahir Mahasiswa\n(dd-mm-yyyy)\t\t\t : ");
                String tgl = input.nextLine();
                Date tglLahir = sdf.parse(tgl);
                System.out.print("Masukkan Jenis kelamin Mahasiswa\n(0 = laki-laki, 1 = perempuan)\t : ");
                int gender = input.nextInt();
                ex = input.nextLine();

                Mahasiswa data = new Mahasiswa(nim, nama, tglLahir, gender);
                addData(data);
                
                System.out.println("\nData Telah Ditambahkan !\n");
            }else if (menu == 2){
                System.out.println("\n===========\nMENU HAPUS DATA\nberdasarkan nim\n===========");
                System.out.print("Masukkan NIM dari data yang akan dihapus : ");
                String hapusNim = input.nextLine();
                removeData(hapusNim);
                System.out.println("\nData Dengan NIM : " + hapusNim + " Telah Dihapus\n");
            }else if (menu == 3){
                System.out.println("\n===========\nMENU CARI DATA\n===========");
                System.out.print("pilih :\n"
                        + "1. Cari Berdasarkan NIM\n"
                        + "2. Cari Berdasarkan Gender\n"
                        + "Pilihan : ");
                int menu2 = input.nextInt();
                ex = input.nextLine();
                if (menu2 == 1){
                    System.out.print("Masukkan NIM Mahasiswa : ");
                    String cariNim = input.nextLine();
                    getData(cariNim);
                }
                else if (menu2 == 2){
                    System.out.print("Masukkan Jenis Kelamin Mahasiswa\n(0 = Laki-laki, 1 = Perempuan) : ");
                    int cariGender = input.nextInt();
                    getData(cariGender);
                }
            }else if (menu == 4){
                tampilData();
                System.out.println("\nJumlah Data Mahasiswa : " + dataMhs.size() + "\n");
            }else if (menu == 5){
                break;
            }else{
                System.out.println("\n###############\nInput Tidak Valid, Silahkan Pilih Kembali\n###############\n");
            }
        }
    }
}

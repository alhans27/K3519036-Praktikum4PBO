/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamahasiswa;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author GGibran
 */
public class Mahasiswa {
    String nim;
    String nama;
    Date tglLahir;
    int gender;
    
    Mahasiswa(String nimMhs, String namaMhs, Date tglLahirMhs, int genderMhs){
        this.nim = nimMhs;
        this.nama = namaMhs;
        this.tglLahir = tglLahirMhs;
        this.gender = genderMhs;
    }
    
    void print(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String tampilTgl = sdf.format(tglLahir);
        String tampilGender = null;
        if (gender == 0){
            tampilGender = "Laki-laki";
        }else if (gender == 1){
            tampilGender = "Perempuan";
        }
        
        System.out.println("NIM Mahasiswa\t : " + nim);
        System.out.println("Nama Mahasiswa\t : " + nama);
        System.out.println("Tanggal Lahir\t : " + tampilTgl);
        System.out.println("Jenis Kelamin\t : " + tampilGender);
    }
}
